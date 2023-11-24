package domain;

import clase.Usuario;
import javafx.scene.control.Alert;

import java.sql.*;

public class UsuarioDAOImp implements UsuarioDAO{

    private static Connection connection;
    private static String loadUserSQL = "SELECT * FROM Usuario WHERE mail = ?";
    private static String createUserSQL = "INSERT INTO Usuario(mail, password, name) VALUES(?, ?, ?)";

    public UsuarioDAOImp(Connection conn) { connection = conn; }

    @Override
    public Usuario loadUser(String mail, String password) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement pS = connection.prepareStatement(loadUserSQL);
            pS.setString(1, mail);

            ResultSet loadedUser = pS.executeQuery();

            if (loadedUser.next()) {
                usuario.setId(loadedUser.getInt("id"));
                usuario.setName(loadedUser.getString("name"));
                usuario.setMail(loadedUser.getString("mail"));
                usuario.setPassword(loadedUser.getString("password"));

                if (!password.equals(usuario.getPassword())){
                    throw new RuntimeException("Password incorrecto");
                }
            } else {
                throw new RuntimeException("Email o contraseña incorrectos.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

    @Override
    public Usuario createUser(String mail, String password) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement pS = connection.prepareStatement(loadUserSQL);
            pS.setString(1, mail);

            ResultSet loadedUser = pS.executeQuery();

            if (loadedUser.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error de registro");
                alert.setHeaderText("El usuario existe");
                alert.setContentText("Pruebe con otro correo electronico.");
                alert.showAndWait();
                throw new RuntimeException("El usuario ya existe en la base de datos.");
            }

            PreparedStatement pSNewUser = connection.prepareStatement(createUserSQL, Statement.RETURN_GENERATED_KEYS);
            pSNewUser.setString(1,mail);
            pSNewUser.setString(2,password);
            pSNewUser.setString(3,mail);

            int affectedRows = pSNewUser.executeUpdate();

            ResultSet createdUserID = pSNewUser.getGeneratedKeys();

            if (createdUserID.next()) {
                usuario.setId(createdUserID.getInt(1));
                usuario.setMail(mail);
                usuario.setName(mail);
                usuario.setPassword(password);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}

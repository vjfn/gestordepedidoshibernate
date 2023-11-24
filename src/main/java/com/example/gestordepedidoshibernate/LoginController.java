package com.example.gestordepedidoshibernate;

import clase.Sesion;
import clase.Usuario;
import domain.DBConnection;
import domain.UsuarioDAOImp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * La clase LoginController controla la lógica de la ventana de Login.
 */
public class LoginController implements Initializable {

    @FXML
    private TextField userField;
    @FXML
    private PasswordField passField;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField registerUserField;
    @FXML
    private PasswordField registerPasswordField;
    @FXML
    private Button btnRegister;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void login(ActionEvent actionEvent) {
        String userMail = userField.getText();
        String userPassword = passField.getText();

        UsuarioDAOImp usuarioLogin = new UsuarioDAOImp(DBConnection.getConnection());
        try{
            Usuario usuario = usuarioLogin.loadUser(userMail,userPassword);
            Sesion.setUsuario(usuario);

            System.out.println("Exito al Logear");

            MainApplication.loadDahsboard();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void register(ActionEvent actionEvent) {
        String userMail = registerUserField.getText();
        String userPassword = registerPasswordField.getText();

        UsuarioDAOImp usuarioRegister = new UsuarioDAOImp(DBConnection.getConnection());

        try{
            Usuario usuario = usuarioRegister.createUser(userMail,userPassword);
            Sesion.setUsuario(usuario);

            System.out.println("Exito al registro");
            MainApplication.loadDahsboard();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
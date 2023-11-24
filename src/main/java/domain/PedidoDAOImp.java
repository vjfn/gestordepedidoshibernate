package domain;

import clase.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Implementación de la interfaz PedidoDAO que proporciona métodos para cargar elementos (pedidos) relacionados
 * con el usuario desde una base de datos.
 */
public class PedidoDAOImp implements PedidoDAO{

    private static Connection connection;
    public PedidoDAOImp(Connection conn) {
        this.connection = conn;
    }

    private final static String queryLoadAll = "select * from Pedido where usuario_id = ?";
    @Override
    public ArrayList<Pedido> loadAll(Integer id) {
        //Se crea un ArryList de 'Pedido', 'salida' donde se cargarán cada uno de los pedidos.
        ArrayList<Pedido> salida = new ArrayList<>();
        try {
            //Se prepara y ejecuta la consulta.
            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
            ItemDAOImp itemDAOImp = new ItemDAOImp(DBConnection.getConnection());
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            //Por cada resultado de la consulta se crea un objeto 'Pedido'.
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId(resultSet.getInt("id"));
                pedido.setCodigo(resultSet.getString("codigo"));

                //Formatea la fecha como cadena y la asigna al pedido.
                pedido.setDate(new SimpleDateFormat("yyyy-MM-dd").format(resultSet.getDate("date")));

                pedido.setUsuarioId(resultSet.getInt("usuario_id"));
                pedido.setTotal(resultSet.getInt("total"));

                //Carga los elementos (items) relacionados con el pedido.
                pedido.getItems().addAll(itemDAOImp.loadAll(pedido.getId()));

                //Establece el pedido actual en la sesión.
//              // Sesion.setPedido(pedido);
                //Se carga cada pedido en salida.
                salida.add(pedido);
            }
        } catch (SQLException e) {
            // En caso de error al cargar los items se lanza una excepción.
            throw new RuntimeException(e);
        }
        System.out.println(salida);
        return salida;
    }
}

package domain;

import clase.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementación de la interfaz ItemDAO que proporciona métodos para cargar elementos (items) relacionados
 * con sus pedidos desde una base de datos.
 */

import clase.Item;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ItemDAOImp implements ItemDAO {

    private Session session;

    public ItemDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public ArrayList<Item> loadAll(Integer codigoPedido) {
        ArrayList<Item> salida = new ArrayList<>();
        try {
            // Utilizamos HQL (Hibernate Query Language) en lugar de SQL.
            String hql = "FROM Item WHERE pedidoId = :codigoPedido";
            Query<Item> query = session.createQuery(hql, Item.class);
            query.setParameter("codigoPedido", codigoPedido);
            List<Item> results = query.list();

            // Añadimos los resultados a la salida.
            salida.addAll(results);

        } catch (Exception e) {
            // Manejar la excepción de Hibernate según tus necesidades.
            throw new RuntimeException("Error al cargar items: " + e.getMessage(), e);
        }
        return salida;
    }
}


//public class ItemDAOImp implements ItemDAO{
//
//    private static Connection connection;
//    private final static String queryLoadAll = "select * from lineapedido where pedido_id = ?";
//    public ItemDAOImp(Connection conn) {
//        connection = conn;
//    }
//    @Override
//    public ArrayList<Item> loadAll(Integer codigoPedido) {
//        //Se crea un ArryList de 'Item', 'salida', donde se cargarán cada uno de los items.
//        ArrayList<Item> salida = new ArrayList<>();
//        try {
//            //Se prepara y ejecuta la consulta.
//            PreparedStatement preparedStatement = connection.prepareStatement(queryLoadAll);
//            preparedStatement.setInt(1, codigoPedido);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            //Por cada resultado de la consulta se crea un objeto 'Item'.
//            while (resultSet.next()) {
//                Item item = new Item();
//                item.setId(resultSet.getInt("id"));
//                item.setPedidoId(resultSet.getString("pedido_id"));
//                item.setQty(resultSet.getInt("qty"));
//                item.setProducto_id(resultSet.getInt("producto_id")); ;
//
//
//                //Se carga la información de cada producto relacionado con cada item.
////                ProductoDAOImp productoDAOImp = new ProductoDAOImp(DBConnection.getConnection());
////                Producto producto = productoDAOImp.loadProduct(productId);
////                item.setProducto_id(producto);
//
//
//                //Se carga cada item en salida.
//                salida.add(item);
//            }
//        } catch (SQLException e) {
//            // En caso de error al cargar los items se lanza una excepción.
//            throw new RuntimeException(e);
//        }
//        return salida;
//    }
//}


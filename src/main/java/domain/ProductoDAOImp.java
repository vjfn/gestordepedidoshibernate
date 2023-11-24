package domain;

import clase.Producto;

import java.sql.Connection;

/**
 * Implementación de la interfaz ProductoDAO que proporciona métodos para cargar elementos (producto) relacionados
 * desde una base de datos.
 */
public class ProductoDAOImp implements ProductoDAO {

    private static Connection connection;

    private final static String queryLoad = "select * from Producto where id = ?";

    public ProductoDAOImp(Connection conn) {
        Connection connection = conn;
    }
    @Override
    public Producto loadProduct(Integer id) {
        return null;
    }
}

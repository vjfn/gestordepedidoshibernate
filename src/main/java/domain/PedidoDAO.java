package domain;

import clase.Pedido;

import java.util.ArrayList;

/**
 * La interfaz PedidoDAO contiene los métodos para acceder a los datos de los elementos (Pedido).
 */
public interface PedidoDAO {

    public ArrayList<Pedido> loadAll(Integer id);
}

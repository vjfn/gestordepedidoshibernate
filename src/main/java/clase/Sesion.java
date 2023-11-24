package clase;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;


/**
 * Almacena toda la información sobre la sesión actual del usuario.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sesion {

//    private static Pedido focusedOrder = null;
//    private static Usuario usuario;
//    private static Pedido pedido;
//
//    private static ArrayList<Pedido> pedidos = new ArrayList<>();
//    private static ArrayList<Producto> productos = new ArrayList<>();
//    private static ArrayList<Item> items = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Puedes ajustar el tipo de id según sea necesario.

    @OneToOne
    private static Usuario usuario;

    @OneToOne
    private static Pedido pedido;

    @OneToMany(mappedBy = "sesion", cascade = CascadeType.ALL)
    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "sesion", cascade = CascadeType.ALL)
    private static ArrayList<Producto> productos = new ArrayList<>();

    @OneToMany(mappedBy = "sesion", cascade = CascadeType.ALL)
    private static ArrayList<Item> items = new ArrayList<>();

    @OneToOne
    private static Pedido focusedOrder;

    // Getters y setters


    public static Pedido getFocusedOrder() {
        return focusedOrder;
    }

    public static void setFocusedOrder(Pedido focusedOrder) {
        Sesion.focusedOrder = focusedOrder;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Sesion.usuario = usuario;
    }

    public static Pedido getPedido() {
        return pedido;
    }

    public static void setPedido(Pedido pedido) {
        Sesion.pedido = pedido;
    }

    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public static void setPedidos(ArrayList<Pedido> pedidos) {
        Sesion.pedidos = pedidos;
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Sesion.productos = productos;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        Sesion.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

//public class Sesion {
//
//    private static Pedido focusedOrder = null;
//    private static Usuario usuario;
//    private static Pedido pedido;
//
//    private static ArrayList<Pedido> pedidos = new ArrayList<>();
//    private static ArrayList<Producto> productos = new ArrayList<>();
//    private static ArrayList<Item> items = new ArrayList<>();
//    public static Usuario getUsuario() {  return usuario; }
//    public static void setUsuario(Usuario usuario) {   Sesion.usuario = usuario; }
//
//    public static Pedido getPedido() {  return pedido; }
//    public static void setPedido(Pedido pedido) {   Sesion.pedido = pedido; }
//
//    public static ArrayList<Pedido> getPedidos() {
//        return pedidos;
//    }
//
//    public static void setPedidos(ArrayList<Pedido> pedidos) {
//        Sesion.pedidos = pedidos;
//    }
//
//    public static ArrayList<Producto> getProductos() {
//        return productos;
//    }
//
//    public static void setProductos(ArrayList<Producto> productos) {
//        Sesion.productos = productos;
//    }
//
//    public static ArrayList<Item> getItems() {
//        return items;
//    }
//
//    public static void setItems(ArrayList<Item> items) {
//        Sesion.items = items;
//    }
//
//    public static Pedido getFocusedOrder() {
//        return focusedOrder;
//    }
//
//    public static void setFocusedOrder(Pedido focusedOrder) {
//        Sesion.focusedOrder = focusedOrder;
//    }
//}

package clase;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene la información  del usuario, su ID, nombre, contraseña, mail y un arraylist de sus pedidos.
 */



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String mail;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario(Integer id, String name, String password, String mail) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mail = mail;
    }

    public Usuario(String mail, String password) {
        this.pedidos = new ArrayList<>();
        this.mail = mail;
        this.password = password;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + mail + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}

//public class Usuario {
//
//    private Integer id;
//    private String name;
//    private String password;
//    private String mail;
//    private ArrayList<Pedido> pedido;
//
//    public Usuario(Integer id, String name, String password, String mail) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.mail = mail;
//    }
//    public Usuario(String mail, String password)  {
//        this.pedido = new ArrayList<Pedido>();
//    }
//
//    public Usuario() {
//    }
//
//
//    public Integer getId() {
//        return id;
//    }
//
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//    public void setPassword(String password) {   this.password = password;  }
//
//    public String getMail() {
//        return mail;
//    }
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//
//    @Override
//    public String toString() {
//        return "Usuario{" +
//                "id=" + id +
//                ", nombre='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + mail + '\'' +
//                ", pedido=" + pedido +
//                '}';
//    }
//}

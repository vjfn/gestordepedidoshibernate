package clase;

import clase.Item;
import clase.Pedido;
import clase.Producto;
import clase.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Cargar la configuración de hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // Opcional: puedes agregar clases de entidad aquí, si no están configuradas en hibernate.cfg.xml
             configuration.addAnnotatedClass(Usuario.class);
             configuration.addAnnotatedClass(Pedido.class);
             configuration.addAnnotatedClass(Item.class);
             configuration.addAnnotatedClass(Producto.class);

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Fallo al crear la SessionFactory inicial: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

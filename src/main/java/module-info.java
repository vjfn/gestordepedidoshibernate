module com.example.gestordepedidoshibernate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens images;
    opens clase;
    opens domain;


    opens com.example.gestordepedidoshibernate to javafx.fxml;
    exports com.example.gestordepedidoshibernate;

    exports clase;
    exports domain;
}
module com.sebolaila {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.desktop;
    requires java.sql;
    requires net.bytebuddy;
    requires com.fasterxml.classmate;
    requires java.xml.bind;
    requires org.hibernate.orm.c3p0;

    opens com.sebolaila to javafx.fxml;
    opens com.sebolaila.entity;
    exports com.sebolaila;
}
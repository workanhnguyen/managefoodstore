module com.mycompany.project.management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.project.management to javafx.fxml;
    exports com.mycompany.project.management;

    exports com.nva.pojo;
    opens com.nva.pojo to javafx.fxml;

    exports com.nva.subclass;
    opens com.nva.subclass to javafx.fxml;

    exports com.nva.services;
    opens com.nva.services to javafx.fxml;
}

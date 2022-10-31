module com.mycompany.rmpage {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.rmpage to javafx.fxml;
    exports com.mycompany.rmpage;
}

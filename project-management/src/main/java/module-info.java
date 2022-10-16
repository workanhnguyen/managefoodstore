module com.mycompany.project.management {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.project.management to javafx.fxml;
    exports com.mycompany.project.management;
}

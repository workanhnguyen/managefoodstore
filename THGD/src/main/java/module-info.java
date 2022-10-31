module com.mycompany.thgd {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens com.mycompany.thgd to javafx.fxml;
    exports com.mycompany.thgd;
}

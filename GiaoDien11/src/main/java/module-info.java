module com.mycompany.giaodien11 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.giaodien11 to javafx.fxml;
    exports com.mycompany.giaodien11;
}

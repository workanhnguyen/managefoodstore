package com.mycompany.project.management;

import java.io.IOException;
import javafx.fxml.FXML;

public class HandleBillPageController {
    @FXML
    private void switchToEmployeeOrderPage() throws IOException {
        App.setRoot("employee-order-page");
    }
    
    @FXML
    private void switchToRegisterMemberPage() throws IOException {
        App.setRoot("register-member-page");
    }
}

package com.mycompany.project.management;

import java.io.IOException;
import javafx.fxml.FXML;

public class EmployeeOrderPageController {
    @FXML
    private void switchToEmployeeFunctionsPage() throws IOException {
        App.setRoot("employee-functions-page");
    }
    
    @FXML
    private void switchToHandleBillPage() throws IOException {
        App.setRoot("handle-bill-page");
    }
}

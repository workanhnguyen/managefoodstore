package com.mycompany.project.management;

import java.io.IOException;
import javafx.fxml.FXML;

public class EmployeeFunctionsPageController {
    
    @FXML
    private void switchToMainLoginPage() throws IOException {
        App.setRoot("main-login-page");
    }
}

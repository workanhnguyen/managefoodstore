/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import com.mycompany.project.management.App;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author ADMIN
 */
public class ManagerFunctionsPageController {
    @FXML
    private void switchToManageListOfEmployeePage() throws IOException {
        App.setRoot("manage-list-of-employee-page");
    }
     @FXML
    private void switchToStatisticCustomTime() throws IOException {
        App.setRoot("statistic-custom-time");
    }
    @FXML
    private void switchToManageMaterialStockPage() throws IOException {
        App.setRoot("manage-material-stock-page");
    }
    @FXML
    private void switchToMainLoginPage() throws IOException {
        App.setRoot("main-login-page");
    }
    
}

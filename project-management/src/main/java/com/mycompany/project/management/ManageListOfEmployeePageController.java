/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author ADMIN
 */
public class ManageListOfEmployeePageController {
    @FXML
    private void switchToRegisterNewEmployeePage() throws IOException {
        App.setRoot("register-new-employee-page");
    }
    @FXML
    private void switchToManagerFunctionsPage() throws IOException {
        App.setRoot("manager-functions-page");
    }
}

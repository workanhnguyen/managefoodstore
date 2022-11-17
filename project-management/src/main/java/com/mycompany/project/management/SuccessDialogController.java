/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author ASUS
 */
public class SuccessDialogController {
    @FXML
    private void switchToManageListOfEmployeePage() throws IOException {
        App.setRoot("manage-list-of-employee-page");
    }
}

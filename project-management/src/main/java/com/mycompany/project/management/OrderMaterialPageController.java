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
public class OrderMaterialPageController {
    @FXML
    private void switchToManageMaterialStockPage() throws IOException {
        App.setRoot("manage-material-stock-page");
    }
}

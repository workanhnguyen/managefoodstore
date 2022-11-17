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
public class StatisticMonthController {
   @FXML
    private void switchToStatisticCustomTime() throws IOException {
        App.setRoot("statistic-custom-time");
    } 
}

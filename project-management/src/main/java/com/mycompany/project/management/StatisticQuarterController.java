/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import com.mycompany.project.management.App;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.nva.pojo.TimeField;
import com.nva.services.TimeFieldServices;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 *
 * @author ADMIN
 */
public class StatisticQuarterController implements Initializable {
    @FXML private ComboBox<TimeField> cbTimeField;
    @FXML public void switchToManagerFunctionsPage() throws IOException {
        App.setRoot("manager-functions-page");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TimeFieldServices tf = new TimeFieldServices();
        List<TimeField> listTf = tf.getDanhSachTimeField();
        this.cbTimeField.setItems(FXCollections.observableList(listTf));
        this.cbTimeField.setPromptText(listTf.get(2).getName());
    }
    @FXML
    public void changTimeField(ActionEvent event) throws IOException {
        TimeField tf = cbTimeField.getValue();
        switch (tf.getId()) {
            case 1:
                App.setRoot("statistic-custom-time");
                break;
            case 2:
                App.setRoot("statistic-month");
                break;
            case 3:
                App.setRoot("statistic-quarter");
                break;
            case 4:
                App.setRoot("statistic-year");
                break;
        }
    }
}

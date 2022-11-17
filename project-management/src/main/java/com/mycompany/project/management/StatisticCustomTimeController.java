/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import com.nva.pojo.NhanVien;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.nva.pojo.TimeField;
import com.nva.services.NhanVienServices;
import com.nva.services.TimeFieldServices;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 *
 * @author ADMIN
 */
public class StatisticCustomTimeController implements Initializable {
    @FXML private ComboBox<TimeField> cbTimeField;
    @FXML public void switchToManagerFunctionsPage() throws IOException {
        App.setRoot("manager-functions-page");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TimeFieldServices tf = new TimeFieldServices();
        this.cbTimeField.setItems(FXCollections.observableList(tf.getDanhSachTimeField()));
    }
    @FXML
    private void switchToStatisticMonth() throws IOException {
        App.setRoot("statistic-month");
    }
     @FXML
    private void switchToStatisticQuater() throws IOException {
        App.setRoot("statistic-quater");
    }
     @FXML
    private void switchToStatisticYear() throws IOException {
        App.setRoot("statistic-year");
    }
}
//cái cmt là cái phần combobox để nhảy tới sự kiện chuyển trang nhưng mà không biết code đúng không, do tui không liên kết với fxml nên cũng không debug được
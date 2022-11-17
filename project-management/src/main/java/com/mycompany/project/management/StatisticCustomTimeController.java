/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import java.io.IOException;
import commonuse.ComboBoxTime;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 *
 * @author ADMIN
 */
public class StatisticCustomTimeController {
    @FXML
    private ComboBox cbTime;

    @FXML
    private void switchToManagerFunctionsPage() throws IOException {
        App.setRoot("manager-functions-page");
    }
//    @FXML
//    private ComboBox<String> cbxTime;
//    ObservableList<String> list=FXCollections.observableArrayList("Theo tháng","Theo quý","Theo năm");
//    @Override
//    public void initialize (URL url,ResourceBundle rb){
//       cbxTime.setItems(list);    
//    }
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
    @FXML
    private void switchModeTime() {
        String item1 = "Thống kê theo thời gian tùy chỉnh";
        String item2 = "Thống kê theo quý";
        String item3 = "Thống kê theo tháng";
        String item4 = "Thống kê theo năm";
        ComboBoxTime[] comboBoxTime = new ComboBoxTime[]{new ComboBoxTime(1, item1), new ComboBoxTime(2, item2),
                                        new ComboBoxTime(3, item3), new ComboBoxTime(4, item4)};
        cbTime.getItems().addAll(comboBoxTime);
        cbTime.getSelectionModel().select(1);
    }
}
//cái cmt là cái phần combobox để nhảy tới sự kiện chuyển trang nhưng mà không biết code đúng không, do tui không liên kết với fxml nên cũng không debug được
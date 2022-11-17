package com.mycompany.project.management;

import com.nva.pojo.TimeField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLComboBoxController implements Initializable {
    @FXML private ComboBox<TimeField> cbTimeField;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TimeField tf1 = new TimeField(1, "Thống kê theo thời gian tùy chỉnh");
        TimeField tf2 = new TimeField(2, "Thống kê theo tháng");
        TimeField tf3 = new TimeField(3, "Thống kê theo quý");
        TimeField tf4 = new TimeField(4, "Thống kê theo năm");
        List<TimeField> listTF = new ArrayList<>();
        listTF.add(tf1);
        listTF.add(tf2);
        listTF.add(tf3);
        listTF.add(tf4);
        this.cbTimeField.setItems(FXCollections.observableList(listTF));
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.nva.pojo.TimeField;
import com.nva.services.HoaDonServices;
import com.nva.services.NguoiDungServices;
import com.nva.services.PhieuMuaHangServices;
import com.nva.services.TimeFieldServices;
import commonuse.Utility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author ADMIN
 */
public class StatisticMonthController implements Initializable {
    // Khai báo biến FXML
    @FXML private ComboBox<TimeField> cbTimeField;
    @FXML private Label lbHoTen;
    @FXML private Label lbAlert;
    @FXML private Label lbTongVon;
    @FXML private Label lbTongThu;
    @FXML private Label lbTienLoi;
    @FXML private TextField tfThang;
    @FXML private TextField tfNam;
    // Khai báo biến thường
    PhieuMuaHangServices pmh_S = new PhieuMuaHangServices();
    HoaDonServices hd_S = new HoaDonServices();

    @FXML public void switchToManagerFunctionsPage() throws IOException {
        App.setRoot("manager-functions-page");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.lbHoTen.setText(NguoiDungServices.nguoiDung.getFullName());
        render();
    }
    @FXML private void btnThongKe() {
        String thangThongKe = tfThang.getText();
        String namThongKe = tfNam.getText();

        int errorCode_thangThongKe = Utility.kiemTraThangHopLe(thangThongKe);
        int errorCode_namThongKe = Utility.kiemTraNamHopLe(namThongKe);

        lbAlert.setText(null);
        String alertInfo = getThongBaoLoi(errorCode_thangThongKe, errorCode_namThongKe);

        if (errorCode_thangThongKe == 1 && errorCode_namThongKe == 1) {
            int tongVon = pmh_S.thongKeTheoThang(thangThongKe, namThongKe);
            int tongThu = hd_S.thongKeTheoThang(thangThongKe, namThongKe);

            lbTongVon.setText(String.valueOf(tongVon) + " VND");
            lbTongThu.setText(String.valueOf(tongThu) + " VND");
            lbTienLoi.setText(String.valueOf(tongThu - tongVon) + " VND");
        } else {
            lbAlert.setText(alertInfo);
        }
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
                App.setRoot("statistic-year");
                break;
        }
    }
    private void render() {
        TimeFieldServices tf = new TimeFieldServices();
        List<TimeField> listTf = tf.getDanhSachTimeField();
        this.cbTimeField.setItems(FXCollections.observableList(listTf));
        this.cbTimeField.setPromptText(listTf.get(1).getName());
    }
    private String getThongBaoLoi(int errorCode_thangThongKe, int errorCode_namThongKe) {
        String alertInfo = "";
        if (errorCode_thangThongKe == 0 || errorCode_namThongKe == 0)
            alertInfo += "Vui lòng nhập đầy đủ thông tin!\n";
        else {
            if (errorCode_thangThongKe == -1)
                alertInfo += "Định dạng tháng không hợp lệ!\n";
            else if (errorCode_thangThongKe == -2)
                alertInfo += "Tháng phải từ 1 đến 12\n";
            else {
                if (errorCode_namThongKe == -1)
                    alertInfo += "Định dạng năm không hợp lệ!\n";
                else if (errorCode_namThongKe == -2)
                    alertInfo += "Năm phải lớn hơn 1900\n";
            }
        }
        return alertInfo;
    }
}

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
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

    /**
 *
 * @author ADMIN
 */
public class StatisticCustomTimeController implements Initializable {
    // Khai báo biến FXML
    @FXML private Label lbHoTen;
    @FXML private Label lbAlert;
    @FXML private DatePicker dpThoiGianBatDau;
    @FXML private DatePicker dpThoiGianKetThuc;
    @FXML private Label lbTongVon;
    @FXML private Label lbTongThu;
    @FXML private Label lbTienLoi;
    @FXML private ComboBox<TimeField> cbTimeField;

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
        lbAlert.setText(null);
        LocalDate thoiGianBatDau = dpThoiGianBatDau.getValue();
        LocalDate thoiGianKetThuc = dpThoiGianKetThuc.getValue();
        if (thoiGianBatDau != null && thoiGianKetThuc != null) {
            if (thoiGianBatDau.compareTo(thoiGianKetThuc) < 0) {
                int tienVon = pmh_S.thongKeTongTienTheoThoiGianTuyChinh(thoiGianBatDau.toString(), thoiGianKetThuc.toString());
                int tienThu = hd_S.thongKeTongTienTheoThoiGianTuyChinh(thoiGianBatDau.toString(), thoiGianKetThuc.toString());
                lbTongVon.setText(tienVon + " VND");
                lbTongThu.setText(tienThu + " VND");
                lbTienLoi.setText((tienThu - tienVon) + " VND");
            } else {
                lbAlert.setText("Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc!\n");
            }
        } else {
            lbAlert.setText("Vui lòng nhập đầy đủ thông tin!\n");
        }
    }
    @FXML
    public void changTimeField() throws IOException {
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
        this.cbTimeField.setPromptText(listTf.get(0).getName());
    }
}
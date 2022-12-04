package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.nva.pojo.KhachHang;
import com.nva.services.KhachHangServices;
import com.nva.services.NguoiDungServices;
import commonuse.Utility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterMemberPageController implements Initializable {
    // Khai báo biến FXML
    @FXML private TextField tfHoKhachHang;
    @FXML private TextField tfTenKhachHang;
    @FXML private TextField tfSoDienThoai;
    @FXML private Label lbHoTen;
    @FXML private Label lbAlert;
    // Khai báo biến thường
    KhachHangServices kh = new KhachHangServices();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbHoTen.setText(NguoiDungServices.nguoiDung.getFullName());
    }
    @FXML
    private void btnDangKy() throws IOException {
        KhachHang khachHang = new KhachHang();
        khachHang.setHoKhachHang(tfHoKhachHang.getText().trim());
        khachHang.setTenKhachHang(tfTenKhachHang.getText().trim());
        khachHang.setMaKhachHang(tfSoDienThoai.getText().trim());
        khachHang.setDiemThuong(0);

        int errorCode_hoTen = Utility.kiemTraHoVaTenHopLe(khachHang.getHoKhachHang() + " " + khachHang.getTenKhachHang());
        int errorCode_soDienThoai = Utility.kiemTraSoDienThoaiHopLe(khachHang.getMaKhachHang());
        String alertInfo = "";
        if (errorCode_hoTen == 1 && errorCode_soDienThoai == 1) {
            if (!kh.kiemTraKhachHangTonTai(khachHang.getMaKhachHang())) {
                if(kh.addKhachHangMoi(khachHang)) {
                    Utility.showAlertDialog("Thông báo",
                            "Đăng ký thành công!", Alert.AlertType.INFORMATION);
                    App.setRoot("handle-bill-page");
                } else {
                    Utility.showAlertDialog("Thông báo",
                            "Đăng ký thất bại!", Alert.AlertType.ERROR);
                }
            } else {
                alertInfo = "Số điện thoại này đã tồn tại!";
            }
        } else {
            alertInfo = getThongBaoLoi(errorCode_hoTen, errorCode_soDienThoai);
        }
        lbAlert.setText(alertInfo);
    }
    @FXML
    private void switchToHandleBillPage() throws IOException {
        App.setRoot("handle-bill-page");
    }
    private String getThongBaoLoi(int errorCode_hoTen, int errorCode_soDienThoai) {
        String alertInfo = "";
        if (errorCode_hoTen == 0 || errorCode_soDienThoai == 0)
            alertInfo += "Vui lòng nhập đầy đủ thông tin!\n";
        else {
            if (errorCode_hoTen == -1)
                alertInfo += "Họ tên không hợp lệ!\n";
            else if (errorCode_hoTen == -2)
                alertInfo += "Họ tên quá dài!\n";
            else {
                if (errorCode_soDienThoai == -1)
                    alertInfo += "Số điện thoại không hợp lệ!\n";
                else if (errorCode_soDienThoai == -2)
                    alertInfo += "Số điện thoại phải bắt đầu bằng số '0'\n";
                else if (errorCode_soDienThoai == -3)
                    alertInfo += "Số điện thoại phải đủ 10 chữ số\n";
            }
        }
        return alertInfo;
    }
}

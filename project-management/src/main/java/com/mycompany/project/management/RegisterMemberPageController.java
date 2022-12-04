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

        int errorCode = kh.kiemTraDuLieuHopLe(khachHang);
        String alertInfo = "";
        if (errorCode == 1) {
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
        } else if (errorCode == 0) {
            alertInfo = "Vui lòng điền đầy đủ thông tin!";
        } else if (errorCode == -1 || errorCode == -2 || errorCode == -3) {
            alertInfo = "Định dạng số điện thoại không hợp lệ!";
        } else if (errorCode == -4) {
            alertInfo = "Họ hoặc tên quá dài!";
        }
        lbAlert.setText(alertInfo);
    }
    @FXML
    private void switchToHandleBillPage() throws IOException {
        App.setRoot("handle-bill-page");
    }
}

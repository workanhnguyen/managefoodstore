/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import com.mycompany.project.management.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.nva.services.NguoiDungServices;
import com.nva.services.NhanVienServices;
import commonuse.Utility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author ADMIN
 */
public class RegisterNewEmployeePageController implements Initializable {
    // Khai báo biến FXML
    @FXML private Label lbAlert;
    @FXML private Label lbHoTen;
    @FXML private TextField tfSoDienThoai;
    @FXML private PasswordField pfMatKhau;
    @FXML private PasswordField pfNhapLaiMatKhau;
    // Khai báo biến thường
    NhanVienServices nv_S = new NhanVienServices();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.lbHoTen.setText(NguoiDungServices.nguoiDung.getFullName());
    }
    @FXML
    private void btnDangKyNhanVien() {
        lbAlert.setText("");
        String alertInfo = getLoiDangKyTaiKhoan(tfSoDienThoai.getText(), pfMatKhau.getText(), pfNhapLaiMatKhau.getText());
        lbAlert.setText(alertInfo);
    }
    @FXML
    private void btnHuyThongTin() {

    }
    @FXML
    private void switchToManageListOfEmployeePage() throws IOException {
        App.setRoot("manage-list-of-employee-page");
    }
    @FXML
    private void switchToSuccessDialog() throws IOException {
        App.setRoot("success-dialog");
    }
    private String getLoiDangKyTaiKhoan(String soDienThoai, String matKhau, String nhapLaiMatKhau) {
        int errorCode_soDienThoai = Utility.kiemTraSoDienThoaiHopLe(soDienThoai);
        int errorCode_matKhau = Utility.kiemTraMatKhauHopLe(matKhau);
        String alertInfo = "";
        if (
                soDienThoai.isEmpty()
                        || matKhau.isEmpty()
                        || nhapLaiMatKhau.isEmpty()) {
            alertInfo += "Vui lòng nhập đầy đủ thông tin!\n";
        } else {
            if (errorCode_soDienThoai == -1 || errorCode_soDienThoai == -2 || errorCode_soDienThoai == -3) {
                alertInfo += "Số điện thoại không hợp lệ!\n";
            } else if (nv_S.kiemTraNhanVienTonTai(soDienThoai)) {
                alertInfo += "Số điện thoại đã tồn tại!\n";
            } else {
                if (!matKhau.equals(nhapLaiMatKhau)) {
                    alertInfo += "Mật khẩu không trùng khớp!\n";
                } else {
                    if (errorCode_matKhau == -1) {
                        alertInfo += "Mật khẩu không được chứa khoảng trắng!\n";
                    } else if (errorCode_matKhau == -2) {
                        alertInfo += "Mật khẩu phải chứa ít nhất:\n\t+ Một kí tự số\n\t+ Một kí tự chữ thường\n\t+ Một kí tự chữ hoa\n\t+ Một kí tự đặc biệt\n";
                    } else if (errorCode_matKhau == -3) {
                        alertInfo += "Mật khẩu phải từ 8 kí tự và bé hơn 20 kí tự\n";
                    } else {
                        if (errorCode_soDienThoai == 1 && errorCode_matKhau == 1) {
                            alertInfo += "Đăng ký thành công!";
                        }
                    }
                }
            }
        }
        return alertInfo;
    }
}

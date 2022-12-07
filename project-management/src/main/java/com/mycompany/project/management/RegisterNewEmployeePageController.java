/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.nva.pojo.NguoiDung;
import com.nva.pojo.NhanVien;
import com.nva.services.NguoiDungServices;
import com.nva.services.NhanVienServices;
import commonuse.Utility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    @FXML private TextField tfHoVaTen;
    @FXML private DatePicker dpNgaySinh;
    @FXML private TextField tfDiaChi;
    @FXML private DatePicker dpNgayVaoLam;
    @FXML private TextField tfLuongCoBan;
    @FXML private TextField tfHeSoLuong;
    // Khai báo biến thường
    NhanVienServices nv_S = new NhanVienServices();
    NguoiDungServices nd_S = new NguoiDungServices();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.lbHoTen.setText(NguoiDungServices.nguoiDung.getFullName());
    }
    @FXML
    private void btnDangKyNhanVien() throws IOException {
        int errorCode_soDienThoai = Utility.kiemTraSoDienThoaiHopLe(tfSoDienThoai.getText());
        int errorCode_matKhau = Utility.kiemTraMatKhauHopLe(pfMatKhau.getText());

        // Kiểm tra mục đăng ký tài khoản
        if (errorCode_soDienThoai != 1 || errorCode_matKhau != 1) {
            lbAlert.setText("");
            String alertInfo = getLoiDangKyTaiKhoan(tfSoDienThoai.getText(), pfMatKhau.getText(), pfNhapLaiMatKhau.getText());
            lbAlert.setText(alertInfo);
        } else if (errorCode_soDienThoai == 1 && errorCode_matKhau == 1){
            if (nv_S.kiemTraNhanVienTonTai(tfSoDienThoai.getText())) {
                lbAlert.setText("Số điện thoại đã tồn tại!");
            } else {
                // Kiểm tra thông tin đăng ký nhân viên
                int errorCode_hoTen = Utility.kiemTraHoVaTenHopLe(tfHoVaTen.getText());
                int errorCode_luongCoBan = Utility.kiemTraLuongHopLe(tfLuongCoBan.getText());
                int errorCode_heSoLuong = Utility.kiemTraHeSoLuongHopLe(tfHeSoLuong.getText());

                LocalDate ngaySinh = dpNgaySinh.getValue();
                LocalDate ngayVaoLam = dpNgayVaoLam.getValue();
                String diaChi = tfDiaChi.getText();

                if (
                        errorCode_hoTen == 1
                                && errorCode_luongCoBan == 1
                                && errorCode_heSoLuong == 1
                                && ngaySinh != null
                                && ngayVaoLam != null
                                && ngaySinh.compareTo(LocalDate.now()) < 0
                                && !diaChi.isEmpty() &&
                                !diaChi.isBlank()) {
                    // Thực hiện xử lý thêm dữ liệu nhân viên vào database
                    NguoiDung nd = new NhanVien();
                    nd.setId(tfSoDienThoai.getText());
                    nd.setMatKhau(pfMatKhau.getText());
                    nd.setHo(tfHoVaTen.getText().substring(0, tfHoVaTen.getText().lastIndexOf(" ")));
                    nd.setTen(tfHoVaTen.getText().substring(tfHoVaTen.getText().lastIndexOf(" ")));
                    nd.setDiaChi(tfDiaChi.getText());
                    nd.setVaiTro(false);
                    // Thực hiện thêm dữ liệu vào bảng nguoidung
                    if (nd_S.setNguoiDungMoi(nd, dpNgaySinh.getValue().toString())) {

                        NhanVien nv = new NhanVien();
                        nv.setMaNhanVien(nd.getId());
                        nv.setHeSoLuong(Float.parseFloat(tfHeSoLuong.getText()));
                        nv.setLuongCoBan(Integer.parseInt(tfLuongCoBan.getText()));

                        // Thực hiện thêm dữ liệu vào bảng nhanvien
                        if (nv_S.setNhanVienMoi(nv, dpNgayVaoLam.getValue().toString())) {
                            Utility.showAlertDialog("Thông báo",
                                    "Đăng ký nhân viên mới thành công!", Alert.AlertType.INFORMATION);
                            App.setRoot("manage-list-of-employee-page");
                        } else {
                            Utility.showAlertDialog("Thông báo",
                                    "Đăng ký nhân viên mới thất bại!", Alert.AlertType.ERROR);
                        }
                    } else {
                        Utility.showAlertDialog("Thông báo",
                                "Đăng ký nhân viên mới thất bại!", Alert.AlertType.ERROR);
                    }
                } else {
                    // Thực hiện xử lý hiển thị thông báo lỗi
                    String alertInfo = getLoiNhapThongTin(tfHoVaTen.getText(),
                            dpNgaySinh.getValue(), tfDiaChi.getText(),
                            dpNgayVaoLam.getValue(), tfHeSoLuong.getText(), tfLuongCoBan.getText());
                    lbAlert.setText(alertInfo);
                }
            }
        }

    }
    @FXML
    private void btnHuyThongTin() {
        tfSoDienThoai.setText("");
        pfMatKhau.setText("");
        pfNhapLaiMatKhau.setText("");
        tfHoVaTen.setText("");
        dpNgaySinh.setValue(null);
        dpNgayVaoLam.setValue(null);
        tfDiaChi.setText("");
        tfHeSoLuong.setText("");
        tfLuongCoBan.setText("");
        lbAlert.setText("");
    }
    @FXML
    private void switchToManageListOfEmployeePage() throws IOException {
        App.setRoot("manage-list-of-employee-page");
    }
    private String getLoiNhapThongTin(String hoTen, LocalDate ngaySinh, String diaChi, LocalDate ngayVaoLam, String heSoLuong, String luongCoBan) {
        int errorCode_hoTen = Utility.kiemTraHoVaTenHopLe(hoTen);
        int errorCode_luongCoBan = Utility.kiemTraLuongHopLe(luongCoBan);
        int errorCode_heSoLuong = Utility.kiemTraHeSoLuongHopLe(heSoLuong);

        String alertInfo = "";

        if (errorCode_hoTen == 0
                || errorCode_luongCoBan == 0
                || errorCode_heSoLuong == 0
                || ngaySinh == null
                || ngayVaoLam == null
                || diaChi.isEmpty()
                || diaChi.isBlank()
        ) {
            alertInfo += "Vui lòng nhập đầy đủ thông tin!\n";
        } else {
            if (errorCode_hoTen == -1)
                alertInfo += "Họ và tên không hợp lệ!\n";
            else if (errorCode_hoTen == -2)
                alertInfo += "Họ tên quá dài!\n";
            else {
                if (ngaySinh.compareTo(LocalDate.now()) >= 0)
                    alertInfo += "Ngày sinh không hợp lệ!\n";
                else {
                    if (errorCode_luongCoBan == -1)
                        alertInfo += "Định dạng lương không hợp lệ!\n";
                    else if (errorCode_luongCoBan == -2)
                        alertInfo += "Lương không được bé hơn hoặc bằng 0\n";
                    else {
                        if (errorCode_heSoLuong == -1)
                            alertInfo += "Định dạng hệ số lương không hợp lệ!\n";
                        else if (errorCode_heSoLuong == -2)
                            alertInfo += "Hệ số lương không được bé hơn hoặc bằng 0\n";
                    }
                }
            }
        }
        return alertInfo;
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

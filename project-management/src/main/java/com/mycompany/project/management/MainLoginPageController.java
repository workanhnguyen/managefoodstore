package com.mycompany.project.management;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.nva.pojo.NguoiDung;
import com.nva.pojo.NhanVien;
import com.nva.services.NguoiDungServices;
import com.nva.services.NhanVienServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainLoginPageController {

    //Khai bao FXML
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Label alertInfo;

    //Khai bao bien thuong
    NguoiDungServices n = new NguoiDungServices();
    List<NguoiDung> listNd = n.getDanhSachNguoiDung();
    @FXML
    private void login() throws IOException {
        if (Objects.equals(username.getText(), "") || Objects.equals(password.getText(), "")) {
            alertInfo.setText("Vui lòng nhập đầy đủ thông tin!");
        } else {
            for (NguoiDung nd: listNd) {
                if (!nd.getId().equals(username.getText()) || !nd.getMatKhau().equals(password.getText())) {
                    alertInfo.setText("Tên đăng nhập hoặc mật khẩu không chính xác!");
                } else {
                    if (nd.isVaiTro()) {
                        NguoiDungServices.nguoiDung = nd;
                        App.setRoot("manager-functions-page");
                    } else {
                        NguoiDungServices.nguoiDung = nd;
                        App.setRoot("employee-functions-page");
                    }
                }
            }
        }
    }
    @FXML
    private void closeApp() {
        System.exit(0);
    }
}

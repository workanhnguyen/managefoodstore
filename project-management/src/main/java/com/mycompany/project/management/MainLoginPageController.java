package com.mycompany.project.management;

import java.io.IOException;
import java.util.List;

import com.nva.pojo.NguoiDung;
import com.nva.services.NguoiDungServices;
import com.nva.services.NhanVienServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainLoginPageController {

    //Khai bao FXML
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private Label alertInfo;

    //Khai bao bien thuong
    NguoiDungServices n = new NguoiDungServices();
    List<NguoiDung> listNd = n.getDanhSachNguoiDung();
    @FXML
    private void login(ActionEvent event) throws IOException {
        if (username.getText() == "" || password.getText() == "") {
            alertInfo.setText("Vui lòng nhập đầy đủ thông tin!");
        } else {
            for (NguoiDung nd: listNd) {
                if (!nd.getId().equals(username.getText()) || !nd.getMatKhau().equals(password.getText())) {
                    alertInfo.setText("Tên đăng nhập hoặc mật khẩu không chính xác!");
                } else {
                    if (nd.isVaiTro() == true) {
                        NguoiDungServices.hoTen = nd.getHo() + " " + nd.getTen();
                        App.setRoot("manager-functions-page");
                    } else {
                        NhanVienServices.hoTen = nd.getHo() + " " + nd.getTen();
                        App.setRoot("employee-functions-page");
                    }
                }
            }
        }
//        App.setRoot("manager-functions-page");
    }
}

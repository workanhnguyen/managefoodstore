/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.nva.pojo.NhanVien;
import com.nva.services.NguoiDungServices;
import com.nva.services.NhanVienServices;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ADMIN
 */
public class ManageListOfEmployeePageController implements Initializable {
    // Khai báo biến FXML
    @FXML private Label lbHoTen;
    @FXML private TableView<NhanVien> tbvNhanVien;
    @FXML private TableColumn<NhanVien, String> tbvNhanVien_soDienThoai;
    @FXML private TableColumn<NhanVien, String> tbvNhanVien_ho;
    @FXML private TableColumn<NhanVien, String> tbvNhanVien_ten;
    @FXML private TableColumn<NhanVien, String> tbvNhanVien_ngaySinh;
    @FXML private TableColumn<NhanVien, String> tbvNhanVien_diaChi;
    @FXML private TableColumn<NhanVien, String> tbvNhanVien_ngayVaoLam;
    @FXML private TableColumn<NhanVien, String> tbvNhanVien_heSoLuong;
    @FXML private TableColumn<NhanVien, String> tbvNhanVien_luongCoBan;
    // Khai báo biến thường
    NhanVienServices nv_S = new NhanVienServices();
    private List<NhanVien> listNv = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.lbHoTen.setText(NguoiDungServices.nguoiDung.getFullName());
        render();
    }
    @FXML
    private void switchToRegisterNewEmployeePage() throws IOException {
        App.setRoot("register-new-employee-page");
    }
    @FXML
    private void switchToManagerFunctionsPage() throws IOException {
        App.setRoot("manager-functions-page");
    }
    private void render() {
        listNv = nv_S.getDanhSachNhanVien();

        tbvNhanVien_soDienThoai.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("id"));
        tbvNhanVien_ho.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("ho"));
        tbvNhanVien_ten.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("ten"));
        tbvNhanVien_ngaySinh.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("ngaySinh"));
        tbvNhanVien_diaChi.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("diaChi"));
        tbvNhanVien_ngayVaoLam.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("ngayVaoLam"));
        tbvNhanVien_heSoLuong.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("heSoLuong"));
        tbvNhanVien_luongCoBan.setCellValueFactory(new PropertyValueFactory<NhanVien, String>("luongCoBan"));

        tbvNhanVien.setItems(FXCollections.observableArrayList(listNv));
    }
}

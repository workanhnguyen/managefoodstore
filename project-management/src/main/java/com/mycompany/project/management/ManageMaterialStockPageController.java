/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import com.mycompany.project.management.App;
import com.nva.pojo.NguyenLieu;
import com.nva.services.NguoiDungServices;
import com.nva.services.NguyenLieuServices;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ADMIN
 */
public class ManageMaterialStockPageController implements Initializable{
    @FXML private Label lbHoTen;
    @FXML
    private TableView<NguyenLieu> tableNL;
    @FXML
    private TableColumn<NguyenLieu,String> idNguyenLieuColumn;
    @FXML
    private TableColumn<NguyenLieu,String> tenNguyenLieuColumn;
    @FXML
    private TableColumn<NguyenLieu,Integer> soLuongColumn;
    @FXML
    private TableColumn<NguyenLieu,String> donViColumn;
    @FXML
    private Button btnDatHang;
    private boolean eventOnMousePressDatHang;
    NguyenLieuServices nl = new NguyenLieuServices ();
    
    List<NguyenLieu> showNguyenLieu = nl.getDanhSachNguyenLieu();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lbHoTen.setText(NguoiDungServices.nguoiDung.getFullName());
        idNguyenLieuColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("maNguyenLieu"));
        tenNguyenLieuColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("tenNguyenLieu"));
        soLuongColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, Integer>("soLuong"));
        donViColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("donVi"));
        tableNL.setItems(FXCollections.observableArrayList(showNguyenLieu));
    }
    @FXML
    private void switchToManagerFunctionsPage() throws IOException {
        App.setRoot("manager-functions-page");
    }
    @FXML
    private void switchToOrderMaterialPage() throws IOException {
        App.setRoot("order-material-page");
    }
}
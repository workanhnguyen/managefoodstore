/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import com.nva.pojo.NguyenLieu;
import com.nva.pojo.PhieuMuaHang;
import com.nva.services.NguoiDungServices;
import com.nva.services.NguyenLieuServices;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;

import com.nva.services.PhieuMuaHangServices;
import commonuse.CauHinh;
import commonuse.Utility;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author ASUS
 */
public class OrderMaterialPageController implements Initializable{
    // Khai báo biến FXML
    @FXML private TableView<NguyenLieu> tableNL;
    @FXML private TableColumn<NguyenLieu,String> idNguyenLieuColumn;
    @FXML private TableColumn<NguyenLieu,String> tenNguyenLieuColumn;
    @FXML private TableColumn<NguyenLieu,Integer> soLuongColumn;
    @FXML private Button btnDatThem;
    @FXML private Button btnHuyDat;
    @FXML private Button btnXuatPhieu;
    @FXML private Label lbAlert;
    @FXML private Label lbHoTen;
    @FXML private Label lbmaNL;
    @FXML private Label lbtenNL;
    @FXML private Label lbmaHoaDon;
    @FXML private Label lbThanhTien;
    @FXML private TextField txtSLMua;
    @FXML private TextField txtDonGiaMua;
    // Khai báo biến thường
    private int Dem;
    NguyenLieuServices nl_S = new NguyenLieuServices ();
    PhieuMuaHangServices pmh_S = new PhieuMuaHangServices();
    List<NguyenLieu> showNguyenLieuThieu = nl_S.showNguyenLieuThieu();
    private PhieuMuaHang phieuMuaHang;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lbHoTen.setText(NguoiDungServices.nguoiDung.getFullName());
        render();
    }
    @FXML
    private void switchToManageMaterialStockPage() throws IOException {
        App.setRoot("manage-material-stock-page");
    }
    @FXML
    private void showThanhTien() {
        if (Utility.kiemTraDonGiaHopLe(txtDonGiaMua.getText()) == 1 && Utility.kiemTraSoLuongHopLe(txtSLMua.getText()) == 1) {
            lbThanhTien.setText(Integer.parseInt(txtDonGiaMua.getText()) * Integer.parseInt(txtSLMua.getText()) + " VND");
        } else {
            lbThanhTien.setText("0 VND");
        }
    }
    public void btnDatThemNL(){
        phieuMuaHang = new PhieuMuaHang();
        NguyenLieu selectedItem = tableNL.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            txtSLMua.setEditable(true);
            txtSLMua.setDisable(false);
            txtDonGiaMua.setEditable(true);
            txtDonGiaMua.setDisable(false);

            phieuMuaHang.setMaPhieuMuaHang(pmh_S.getMaPhieuMuaHangLonNhat());
            phieuMuaHang.setMaNguyenLieu(selectedItem.getMaNguyenLieu());

            lbmaHoaDon.setText(phieuMuaHang.getMaPhieuMuaHang());
            lbmaNL.setText(selectedItem.getMaNguyenLieu());
            lbtenNL.setText(selectedItem.getTenNguyenLieu());
        }
    }
    public void btnHuyDatHang(){
        lbmaNL.setText(null);
        lbtenNL.setText(null);
        lbmaHoaDon.setText(null);
        txtSLMua.setText(null);
        txtDonGiaMua.setText(null);
        lbThanhTien.setText(null);

        txtSLMua.setEditable(false);
        txtSLMua.setDisable(true);
        txtDonGiaMua.setEditable(false);
        txtDonGiaMua.setDisable(true);
    }
    public void btnXuatPhieuDatHang() throws ParseException, IOException {
        if (lbmaHoaDon.getText().isEmpty() || lbmaHoaDon.getText().isBlank()) {
            Utility.showAlertDialog("Thông báo",
                    "Vui lòng chọn 1 nguyên liệu!", Alert.AlertType.INFORMATION);
        } else {

            int errorCode_soLuongMatHang = Utility.kiemTraSoLuongHopLe(txtSLMua.getText());
            int errorCode_donGiaMatHang = Utility.kiemTraDonGiaHopLe(txtDonGiaMua.getText());

            if (errorCode_donGiaMatHang == 1 && errorCode_soLuongMatHang == 1) {
                phieuMuaHang.setSoLuongMatHang(Integer.parseInt(txtSLMua.getText()));
                phieuMuaHang.setDonGiaMatHang(Integer.parseInt(txtDonGiaMua.getText()));
                phieuMuaHang.setNgayNhapPhieu(CauHinh.date);

                if (pmh_S.setPhieuNhapHang(phieuMuaHang) && nl_S.capNhatSoLuongNguyenLieu(phieuMuaHang.getMaNguyenLieu(), phieuMuaHang.getSoLuongMatHang())) {
                    Utility.showAlertDialog("Thông báo",
                            "Xuất phiếu thành công!", Alert.AlertType.INFORMATION);
                    App.setRoot("manage-material-stock-page");
                } else {
                    Utility.showAlertDialog("Thông báo",
                            "Xuất phiếu thất bại!", Alert.AlertType.ERROR);
                }
            } else {
                lbAlert.setText(getThongBaoLoi(errorCode_soLuongMatHang, errorCode_donGiaMatHang));
            }
        }
    }
    private void render() {
        idNguyenLieuColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("maNguyenLieu"));
        tenNguyenLieuColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("tenNguyenLieu"));
        soLuongColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, Integer>("soLuong"));
        tableNL.setItems(FXCollections.observableArrayList(showNguyenLieuThieu));
    }
    private String getThongBaoLoi(int errorCode_soLuongMatHang, int errorCode_donGiaMatHang) {
        String alertInfo = "";
        if (errorCode_donGiaMatHang == 0 || errorCode_soLuongMatHang == 0)
            alertInfo += "Vui lòng nhập đầy đủ thông tin!\n";
        else {
            if (errorCode_soLuongMatHang == -1)
                alertInfo += "Số lượng không hợp lệ!\n";
            else if (errorCode_soLuongMatHang == -2)
                alertInfo += "Số lượng phải lớn hơn 0\n";
            else {
                if (errorCode_donGiaMatHang == -1)
                    alertInfo += "Đơn giá không hợp lệ!\n";
                else if (errorCode_donGiaMatHang == -2)
                    alertInfo += "Đơn giá phải lớn hơn 0\n";
            }
        }
        return alertInfo;
    }
}



package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.nva.pojo.Ban;
import com.nva.pojo.MonAn;
import com.nva.pojo.NguyenLieu;
import com.nva.pojo.NguyenLieu_MonAn;
import com.nva.services.*;
import com.nva.subclass.NumOfDish;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeOrderPageController implements Initializable {
    //Khai báo biến FXML
    @FXML private Label hoTen;
    @FXML private Label maBan;
    //-----------------------------------------------------------
    @FXML private TableView<MonAn> tbvDish;
    @FXML private TableColumn<MonAn, String> tbvDish_tenMonAn;
    @FXML private TableColumn<MonAn, Integer> tbvDish_donGia;
    //-----------------------------------------------------------
    @FXML private TableView<NumOfDish> tbvOrderedDish;
    @FXML private TableColumn<NumOfDish, String> tbvOrderedDish_tenMonAn;
    @FXML private TableColumn<NumOfDish, Integer> tbvOrderedDish_donGia;
    @FXML private TableColumn<NumOfDish, Integer> tbvOrderedDish_soLuong;

    //Khai báo biến thường
    MonAnServices m = new MonAnServices();
    NguyenLieuServices nl = new NguyenLieuServices();
    NguyenLieu_MonAnServices nl_ma = new NguyenLieu_MonAnServices();
    BanServices b = new BanServices();
    List<MonAn> listMA = m.getDanhSachMonAn();
    List<NguyenLieu> listNL = nl.getDanhSachNguyenLieu();
    List<NguyenLieu_MonAn> listNL_MA = nl_ma.getDanhSachNguyenLieu_MonAn();
    List<Ban> listBan = b.getDanhSachBan();

    /**
     * Dùng để lưu danh sách các món đã đặt (order)
     */
    public static List<MonAn> listOrdered = new ArrayList<>();
    /**
     * Dùng cho xử lý hóa đơn sau này
     */
    public static List<NumOfDish> numList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.maBan.setText(chuanHoaMaBan(EmployeeFunctionsPageController.maBan));
        this.hoTen.setText(NhanVienServices.hoTen);
        render();
    }
    @FXML
    private void btnAddDish() throws SQLException {
        MonAn monAn = tbvDish.getSelectionModel().getSelectedItem();
        if (monAn != null) {
            boolean allowToAddDish;
            boolean allowToUseMaterial;

            List<String> danhSachMaNguyenLieu = nl_ma.getDanhSachMaNguyenLieu(monAn.getMaMonAn());

            allowToAddDish = nl.kiemTraTinhTrangNguyenLieu(danhSachMaNguyenLieu);
            allowToUseMaterial = nl.suDungNguyenLieu(danhSachMaNguyenLieu);

            hoTen.setText(String.valueOf(danhSachMaNguyenLieu.size()));
            if (allowToAddDish && allowToUseMaterial) {
                listOrdered.add(monAn);

                countDish();

                this.tbvOrderedDish_tenMonAn.setCellValueFactory(new PropertyValueFactory<NumOfDish, String>("tenMonAn"));
                this.tbvOrderedDish_donGia.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("donGia"));
                this.tbvOrderedDish_soLuong.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("soLuong"));
                this.tbvOrderedDish.setItems(FXCollections.observableArrayList(numList));
            } else {
                showAlertDialog("Thông báo",
                        "Không thể đặt món ăn do tình trạng nguyên liệu không đáp ứng!",
                        Alert.AlertType.ERROR);
            }
        }
    }
    @FXML
    private void btnDelDish() {
        NumOfDish dish = this.tbvOrderedDish.getSelectionModel().getSelectedItem();
        if (dish != null) {
            MonAn m = new MonAn(dish.getMaMonAn(), dish.getTenMonAn(), dish.getDonGia());
            List<String> danhSachMaNguyenLieu = nl_ma.getDanhSachMaNguyenLieu(m.getMaMonAn());

            for (int i = 0; i < listOrdered.size(); i++) {
                if (listOrdered.get(i).getMaMonAn().equals(dish.getMaMonAn())) {
                    if(nl.hoanTacNguyenLieu(danhSachMaNguyenLieu)) {
                        listOrdered.remove(i);
                        break;
                    }
                }
            }
            countDish();

            this.tbvOrderedDish_tenMonAn.setCellValueFactory(new PropertyValueFactory<NumOfDish, String>("tenMonAn"));
            this.tbvOrderedDish_donGia.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("donGia"));
            this.tbvOrderedDish_soLuong.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("soLuong"));
            this.tbvOrderedDish.setItems(FXCollections.observableArrayList(numList));
        }
    }
    @FXML
    private void btnConfirmOrderDish() {
        if (numList == null || numList.isEmpty()) {
            showAlertDialog("Thông báo", "Vui lòng chọn ít nhất một món!", Alert.AlertType.CONFIRMATION);
        } else {

        }
    }
    private void countDish() {
        List<MonAn> temp = listOrdered.stream().distinct().collect(Collectors.toList());
        numList = new ArrayList<>();
        for (MonAn monAn: temp) {
            NumOfDish numOfDish = new NumOfDish(monAn.getMaMonAn(), monAn.getTenMonAn(), monAn.getDonGia(), 1);
            numList.add(numOfDish);
        }
        for(int i = 0; i < numList.size(); i++) {
            int count = 1;
            for (int j = 0; j < listOrdered.size(); j++) {
                if (numList.get(i).getMaMonAn().equals(listOrdered.get(j).getMaMonAn())) {
                    numList.get(i).setSoLuong(count++);
                }
            }
        }
    }
    @FXML
    private void switchToEmployeeFunctionsPage() throws IOException {
        /** Reset lại danh sách các món đặt */
        try {
            for (int i = 0; i < numList.size(); i++) {
                for (int j = 0; j < numList.get(i).getSoLuong(); j++) {
                    nl.hoanTacNguyenLieu(nl_ma.getDanhSachMaNguyenLieu(numList.get(i).getMaMonAn()));
                }
            }
            numList.clear();
            listOrdered.clear();
        } catch (Exception e) {

        }
        finally {
            App.setRoot("employee-functions-page");
        }
    }

    /** Khởi tạo dữ liệu ban đầu khi nạp giao diện */
    private void render() {
        this.tbvDish_tenMonAn.setCellValueFactory(new PropertyValueFactory<MonAn, String>("tenMonAn"));
        this.tbvDish_donGia.setCellValueFactory(new PropertyValueFactory<MonAn, Integer>("donGia"));
        this.tbvDish.setItems(FXCollections.observableArrayList(listMA));
    }
    /** Chuẩn hóa mã bàn truyền vào */
    private String chuanHoaMaBan(String maBan) {
        String resultStr = "";
        switch (maBan) {
            case "BAN01":
                resultStr = "BÀN 01";
                break;
            case "BAN02":
                resultStr = "BÀN 02";
                break;
            case "BAN03":
                resultStr = "BÀN 03";
                break;
            case "BAN04":
                resultStr = "BÀN 04";
                break;
            case "BAN05":
                resultStr = "BÀN 05";
                break;
            case "BAN06":
                resultStr = "BÀN 06";
                break;
            case "BAN07":
                resultStr = "BÀN 07";
                break;
            case "BAN08":
                resultStr = "BÀN 08";
                break;
            case "BAN09":
                resultStr = "BÀN 09";
                break;
            case "BAN10":
                resultStr = "BÀN 10";
                break;
        }
        return resultStr;
    }
    /** Tạo và hiển thị một dialog thông báo */
    private void showAlertDialog(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}


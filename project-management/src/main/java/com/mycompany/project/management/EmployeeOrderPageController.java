package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.StringJoiner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.nva.pojo.MonAn;
import com.nva.pojo.NguyenLieu;
import com.nva.pojo.NguyenLieu_MonAn;
import com.nva.services.NguyenLieuServices;
import com.nva.services.NguyenLieu_MonAnServices;
import com.nva.subclass.NumOfDish;
import com.nva.services.MonAnServices;
import com.nva.services.NhanVienServices;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmployeeOrderPageController implements Initializable {
    //Khai báo biến FXML
    @FXML private Label hoTen;
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
    List<MonAn> listMA = m.getDanhSachMonAn();
    List<NguyenLieu> listNL = nl.getDanhSachNguyenLieu();
    List<NguyenLieu_MonAn> listNL_MA = nl_ma.getDanhSachNguyenLieu_MonAn();

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
        for (int i = 0; i < numList.size(); i++) {
            for (int j = 0; j < numList.get(i).getSoLuong(); j++) {
                nl.hoanTacNguyenLieu(nl_ma.getDanhSachMaNguyenLieu(numList.get(i).getMaMonAn()));
            }
        }
        numList.clear();
        listOrdered.clear();

        App.setRoot("employee-functions-page");
    }

    /** Khởi tạo dữ liệu ban đầu khi nạp giao diện*/
    private void render() {
        this.tbvDish_tenMonAn.setCellValueFactory(new PropertyValueFactory<MonAn, String>("tenMonAn"));
        this.tbvDish_donGia.setCellValueFactory(new PropertyValueFactory<MonAn, Integer>("donGia"));
        this.tbvDish.setItems(FXCollections.observableArrayList(listMA));
    }
}


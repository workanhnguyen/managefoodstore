package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.nva.pojo.MonAn;
import com.nva.subclass.NumOfDish;
import com.nva.services.MonAnServices;
import com.nva.services.NhanVienServices;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    List<MonAn> listMA = m.getDanhSachMonAn();
    public static List<MonAn> listOrdered = new ArrayList<>();
    public static List<NumOfDish> numList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.hoTen.setText(NhanVienServices.hoTen);
        render();
    }
    @FXML
    private void btnAddDish() {
        MonAn monAn = tbvDish.getSelectionModel().getSelectedItem();
        if (monAn != null) {
            listOrdered.add(monAn);

            countDish();

            this.tbvOrderedDish_tenMonAn.setCellValueFactory(new PropertyValueFactory<NumOfDish, String>("tenMonAn"));
            this.tbvOrderedDish_donGia.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("donGia"));
            this.tbvOrderedDish_soLuong.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("soLuong"));
            this.tbvOrderedDish.setItems(FXCollections.observableArrayList(numList));
        }
    }
    @FXML
    private void btnDelDish() {
        delDish();

        this.tbvOrderedDish_tenMonAn.setCellValueFactory(new PropertyValueFactory<NumOfDish, String>("tenMonAn"));
        this.tbvOrderedDish_donGia.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("donGia"));
        this.tbvOrderedDish_soLuong.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("soLuong"));
        this.tbvOrderedDish.setItems(FXCollections.observableArrayList(numList));
    }
    private void delDish() {
        NumOfDish dish = this.tbvOrderedDish.getSelectionModel().getSelectedItem();
        MonAn m = new MonAn(dish.getMaMonAn(), dish.getTenMonAn(), dish.getDonGia());

        for (int i = 0; i < listOrdered.size(); i++) {
            if (listOrdered.get(i).getMaMonAn().equals(dish.getMaMonAn())) {
                listOrdered.remove(i);
                break;
            }
        }
        countDish();
//        if(listOrdered.remove(m)) {
////            for (int i = 0; i < numList.size(); i++) {
////                if (numList.get(i).getSoLuong() == 0) break;
////                if (numList.get(i).getMaMonAn().equals(dish.getMaMonAn())) {
////                    numList.get(i).setSoLuong(numList.get(i).getSoLuong() - 1);
////                    hoTen.setText(numList.get(i).getTenMonAn() + numList.get(i).getSoLuong());
////                    break;
////                }
////            }
//            countDish();
//        }
        hoTen.setText(listOrdered.size() + "");
//        List<NumOfDish> result = numList.stream().filter(n -> n.getSoLuong() != 0).collect(Collectors.toList());
//        numList.clear();
//        numList = result;
//        boolean isExit = false;
//        for (int i = 0; i < numList.size(); i++) {
//            if (numList.get(i).getMaMonAn().equals(dish.getMaMonAn())) {
//                isExit = true;
//            }
//        }
//        if (isExit) {

//        } else {
//            hoTen.setText("Khong co");
//        }
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
        App.setRoot("employee-functions-page");
    }

    private void render() {
        this.tbvDish_tenMonAn.setCellValueFactory(new PropertyValueFactory<MonAn, String>("tenMonAn"));
        this.tbvDish_donGia.setCellValueFactory(new PropertyValueFactory<MonAn, Integer>("donGia"));
        this.tbvDish.setItems(FXCollections.observableArrayList(listMA));
    }
}


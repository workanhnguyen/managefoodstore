package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.nva.pojo.MonAn;
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
    @FXML private TableView<MonAn> tbvOrderedDish;
    @FXML private TableColumn<MonAn, String> tbvOrderedDish_tenMonAn;
    @FXML private TableColumn<MonAn, Integer> tbvOrderedDish_donGia;

    //Khai báo biến thường
    MonAnServices m = new MonAnServices();
    List<MonAn> listMA = m.getDanhSachMonAn();
    public static List<MonAn> listOrdered = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.hoTen.setText(NhanVienServices.hoTen);
        render();
    }
    @FXML
    private void addDish() {
        MonAn monAn = tbvDish.getSelectionModel().getSelectedItem();
        listOrdered.add(monAn);

        this.tbvOrderedDish_tenMonAn.setCellValueFactory(new PropertyValueFactory<MonAn, String>("tenMonAn"));
        this.tbvOrderedDish_donGia.setCellValueFactory(new PropertyValueFactory<MonAn, Integer>("donGia"));
        this.tbvOrderedDish.setItems(FXCollections.observableArrayList(listOrdered));
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

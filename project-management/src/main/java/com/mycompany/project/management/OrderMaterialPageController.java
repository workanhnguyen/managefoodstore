/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import com.nva.pojo.NguyenLieu;
import com.nva.pojo.PhieuMuaHang;
import com.nva.services.NguyenLieuServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author ASUS
 */
public class OrderMaterialPageController implements Initializable{
    @FXML
    private void switchToManageMaterialStockPage() throws IOException {
        App.setRoot("manage-material-stock-page");
    }      
    @FXML
    private TableView<NguyenLieu> tableNL;
    @FXML
    private TableColumn<NguyenLieu,String> idNguyenLieuColumn;
    @FXML
    private TableColumn<NguyenLieu,String> tenNguyenLieuColumn;
    @FXML
    private TableColumn<NguyenLieu,Integer> soLuongColumn;
    @FXML 
    private Button btnDatThem;
    @FXML 
    private Button btnHuyDat;
    @FXML 
    private Button btnXuatPhieu;
    @FXML 
    private Label lbmaNL;
    @FXML 
    private Label lbtenNL;
    @FXML 
    private Label lbmaHoaDon;
    @FXML
    private Label lbThanhTien;
    @FXML
    private TextField txtSLMua;
    @FXML
    private TextField txtDonGiaMua;
    
    private int Dem;
    
    NguyenLieuServices nl = new NguyenLieuServices ();
    List<NguyenLieu> showNguyenLieuThieu = nl.showNguyenLieuThieu();
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       idNguyenLieuColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("maNguyenLieu"));
       tenNguyenLieuColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("tenNguyenLieu"));
       soLuongColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, Integer>("soLuong"));
//       donViColumn.setCellValueFactory(new PropertyValueFactory<NguyenLieu, String>("donVi"));
       tableNL.setItems(FXCollections.observableArrayList(showNguyenLieuThieu));
    }
    public void btnDatThemNL(ActionEvent e){
       NguyenLieu selectedItem=tableNL.getSelectionModel().getSelectedItem();
       String maNguyenLieu=selectedItem.getMaNguyenLieu();
       String tenNguyenLieu=selectedItem.getTenNguyenLieu();
       lbmaNL.setText(maNguyenLieu);
       lbtenNL.setText(tenNguyenLieu);
       String maHoaDon=String.format("MH%08d", ++Dem );
       lbmaHoaDon.setText(maHoaDon);
    }
    public void btnHuyDatHang(ActionEvent e){
        lbmaNL.setText(null);
        lbtenNL.setText(null);
        lbmaHoaDon.setText(null);
        txtSLMua.setText(null);
        txtDonGiaMua.setText(null);
    }
    public void btnXuatPhieuDatHang(ActionEvent e) throws ParseException{
        int soLuongMua =Integer.parseInt(txtSLMua.getText());
        int donGiaMua =Integer.parseInt(txtDonGiaMua.getText());
        double thanhToan =soLuongMua*donGiaMua;
        lbThanhTien.setText(String.format("%.0f VND",thanhToan));
        String maHoaDon =lbmaHoaDon.getText();
        String maNguyenLieu =lbmaNL.getText();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = new GregorianCalendar();
        String ngayhientai = f.format(c.getTime());
        Date ngayNhapHang= (Date) f.parse(ngayhientai);
        
        
        
        PhieuMuaHang p = new PhieuMuaHang(maHoaDon, soLuongMua, donGiaMua, maNguyenLieu, ngayNhapHang);
        System.out.println(p.toString());
        NguyenLieuServices nls = new NguyenLieuServices();
        nls.setPhieuNhapHang(p);
    }
}



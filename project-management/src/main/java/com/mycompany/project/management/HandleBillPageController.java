package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.nva.pojo.*;
import com.nva.services.*;
import com.nva.subclass.NumOfDish;
import commonuse.CauHinh;
import commonuse.Utility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HandleBillPageController implements Initializable {
    //Khai báo biến FXML
    @FXML private Label lbHoTen;
    @FXML private Label lbMaHoaDon;
    @FXML private Label lbTenNhanVien;
    @FXML private Label lbMaBan;
    @FXML private Label lbMaKhachHang;
    @FXML private Label lbAlert;
    @FXML private TextField tfMaKhachHang;
    @FXML private TableView<KhachHang> tbvKhachHang;
    @FXML private TableColumn<KhachHang, String> tbvKhachHang_soDienThoai;
    @FXML private TableColumn<KhachHang, String> tbvKhachHang_hoKhachHang;
    @FXML private TableColumn<KhachHang, String> tbvKhachHang_tenKhachHang;
    @FXML private TableColumn<KhachHang, Integer> tbvKhachHang_diemThuong;
    @FXML private TableView<NumOfDish> tbvListOrdered;
    @FXML private TableColumn<NumOfDish, String>  tbvListOrdered_tenMonAn;
    @FXML private TableColumn<NumOfDish, Integer>  tbvListOrdered_donGia;
    @FXML private TableColumn<NumOfDish, Integer>  tbvListOrdered_soLuong;
    @FXML private TableColumn<NumOfDish, Integer>  tbvListOrdered_thanhTien;
    @FXML private Label lbTempTongTien;
    @FXML private Label lbGiamGia;
    @FXML private Label lbMainTongTien;
    @FXML private Label lbDiemCong;
    //Khai báo biến thường
    private boolean allowToDiscount;
    private boolean confirmDiscount;
    private KhachHang foundedCustomer;
    private static HoaDonTamThoi tempBill;
    private KhachHangServices kh = new KhachHangServices();
    private NguoiDungServices n = new NguoiDungServices();
    private BanServices b = new BanServices();
    private static HoaDonServices h = new HoaDonServices();
    private HoaDon_MonAnServices h_m = new HoaDon_MonAnServices();
    private HoaDonTamThoiServices tempH = new HoaDonTamThoiServices();
    private HoaDonTamThoi_MonAnServices tempH_M = new HoaDonTamThoi_MonAnServices();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lbHoTen.setText(NguoiDungServices.nguoiDung.getFullName());
        render();
    }
    @FXML
    private void btnTimKiemKhachHang(ActionEvent event) throws IOException {
        //Khi thực hiện tìm kiếm mới thì reset lại toàn bộ thuộc tính
        allowToDiscount = false;
        confirmDiscount = false;

        lbAlert.setText("");
        lbGiamGia.setText(0 + " VND");
        lbDiemCong.setText(0 + " điểm");
        lbMainTongTien.setText(tempBill.tinhTongTien() + " VND");

        foundedCustomer = new KhachHang();

        int errorCode = Utility.kiemTraSoDienThoaiHopLe(tfMaKhachHang.getText());
        if (errorCode == 1) {
            KhachHang khachHang = kh.getKhachHang(tfMaKhachHang.getText());
            if (khachHang != null) {
                lbDiemCong.setText((tempBill.tinhTongTien() / 100) + " điểm");

                allowToDiscount = true;
                foundedCustomer = khachHang;
            } else {
                allowToDiscount = false;

                Optional<ButtonType> result = Utility.showAlertDialog("Thông báo",
                        "Không tìm thấy dữ liệu. Đăng ký mới?", Alert.AlertType.CONFIRMATION);
                if (result.get() == ButtonType.OK) {
                    App.setRoot("register-member-page");
                }
            }
        } else if (errorCode == 0) {
            lbAlert.setText("Vui lòng nhập thông tin tìm kiếm!");
        } else if (errorCode == -1 || errorCode == -2 || errorCode == -3) {
            lbAlert.setText("Số điện thoại không hợp lệ!");
        }

        tbvKhachHang_soDienThoai.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("maKhachHang"));
        tbvKhachHang_hoKhachHang.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("hoKhachHang"));
        tbvKhachHang_tenKhachHang.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("tenKhachHang"));
        tbvKhachHang_diemThuong.setCellValueFactory(new PropertyValueFactory<KhachHang, Integer>("diemThuong"));
        tbvKhachHang.setItems(FXCollections.observableArrayList(foundedCustomer));
    }
    @FXML
    private void btnSuDungDiem() {
        confirmDiscount = false;
        if (allowToDiscount) {
            if (foundedCustomer.getDiemThuong() >= Utility.limitRewardPoint) {
                confirmDiscount = true;
                //Hiển thị kết quả ra giao diện
                lbMaKhachHang.setText(foundedCustomer.getMaKhachHang());
                lbGiamGia.setText(foundedCustomer.getDiemThuong() + " VND");
                lbMainTongTien.setText((tempBill.tinhTongTien() - foundedCustomer.getDiemThuong()) + " VND");
            } else {
                Utility.showAlertDialog("Thông báo",
                        String.format("Điểm chưa đủ ngưỡng quy đổi (>%d)", Utility.limitRewardPoint),
                        Alert.AlertType.ERROR);
            }
        } else {
            Utility.showAlertDialog("Thông báo",
                    "Vui lòng tìm thông tin khách hàng trước!",
                    Alert.AlertType.WARNING);
        }
    }
    @FXML
    private void btnThanhToanHoaDon() throws IOException, SQLException {
        Optional<ButtonType> option = Utility.showAlertDialog("Thông báo",
                "Xác nhận in hóa đơn?", Alert.AlertType.CONFIRMATION);
        if (option.get() == ButtonType.OK) {
            HoaDon hd = new HoaDon();

            tempBill.setMaHoaDon(h.getMaHoaDonLonNhat());

            hd.setMaHoaDon(tempBill.getMaHoaDon());
            hd.setThoiGian(CauHinh.date);
            hd.setMaNhanVien(tempBill.getMaNhanVien());
            hd.setMaBan(tempBill.getMaBan());
            if (foundedCustomer != null) {
                hd.setMaKhachHang(foundedCustomer.getMaKhachHang());
                // Nếu đã ấn "Sử dụng điểm"
                if (confirmDiscount) {
                    hd.setGiamGia(foundedCustomer.getDiemThuong());
                    kh.capNhatDiemThuong(foundedCustomer.getMaKhachHang(), tempBill.tinhTongTien() / 100);
                } else {
                    kh.capNhatDiemThuong(foundedCustomer.getMaKhachHang(),
                            foundedCustomer.getDiemThuong() + (tempBill.tinhTongTien() / 100));
                }
            }
            hd.setThanhTien(tempBill.tinhTongTien() - hd.getGiamGia());
            hd.setThoiGian(CauHinh.date);
            if(h.setHoaDonMoi(hd)) {
                boolean isValid = true;
                for (NumOfDish nd: tempBill.getListOrderedDish()) {
                    if (!h_m.kiemTraDuLieuHopLe(tempBill.getMaHoaDon(), nd.getMaMonAn())) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    for (NumOfDish nd: tempBill.getListOrderedDish()) {
                        HoaDon_MonAn hoaDon_MonAn = new HoaDon_MonAn(tempBill.getMaHoaDon(), nd.getMaMonAn(), nd.getSoLuong());
                        //Ghi dữ liệu vào cơ sở dữ liệu
                        h_m.setDuLieuMoi(hoaDon_MonAn);
                    }
                    if (tempH.deleteHoaDonTamThoi(tempBill.getMaHoaDon())) {
                        //Cập nhật lại trạng thái của bàn
                        b.capNhatTrangThai(tempBill.getMaBan(), 1);
                        // Xóa hóa đơn tạm thời
                        tempH.deleteHoaDonTamThoi(tempBill.getMaHoaDon());
                        Utility.showAlertDialog("Thông báo", "Thêm hóa đơn thành công!", Alert.AlertType.INFORMATION);
                        App.setRoot("employee-functions-page");
                    } else {
                        Utility.showAlertDialog("Thông báo", "Thêm hóa đơn thất bại! (ErrorCode: 001)", Alert.AlertType.ERROR);
                    }
                } else {
                    Utility.showAlertDialog("Thông báo", "Thêm hóa đơn thất bại! (ErrorCode: 002)", Alert.AlertType.ERROR);
                }
            } else {
                Utility.showAlertDialog("Thông báo", "Thêm hóa đơn thất bại! (ErrorCode: 003)", Alert.AlertType.ERROR);
            }
            tempBill = null;
        }
    }
    @FXML
    private void switchToRegisterMemberPage() throws IOException {
        App.setRoot("register-member-page");
    }
    @FXML
    private void switchToEmployeeFunctionsPage() throws IOException {
        App.setRoot("employee-functions-page");
    }
    private void render() {
        tempBill = new HoaDonTamThoi();
        tempBill = tempH.getHoaDonTamThoi(BanServices.ban.getMaBan());

        if (tempBill.getMaHoaDon() != null) {
            tempBill.setListOrderedDish(tempH_M.getDanhSachMonAnTamThoi(tempBill.getMaHoaDon()));
        }
        //Thực hiện render giao diện ở đây
        lbMaHoaDon.setText(tempBill.getMaHoaDon());
        lbTenNhanVien.setText(n.getFullName(tempBill.getMaNhanVien()));
        lbMaBan.setText(tempBill.getMaBan());

        this.tbvListOrdered_tenMonAn.setCellValueFactory(new PropertyValueFactory<NumOfDish, String>("tenMonAn"));
        this.tbvListOrdered_donGia.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("donGia"));
        this.tbvListOrdered_soLuong.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("soLuong"));
        this.tbvListOrdered_thanhTien.setCellValueFactory(new PropertyValueFactory<NumOfDish, Integer>("thanhTien"));
        this.tbvListOrdered.setItems(FXCollections.observableArrayList(tempBill.getListOrderedDish()));

        lbTempTongTien.setText(tempBill.tinhTongTien() + " VND");
        lbGiamGia.setText(0 + " VND");
        lbMainTongTien.setText((tempBill.tinhTongTien()) + " VND");
        lbDiemCong.setText(0 + " điểm");
    }
}

package com.nva.services;

import com.nva.pojo.KhachHang;
import commonuse.JdbcUtils;
import commonuse.Utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KhachHangServices {
    public List<KhachHang> getDanhSachKhachHang() {
        List<KhachHang> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT * FROM foodstoredb.khachhang"));
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getString("MaKhachHang"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getInt("DiemThuong"));
                danhSach.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public KhachHang getKhachHang(String maKhachHang) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT * \n" +
                    "FROM foodstoredb.khachhang\n" +
                    "WHERE MaKhachHang = '%s'", maKhachHang));
            if (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getString("MaKhachHang"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getInt("DiemThuong"));
                return kh;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean addKhachHangMoi(KhachHang kh) {
        if (kiemTraKhachHangTonTai(kh.getMaKhachHang()))
            return false;
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "INSERT INTO foodstoredb.khachhang(MaKhachHang, Ho, Ten, DiemThuong)\n" +
                    "VALUES('%s', '%s', '%s', %d)\n",
                    kh.getMaKhachHang(),
                    kh.getHoKhachHang(),
                    kh.getTenKhachHang(),
                    kh.getDiemThuong()));
            if (rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean capNhatDiemThuong(String maKhachHang, int diemThuong) {
        if (!kiemTraKhachHangTonTai(maKhachHang))
            return false;
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "UPDATE foodstoredb.khachhang \n" +
                    "SET DiemThuong = %d\n" +
                    "WHERE MaKhachHang = '%s'", diemThuong, maKhachHang));
            if (rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean kiemTraKhachHangTonTai(String maKhachHang) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT * \n" +
                    "FROM foodstoredb.khachhang\n" +
                    "WHERE MaKhachHang = '%s'", maKhachHang));
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /** Giá trị trả về sẽ tương ứng với các lỗi sau:
     * 1: Không có lỗi - Thành công
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự chữ hoặc kí tự đặc biệt
     * -2: chuỗi không bắt đầu bằng số 0
     * -3: chuỗi không đủ 10 kí tự
     * -4: chuỗi vượt quá độ dài cho phép
     */
    public int kiemTraDuLieuHopLe(KhachHang kh) {
        int checkMaKhachHang = Utility.kiemTraSoDienThoaiHopLe(kh.getMaKhachHang());
        if (checkMaKhachHang != 1) return checkMaKhachHang;
        else if (kh.getHoKhachHang().isEmpty() || kh.getHoKhachHang().isBlank()) return 0;
        else if (kh.getTenKhachHang().isEmpty() || kh.getTenKhachHang().isBlank()) return 0;
        else if (kh.getHoKhachHang().length() > 20) return -4;
        else if (kh.getTenKhachHang().length() > 30) return -4;
        else return 1;
    }
}

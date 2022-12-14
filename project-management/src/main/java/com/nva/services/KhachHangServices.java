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
                    "SELECT * FROM khachhang"));
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
                    "FROM khachhang\n" +
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
        else if (kh.getDiemThuong() != 0) return false;
        else if (this.kiemTraDuLieuHopLe(kh) != 1) return false;
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "INSERT INTO khachhang(MaKhachHang, Ho, Ten, DiemThuong)\n" +
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
        else if (diemThuong < 0) return false;
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "UPDATE khachhang \n" +
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
                    "FROM khachhang\n" +
                    "WHERE MaKhachHang = '%s'", maKhachHang));
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /** Gi?? tr??? tr??? v??? s??? t????ng ???ng v???i c??c l???i sau:
     * 1: Kh??ng c?? l???i - Th??nh c??ng
     * 0: chu???i r???ng
     * -1: chu???i ch???a k?? t??? ch??? ho???c k?? t??? ?????c bi???t
     * -2: chu???i kh??ng b???t ?????u b???ng s??? 0
     * -3: chu???i kh??ng ????? 10 k?? t???
     * -4: chu???i v?????t qu?? ????? d??i cho ph??p
     */
    public int kiemTraDuLieuHopLe(KhachHang kh) {
        int checkMaKhachHang = Utility.kiemTraSoDienThoaiHopLe(kh.getMaKhachHang());
        if (checkMaKhachHang != 1) return checkMaKhachHang;
        else if (kh.getHoKhachHang().isEmpty() || kh.getHoKhachHang().isBlank()) return 0;
        else if (kh.getTenKhachHang().isEmpty() || kh.getTenKhachHang().isBlank()) return 0;
        else if (kh.getHoKhachHang().length() > 40) return -4;
        else if (kh.getTenKhachHang().length() > 15) return -4;
        else return 1;
    }
}

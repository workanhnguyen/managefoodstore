package com.nva.services;

import com.nva.pojo.HoaDon_MonAn;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HoaDon_MonAnServices {
    public List<HoaDon_MonAn> getDanhSachHoaDon_MonAn() throws SQLException {
        List<HoaDon_MonAn> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT *\n" +
                    "FROM foodstoredb.hoadon_monan\n"));
            while (rs.next()) {
                HoaDon_MonAn hd_ma = new HoaDon_MonAn(rs.getString("MaHoaDon"),
                        rs.getString("MaHoaDon"),
                        rs.getInt("SoLuong"));
                danhSach.add(hd_ma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public boolean kiemTraDuLieuHopLe(String maHoaDon, String maMonAn) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT MaHoaDon, MaMonAn\n" +
                    "FROM foodstoredb.hoadon_monan\n" +
                    "WHERE MaHoaDon = '%s' AND MaMonAn = '%s'", maHoaDon, maMonAn));
            if (rs.next()) {
                if (rs.getString(1).equals(maHoaDon) && rs.getString(2).equals(maMonAn)) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean setDuLieuMoi(HoaDon_MonAn hd_ma) {
        if (!kiemTraDuLieuHopLe(hd_ma.getMaHoaDon(), hd_ma.getMaMonAn()))
            return false;
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "INSERT INTO foodstoredb.hoadon_monan(MaHoaDon, MaMonAn, SoLuong)\n" +
                    "VALUES('%s', '%s', %d)\n", hd_ma.getMaHoaDon(), hd_ma.getMaMonAn(), hd_ma.getSoLuong()));
            if (rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

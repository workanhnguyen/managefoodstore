package com.nva.services;

import com.nva.pojo.HoaDonTamThoi;
import com.nva.pojo.HoaDonTamThoi_MonAn;
import com.nva.subclass.NumOfDish;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HoaDonTamThoi_MonAnServices {
    public List<HoaDonTamThoi_MonAn> getDanhSachHoaDonTamThoi_MonAn() {
        List<HoaDonTamThoi_MonAn> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT *\n" +
                    "FROM foodstoredb.hoadontamthoi_monan\n"));

            while (rs.next()) {
                HoaDonTamThoi_MonAn tempHd_Ma = new HoaDonTamThoi_MonAn(
                        rs.getString("MaHoaDonTamThoi"),
                        rs.getString("MaMonAnTamThoi"),
                        rs.getString("TenMonAnTamThoi"),
                        rs.getInt("SoLuongTamThoi"),
                        rs.getInt("DonGiaTamThoi"),
                        rs.getInt("ThanhTienTamThoi"));
                danhSach.add(tempHd_Ma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }

    public boolean kiemTraDuLieuHopLe(String maHoaDonTamThoi, String maMonAnTamThoi) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT MaHoaDonTamThoi, MaMonAnTamThoi\n" +
                    "FROM foodstoredb.hoadontamthoi_monan\n" +
                    "WHERE MaHoaDonTamThoi = '%s' AND MaMonAnTamThoi = '%s'", maHoaDonTamThoi, maMonAnTamThoi));
            if(rs.next()) {
                if (rs.getString(1).equals(maMonAnTamThoi) && rs.getString(2).equals(maMonAnTamThoi)) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public List<NumOfDish> getDanhSachMonAnTamThoi(String maHoaDonTamThoi) {
        List<NumOfDish> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT MaMonAnTamThoi, TenMonAnTamThoi, SoLuongTamThoi, DonGiaTamThoi, ThanhTienTamThoi\n" +
                    "FROM hoadontamthoi_monan\n" +
                    "WHERE MaHoaDonTamThoi = '%s'", maHoaDonTamThoi));
            while (rs.next()) {
                NumOfDish n = new NumOfDish(
                        rs.getString("MaMonAnTamThoi"),
                        rs.getString("TenMonAnTamThoi"),
                        rs.getInt("DonGiaTamThoi"),
                        rs.getInt("SoLuongTamThoi"),
                        rs.getInt("ThanhTienTamThoi")
                );
                danhSach.add(n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public boolean setDuLieuHoaDonTamThoi_MonAnMoi(HoaDonTamThoi_MonAn tempHd_Ma) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "INSERT INTO hoadontamthoi_monan(MaHoaDonTamThoi, MaMonAnTamThoi, TenMonAnTamThoi, SoLuongTamThoi, DonGiaTamThoi, ThanhTienTamThoi)\n" +
                    "VALUES('%s', '%s', '%s', %d, %d, %d)",
                        tempHd_Ma.getMaHoaDonTamThoi(),
                        tempHd_Ma.getMaMonAnTamThoi(),
                        tempHd_Ma.getTenMonAnTamThoi(),
                        tempHd_Ma.getSoLuongTamThoi(),
                        tempHd_Ma.getDonGiaTamThoi(),
                        tempHd_Ma.getSoLuongTamThoi() * tempHd_Ma.getDonGiaTamThoi()
                    ));
            if(rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

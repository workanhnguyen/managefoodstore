package com.nva.services;

import com.nva.pojo.Ban;
import com.nva.pojo.HoaDonTamThoi;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HoaDonTamThoiServices {
    HoaDonServices h = new HoaDonServices();
    public List<HoaDonTamThoi> getDanhSachHoaDonTamThoi() {
        List<HoaDonTamThoi> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hoadontamthoi");

            while (rs.next()) {
                HoaDonTamThoi tempBill = new HoaDonTamThoi(
                        rs.getString("MaHoaDonTamThoi"),
                        rs.getString("MaNhanVienTamThoi"),
                        rs.getString("MaBanTamThoi"));
                danhSach.add(tempBill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public HoaDonTamThoi getHoaDonTamThoi(String maBanTamThoi) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT *\n" +
                    "FROM hoadontamthoi\n" +
                    "WHERE MaBanTamThoi = '%s'", maBanTamThoi));
            if (rs.next()) {
                HoaDonTamThoi tempBill = new HoaDonTamThoi(
                        rs.getString("MaHoaDonTamThoi"),
                        rs.getString("MaNhanVienTamThoi"),
                        rs.getString("MaBanTamThoi")
                );
                return tempBill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean setHoaDonTamThoi(HoaDonTamThoi hoaDonTamThoi) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "INSERT INTO hoadontamthoi(MaHoaDonTamThoi, MaNhanVienTamThoi, MaBanTamThoi)\n" +
                    "VALUES('%s', '%s', '%s')", hoaDonTamThoi.getMaHoaDon(), hoaDonTamThoi.getMaNhanVien(), hoaDonTamThoi.getMaBan()));
            if (rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean deleteHoaDonTamThoi(String maHoaDonTamThoi) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "DELETE FROM hoadontamthoi\n" +
                    "WHERE MaHoaDonTamThoi = '%s'", maHoaDonTamThoi));
            if (rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public String getMaHoaDonTamThoiLonNhat() {
        String newCode = "";
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT max(MaHoaDonTamThoi) FROM hoadontamthoi");
            if (rs.next()) {
                if (rs.getString(1) != null) {
                    int maxCode = Integer.parseInt(rs.getString(1)
                            .substring(2));
                    newCode = String.format("HD%08d", maxCode + 1);
                } else newCode = h.getMaHoaDonLonNhat();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCode;
    }
}

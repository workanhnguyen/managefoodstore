package com.nva.services;

import com.nva.pojo.HoaDon;
import com.nva.pojo.HoaDonTamThoi;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HoaDonServices {
    public static List<HoaDonTamThoi> listTempBill = new ArrayList<>();
    public List<HoaDon> getDanhSachHoaDon() {
        List<HoaDon> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hoadon");

            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString("MaHoaDon"), rs.getDate("ThoiGian"),
                        rs.getString("MaNV"), rs.getString("MaBan"), rs.getString("MaKhachHang"),
                        rs.getInt("GiamGia"), rs.getInt("ThanhTien"));
                danhSach.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public String getMaHoaDonLonNhat() throws SQLException {
        String newCode = "";
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT max(MaHoaDon) FROM hoadon");
            if (rs.next()) {
                if (rs.getString(1) != null) {
                    int maxCode = Integer.parseInt(rs.getString(1)
                            .substring(2));
                    newCode = String.format("HD%08d", maxCode + 1);
                } else newCode = "HD00000001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCode;
    }
    public boolean setHoaDonMoi(HoaDon hoaDon) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "INSERT INTO hoadon(MaHoaDon, ThoiGian, MaNV, MaBan, MaKhachHang, GiamGia, ThanhTien)\n" +
                    "VALUES('%s', '%d-%d-%d %d:%d:%d', '%s', '%s', '%s', %d, %d)",
                    hoaDon.getMaHoaDon(),
                    hoaDon.getThoiGian().getYear() + 1900,
                    hoaDon.getThoiGian().getMonth() + 1,
                    hoaDon.getThoiGian().getDate(),
                    hoaDon.getThoiGian().getHours(),
                    hoaDon.getThoiGian().getMinutes(),
                    hoaDon.getThoiGian().getSeconds(),
                    hoaDon.getMaNhanVien(),
                    hoaDon.getMaBan(),
                    hoaDon.getMaKhachHang(),
                    hoaDon.getGiamGia(),
                    hoaDon.getThanhTien()));
            if (rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public int thongKeTongTienTheoThoiGianTuyChinh(String thoiGianBatDau, String thoiGianKetThuc) {
        int sum = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                            "SELECT SUM(ThanhTien)\n" +
                            "FROM hoadon\n" +
                            "WHERE ThoiGian BETWEEN '%s 00:00:00' AND '%s 23:59:59'",
                    thoiGianBatDau,
                    thoiGianKetThuc));
            if (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
    public int thongKeTheoThang(String thang, String nam) {
        int sum = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT SUM(ThanhTien)\n" +
                    "FROM hoadon\n" +
                    "WHERE YEAR(ThoiGian) = '%s' AND MONTH(ThoiGian) = '%s'", nam, thang));
            if (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
    public int thongKeTheoNam(String nam) {
        int sum = 0;
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT SUM(ThanhTien)\n" +
                    "FROM hoadon\n" +
                    "WHERE YEAR(ThoiGian) = '%s'", nam));
            if (rs.next()) {
                sum = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
}

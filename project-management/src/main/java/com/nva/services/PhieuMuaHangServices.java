package com.nva.services;

import com.nva.pojo.PhieuMuaHang;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhieuMuaHangServices {
    public boolean setPhieuNhapHang(PhieuMuaHang pmh) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                            "INSERT INTO phieumuahang(MaPhieuMuaHang, SoLuongMatHang, DonGiaMatHang, MaNguyenLieu, NgayNhapPhieu, ThanhTien)\n" +
                            "VALUES('%s', %d, %d,'%s', '%d-%d-%d %d:%d:%d', %d)",
                    pmh.getMaPhieuMuaHang(),
                    pmh.getSoLuongMatHang(),
                    pmh.getDonGiaMatHang(),
                    pmh.getMaNguyenLieu(),
                    pmh.getNgayNhapPhieu().getYear() + 1900,
                    pmh.getNgayNhapPhieu().getMonth() + 1,
                    pmh.getNgayNhapPhieu().getDate(),
                    pmh.getNgayNhapPhieu().getHours(),
                    pmh.getNgayNhapPhieu().getMinutes(),
                    pmh.getNgayNhapPhieu().getSeconds(),
                    (pmh.getSoLuongMatHang() * pmh.getDonGiaMatHang())
                    ));
            if (rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public String getMaPhieuMuaHangLonNhat() {
        String newCode = "";
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT max(MaPhieuMuaHang) FROM phieumuahang");
            if (rs.next()) {
                if (rs.getString(1) != null) {
                    int maxCode = Integer.parseInt(rs.getString(1)
                            .substring(2));
                    newCode = String.format("MH%08d", maxCode + 1);
                } else newCode = "MH00000001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCode;
    }
}

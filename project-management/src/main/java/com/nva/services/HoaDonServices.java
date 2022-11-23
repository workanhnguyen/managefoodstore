package com.nva.services;

import com.nva.pojo.Ban;
import com.nva.pojo.HoaDon;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HoaDonServices {
    public List<HoaDon> getDanhSachHoaDon() {
        List<HoaDon> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM hoadon");

            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getString("MaHoaDon"), rs.getDate("ThoiGian"),
                        rs.getString("MaNV"), rs.getString("MaBan"), rs.getString("MaKhachHang"),
                        rs.getInt("GiamGia"));
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
            ResultSet rs = stm.executeQuery("SELECT max(MaHoaDon) FROM foodstoredb.hoadon");
            if (rs.next()) {
                int maxCode = Integer.parseInt(rs.getString(1)
                        .substring(2));
                newCode = String.format("HD%08d", maxCode + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newCode;
    }
}

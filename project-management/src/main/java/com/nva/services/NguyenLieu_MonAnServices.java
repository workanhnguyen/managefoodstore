package com.nva.services;

import com.nva.pojo.NguyenLieu_MonAn;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NguyenLieu_MonAnServices {
    public List<NguyenLieu_MonAn> getDanhSachNguyenLieu_MonAn() {
        List<NguyenLieu_MonAn> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM monan_nguyenlieu");

            while (rs.next()) {
                NguyenLieu_MonAn nl_ma = new NguyenLieu_MonAn(rs.getString("MaMonAn"), rs.getString("MaNguyenLieu"));
                danhSach.add(nl_ma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public List<String> getDanhSachMaNguyenLieu(String maMonAn) {
        List<String> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(
                    String.format("SELECT MaNguyenLieu\n" +
                                  "FROM monan_nguyenlieu\n" +
                                  "WHERE MaMonAn = '%s'", maMonAn));

            while (rs.next()) {
                String maNguyenLieu = rs.getString("MaNguyenLieu");
                danhSach.add(maNguyenLieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}

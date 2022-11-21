package com.nva.services;

import com.nva.pojo.MonAn;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MonAnServices {
    public List<MonAn> getDanhSachMonAn() {
        List<MonAn> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM monan");

            while (rs.next()) {
                MonAn ma = new MonAn(rs.getString("MaMonAn"), rs.getString("TenMonAn"), rs.getInt("DonGia"));
                danhSach.add(ma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}

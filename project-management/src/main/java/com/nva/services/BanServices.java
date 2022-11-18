/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.services;

import com.nva.pojo.Ban;
import commonuse.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class BanServices {
    public List<Ban> getDanhSachBan() {
        List<Ban> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM ban");

            while (rs.next()) {
                Ban b = new Ban(rs.getString("MaBan"), rs.getInt("SoLuongChoNgoi"),
                        rs.getBoolean("TinhTrang"));
                danhSach.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}

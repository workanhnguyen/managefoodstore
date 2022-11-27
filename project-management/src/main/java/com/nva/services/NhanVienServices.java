/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.services;

import com.nva.pojo.NhanVien;
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
public class NhanVienServices {
    public static NhanVien nhanVien = new NhanVien();
    public List<NhanVien> getDanhSachNhanVien() {
        List<NhanVien> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM nhanvien");

            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("Id"), rs.getFloat("HeSoLuong"),
                        rs.getInt("LuongCoBan"), rs.getDate("NgayVaoLam"));
                danhSach.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}

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

            for (NhanVien nv: danhSach) {
                rs = stm.executeQuery(String.format("SELECT * FROM nguoidung WHERE Id = '%s'", nv.getMaNhanVien()));
                if (rs.next()) {
                    nv.setMatKhau(rs.getString("MatKhau"));
                    nv.setHoNhanVien(rs.getString("Ho"));
                    nv.setTenNhanVien(rs.getString("Ten"));
                    nv.setNgaySinh(rs.getDate("NgaySinh"));
                    nv.setDiaChi(rs.getString("DiaChi"));
                    nv.setVaiTro(rs.getBoolean("VaiTro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public boolean kiemTraNhanVienTonTai(String soDienThoai) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("SELECT Id FROM nhanvien WHERE Id = '%s'", soDienThoai));

            if (rs.next()) {
                if (rs.getString("Id").equals(soDienThoai))
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean setNhanVienMoi(NhanVien nv, String ngayVaoLam) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "INSERT INTO nhanvien(Id, HeSoLuong, LuongCoBan, NgayVaoLam)\n" +
                    "VALUES('%s', %.1f, %d, '%s')",
                    nv.getMaNhanVien(),
                    nv.getHeSoLuong(),
                    nv.getLuongCoBan(),
                    ngayVaoLam));

            if (rs == 0) return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

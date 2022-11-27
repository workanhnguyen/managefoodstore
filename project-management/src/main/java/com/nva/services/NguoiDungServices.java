package com.nva.services;

import com.nva.pojo.NguoiDung;
import com.nva.pojo.NhanVien;
import commonuse.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungServices {
    public static NguoiDung nguoiDung = new NguoiDung();
    public List<NguoiDung> getDanhSachNguoiDung() {
        List<NguoiDung> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM nguoidung");

            while (rs.next()) {
                NguoiDung nd = new NguoiDung(rs.getString("Id"),
                        rs.getString("MatKhau"),
                        rs.getString("Ho"),
                        rs.getString("Ten"),
                        rs.getDate("NgaySinh"),
                        rs.getString("DiaChi"),
                        rs.getBoolean("VaiTro"));
                danhSach.add(nd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public String getFullName(String id) {
        String resultStr = "";
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT Ho, Ten\n" +
                    "FROM nguoidung\n" +
                    "WHERE Id = '%s'", id));

            if (rs.next()) {
                resultStr = rs.getString(1) + " " + rs.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultStr;
    }
}

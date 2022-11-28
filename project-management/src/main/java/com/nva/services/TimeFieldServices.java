/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.services;

import com.nva.pojo.TimeField;
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
public class TimeFieldServices {
    public List<TimeField> getDanhSachTimeField() {
        List<TimeField> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM TimeField");

            while (rs.next()) {
                TimeField tf = new TimeField(rs.getInt("Id"), rs.getString("Name"));
                danhSach.add(tf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
}

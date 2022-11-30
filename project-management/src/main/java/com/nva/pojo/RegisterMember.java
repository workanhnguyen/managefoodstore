/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.pojo;

import commonuse.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author sagit
 */
public class RegisterMember {
    public static boolean main(String[] args){
        List<KhachHang> danhSach = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("HoKhachHang: ");
        String hoKhachHang = sc.nextLine();
        System.out.print("TenKhachHang: ");
        String tenKhachHang = sc.nextLine();
        System.out.print("MaKhachHang: ");
        String maKhachHang = sc.nextLine();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(String.format("" +
                    "SELECT * \n" +
                    "FROM khachhang\n" +
                    "WHERE MaKhachHang = '%s'", maKhachHang));
            if(rs.next()){
                    return true;
            }else{
                KhachHang kh = new KhachHang(
                        rs.getString("MaKhachHang"),
                        rs.getString("Ho"),
                        rs.getString("Ten"));
                 if(hoKhachHang.equals("") && tenKhachHang.equals("") && maKhachHang.equals("")){
                     System.out.println("Vui lòng nhập đầy đủ thông tin!");
                 }else{
                     danhSach.add(kh);
                     System.out.println("Đăng ký thành viên mới thành công!");
                 }  
            }
        }catch(SQLException e){
            System.out.println("Kết nối thất bại!");
        }
        return false;
    }
}

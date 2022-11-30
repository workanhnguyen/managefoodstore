/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sagit
 */
public class MainLogin {
    private static Connection conn;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("username: ");
        String user = sc.nextLine();
        System.out.print("password: ");
        String pass = sc.nextLine();
        try{
            if(user.equals("") || pass.equals("")){
                System.out.println("Vui lòng nhập đầy đủ thông tin!");
            }else{
                String Url;
                Url = "jdbc:mysql://localhost:3306/foodstoredb; user = root; password = 123456781";
                Connection conn = DriverManager.getConnection(Url);
                String sql = "SELECT * FROM Users WHERE Username = ? AND Password = ?";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, user);
                stm.setString(2, pass);
                ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    System.out.println("Đăng nhập thành công!");
                }else{
                    System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác!");
                }
            }
        }catch(SQLException e){
            System.out.println("Kết nối thất bại!");
        }
    }
}

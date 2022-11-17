/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.pojo;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class QuanTriVien extends NguoiDung {
    public QuanTriVien() {
        super();
    }
    public QuanTriVien(String maQuanTriVien, String matKhau, String ho, String ten, Date ngaySinh, String diaChi, boolean vaiTro) {
        super(maQuanTriVien, matKhau, ho, ten, ngaySinh, diaChi, vaiTro);
    }
}

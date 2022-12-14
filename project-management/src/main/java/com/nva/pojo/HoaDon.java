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
public class HoaDon {
    private String maHoaDon;
    private Date thoiGian;
    private String maNhanVien;
    private String maBan;
    private String maKhachHang = "";
    private int giamGia = 0;
    private int thanhTien = 0;
    public HoaDon() {}
    public HoaDon(String maHoaDon, String maNhanVien, String maBan) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maBan = maBan;
    }
    public HoaDon(String maHoaDon, Date thoiGian, String maNhanVien, String maBan, String maKhachHang, int giamGia, int thanhTien) {
        this.maHoaDon = maHoaDon;
        this.thoiGian = thoiGian;
        this.maNhanVien = maNhanVien;
        this.maBan = maBan;
        this.maKhachHang = maKhachHang;
        this.giamGia = giamGia;
        this.setThanhTien(thanhTien);
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.pojo;

/**
 *
 * @author ASUS
 */
public class HoaDon_MonAn {
    private String maHoaDon;
    private String maMonAn;
    private int soLuong;
    public HoaDon_MonAn() {}
    public HoaDon_MonAn(String maHoaDon, String maMonAn, int soLuong) {
        this.maHoaDon = maHoaDon;
        this.maMonAn = maMonAn;
        this.soLuong = soLuong;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}

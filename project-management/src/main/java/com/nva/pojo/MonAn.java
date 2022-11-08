/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nva.pojo;

/**
 *
 * @author ASUS
 */
public class MonAn {
    private String maMonAn;
    private String tenMonAn;
    private int donGia;

    public MonAn(String maMonAn, String tenMonAn, int donGia) {
        this.maMonAn = maMonAn;
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
    }

    public MonAn() {

    }

    public String getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(String maMonAn) {
        this.maMonAn = maMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
}

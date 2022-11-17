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
public class NguoiDung {
    private String id;
    private String matKhau;
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String diaChi;
    private boolean vaiTro;

    public NguoiDung() {

    }
    public NguoiDung(String id, String matKhau, String ho, String ten, Date ngaySinh, String diaChi, boolean vaiTro) {
        this.id = id;
        this.matKhau = matKhau;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.vaiTro = vaiTro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }
}

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
public class NhanVien extends NguoiDung {
    private float heSoLuong;
    private int luongCoBan;
    private Date ngayVaoLam;
    public NhanVien() {
        super();
    }
    public NhanVien(
            String maNhanVien,
            String matKhau,
            String hoNhanVien,
            String tenNhanVien,
            Date ngaySinh,
            String diaChi,
            float heSoLuong,
            int luongCoBan,
            Date ngayVaoLam
            ) {
        super(maNhanVien, matKhau, hoNhanVien, tenNhanVien, ngaySinh, diaChi, false);
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
        this.ngayVaoLam = ngayVaoLam;
    }
    public NhanVien(String maNhanVien, float heSoLuong, int luongCoBan, Date ngayVaoLam) {
        super.setId(maNhanVien);
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
        this.ngayVaoLam = ngayVaoLam;
    }
    public String getMaNhanVien() {
        return super.getId();
    }
    public void setMaNhanVien(String maNhanVien) {
        super.setId(maNhanVien);
    }
    public String getMatKhau() {
        return super.getMatKhau();
    }
    public void setMatKhau(String matKhau) {
        super.setMatKhau(matKhau);
    }
    public String getHoNhanVien() {
        return super.getHo();
    }
    public void setHoNhanVien(String hoNhanVien) {
        super.setHo(hoNhanVien);
    }
    public String getTenNhanVien() {
        return super.getTen();
    }
    public void setTenNhanVien(String tenNhanVien) {
        super.setTen(tenNhanVien);
    }
    public Date getNgaySinh() {
        return super.getNgaySinh();
    }
    public void setNgaySinh(Date ngaySinh) {
        super.setNgaySinh(ngaySinh);
    }
    public String getDiaChi() {
        return super.getDiaChi();
    }
    public void setDiaChi(String diaChi) {
        super.setDiaChi(diaChi);
    }
    public boolean getVaiTro() {
        return super.isVaiTro();
    }
    public void setVaiTro(boolean vaiTro) {
        super.setVaiTro(vaiTro);
    }
    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }
}

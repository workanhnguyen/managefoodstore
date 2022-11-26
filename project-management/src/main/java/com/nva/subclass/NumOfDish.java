package com.nva.subclass;

//Các class phụ
public class NumOfDish {
    private String maMonAn;
    private String tenMonAn;
    private int donGia;
    private int soLuong;
    private int thanhTien;

    public NumOfDish() {
    }

    public NumOfDish(String maMonAn, String tenMonAn, int donGia, int soLuong) {
        this.setMaMonAn(maMonAn);
        this.setTenMonAn(tenMonAn);
        this.setDonGia(donGia);
        this.setSoLuong(soLuong);
    }
    public NumOfDish(String maMonAn, String tenMonAn, int donGia, int soLuong, int thanhTien) {
        this.setMaMonAn(maMonAn);
        this.setTenMonAn(tenMonAn);
        this.setDonGia(donGia);
        this.setSoLuong(soLuong);
        this.thanhTien = thanhTien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}

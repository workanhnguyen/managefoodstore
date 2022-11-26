package com.nva.pojo;

public class HoaDonTamThoi_MonAn {
    private String maHoaDonTamThoi;
    private String maMonAnTamThoi;
    private String tenMonAnTamThoi;
    private int soLuongTamThoi;
    private int donGiaTamThoi = 0;
    private int tongTienTamThoi = 0;

    public HoaDonTamThoi_MonAn() {}
    public HoaDonTamThoi_MonAn(String maHoaDonTamThoi, String maMonAnTamThoi, String tenMonAnTamThoi, int soLuongTamThoi, int donGiaTamThoi, int tongTienTamThoi) {
        this.setMaHoaDonTamThoi(maHoaDonTamThoi);
        this.setMaMonAnTamThoi(maMonAnTamThoi);
        this.setTenMonAnTamThoi(tenMonAnTamThoi);
        this.setSoLuongTamThoi(soLuongTamThoi);
        this.setDonGiaTamThoi(donGiaTamThoi);
        this.setTongTienTamThoi(tongTienTamThoi);
    }

    public String getMaHoaDonTamThoi() {
        return maHoaDonTamThoi;
    }

    public void setMaHoaDonTamThoi(String maHoaDonTamThoi) {
        this.maHoaDonTamThoi = maHoaDonTamThoi;
    }

    public String getMaMonAnTamThoi() {
        return maMonAnTamThoi;
    }

    public void setMaMonAnTamThoi(String maMonAnTamThoi) {
        this.maMonAnTamThoi = maMonAnTamThoi;
    }

    public int getSoLuongTamThoi() {
        return soLuongTamThoi;
    }

    public void setSoLuongTamThoi(int soLuongTamThoi) {
        this.soLuongTamThoi = soLuongTamThoi;
    }

    public int getDonGiaTamThoi() {
        return donGiaTamThoi;
    }

    public void setDonGiaTamThoi(int donGiaTamThoi) {
        this.donGiaTamThoi = donGiaTamThoi;
    }

    public int getTongTienTamThoi() {
        return tongTienTamThoi;
    }

    public void setTongTienTamThoi(int tongTienTamThoi) {
        this.tongTienTamThoi = tongTienTamThoi;
    }

    public String getTenMonAnTamThoi() {
        return tenMonAnTamThoi;
    }

    public void setTenMonAnTamThoi(String tenMonAnTamThoi) {
        this.tenMonAnTamThoi = tenMonAnTamThoi;
    }
}

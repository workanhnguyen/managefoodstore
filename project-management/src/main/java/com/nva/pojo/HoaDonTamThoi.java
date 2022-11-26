package com.nva.pojo;
import com.nva.subclass.NumOfDish;

import java.util.ArrayList;
import java.util.List;

public class HoaDonTamThoi {
    private String maHoaDon;
    private String maNhanVien;
    private String maBan;
    private List<NumOfDish> listOrderedDish = new ArrayList<>();
    public HoaDonTamThoi() {}
    public HoaDonTamThoi(String maHoaDon, String maNhanVien, String maBan) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.maBan = maBan;
    }
    public HoaDonTamThoi(String maHoaDon, String maNhanVien, String maBan, List<NumOfDish> listOrderedDish) {
        this.setMaHoaDon(maHoaDon);
        this.setMaNhanVien(maNhanVien);
        this.setMaBan(maBan);
        this.setListOrderedDish(listOrderedDish);
    }
    public int tinhTongTien() {
        int result = 0;
        for (NumOfDish n: this.listOrderedDish) {
            result += n.getThanhTien();
        }
        return result;
    }
    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
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

    public List<NumOfDish> getListOrderedDish() {
        return listOrderedDish;
    }

    public void setListOrderedDish(List<NumOfDish> listOrderedDish) {
        this.listOrderedDish = listOrderedDish;
    }
}

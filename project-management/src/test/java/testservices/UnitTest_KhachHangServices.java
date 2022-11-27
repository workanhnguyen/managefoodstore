/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testservices;

import com.nva.pojo.KhachHang;
import com.nva.services.KhachHangServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 *
 * @author ASUS
 */
public class UnitTest_KhachHangServices {
    KhachHangServices kh_S = new KhachHangServices();

    @ParameterizedTest
    @CsvFileSource(resources = "/data1_khachhang.csv", numLinesToSkip = 1)
    public void testKiemTraDuLieuKhachHangHopLe(String soDienThoai, String ho, String ten, int expectOutput) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(soDienThoai);
        kh.setHoKhachHang(ho);
        kh.setTenKhachHang(ten);

        Assertions.assertEquals(kh_S.kiemTraDuLieuHopLe(kh), expectOutput);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data2_khachhang.csv", numLinesToSkip = 1)
    public void testKiemTraKhachHangTonTai(String soDienThoai, boolean expectOutput) {
        Assertions.assertEquals(kh_S.kiemTraKhachHangTonTai(soDienThoai), expectOutput);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data3_khachhang.csv", numLinesToSkip = 1)
    public void testCapNhatDiemThuong(String soDienThoai, int diemThuong, boolean expectOutput) {
        Assertions.assertEquals(kh_S.capNhatDiemThuong(soDienThoai, diemThuong), expectOutput);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data4_khachhang.csv", numLinesToSkip = 1)
    public void testThemKhachHang(String soDienThoai, String ho, String ten, int diemThuong, boolean expectOutput) {
        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(soDienThoai);
        kh.setHoKhachHang(ho);
        kh.setTenKhachHang(ten);
        kh.setDiemThuong(diemThuong);

        Assertions.assertEquals(kh_S.addKhachHangMoi(kh), expectOutput);
    }
}

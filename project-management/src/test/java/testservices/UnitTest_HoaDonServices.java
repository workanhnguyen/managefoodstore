/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testservices;

import com.nva.pojo.HoaDon;
import com.nva.services.HoaDonServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class UnitTest_HoaDonServices {
    HoaDonServices hd_S = new HoaDonServices();
    @ParameterizedTest
    @CsvFileSource(resources = "/data_hoadon.csv", numLinesToSkip = 1)
    public void testThemHoaDon(String maHoaDon, int nam, int thang, int ngay, int gio, int phut, int giay,
                               String maNhanVien, String maBan, String maKhachHang, int giamGia, int thanhTien, boolean expectedOutput) {
        HoaDon hd = new HoaDon();
        Date d = new Date();
        hd.setMaHoaDon(maHoaDon);
        d.setYear(nam);
        d.setMonth(thang);
        d.setDate(ngay);
        d.setHours(gio);
        d.setMinutes(phut);
        d.setSeconds(giay);
        hd.setThoiGian(d);
        hd.setMaNhanVien(maNhanVien);
        hd.setMaBan(maBan);
        hd.setMaKhachHang(maKhachHang);
        hd.setGiamGia(giamGia);
        hd.setThanhTien(thanhTien);
        Assertions.assertEquals(expectedOutput, hd_S.setHoaDonMoi(hd));
    }
}

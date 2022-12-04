/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testservices;

import commonuse.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 *
 * @author ASUS
 */
public class UnitTest_Utility {
    @ParameterizedTest
    @CsvFileSource(resources = "/data_sodienthoai.csv", numLinesToSkip = 1)
    public void testSoDienThoai(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraSoDienThoaiHopLe(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data_matkhau.csv", numLinesToSkip = 1)
    public void testMatKhau(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraMatKhauHopLe(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data_hoten.csv", numLinesToSkip = 1)
    public void testHoVaTen(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraHoVaTenHopLe(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data_hesoluong.csv", numLinesToSkip = 1)
    public void testHeSoLuong(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraHeSoLuongHopLe(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data_luongcoban.csv", numLinesToSkip = 1)
    public void testLuongCoBan(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraLuongHopLe(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data_dongiamathang.csv", numLinesToSkip = 1)
    public void testDonGiaMatHangHopLe(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraDonGiaHopLe(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data_soluongmathang.csv", numLinesToSkip = 1)
    public void testSoLuongMatHangHopLe(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraDonGiaHopLe(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data_thongkethang.csv", numLinesToSkip = 1)
    public void testThangHopLe(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraThangHopLe(input));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data_thongkenam.csv", numLinesToSkip = 1)
    public void testNamHopLe(String input, int expectedOutput) {
        Assertions.assertEquals(expectedOutput, Utility.kiemTraNamHopLe(input));
    }
}

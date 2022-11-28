/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testservices;

import com.nva.pojo.NguoiDung;
import com.nva.services.NguoiDungServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 *
 * @author ASUS
 */
public class UnitTest_NguoiDungServices {
    NguoiDungServices nd_S = new NguoiDungServices();
    @ParameterizedTest
    @CsvFileSource(resources = "/data_nguoidung.csv", numLinesToSkip = 1)
    public void testGetFullName(String soDienThoai, String expectedOutput) {
        Assertions.assertEquals(expectedOutput, nd_S.getFullName(soDienThoai));
    }
}

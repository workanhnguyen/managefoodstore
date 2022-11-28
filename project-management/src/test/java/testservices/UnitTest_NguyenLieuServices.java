/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testservices;

import com.nva.pojo.NguyenLieu;
import com.nva.services.NguyenLieuServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UnitTest_NguyenLieuServices {
    NguyenLieuServices nl_S = new NguyenLieuServices();
    @ParameterizedTest
    @CsvFileSource(resources = "/data_nguyenlieu.csv", numLinesToSkip = 1)
    public void testKiemTraTinhTrangNguyenLieu(String maNguyenLieu, boolean expectedOutput) {
        List<String> ma_nl = new ArrayList<>();
        ma_nl.add(maNguyenLieu);
        Assertions.assertEquals(expectedOutput, nl_S.kiemTraTinhTrangNguyenLieu(ma_nl));
    }
}

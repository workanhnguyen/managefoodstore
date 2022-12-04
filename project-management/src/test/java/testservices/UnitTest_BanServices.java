/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testservices;

import com.nva.services.BanServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 *
 * @author ASUS
 */
public class UnitTest_BanServices {
    BanServices b = new BanServices();
    @ParameterizedTest
    @CsvFileSource(resources = "/data_ban.csv", numLinesToSkip = 1)
    public void testCapNhatTrangThaiBan(String maBan, int trangThai, boolean expectedOutput) {
        Assertions.assertEquals(expectedOutput, b.capNhatTrangThai(maBan, trangThai));
    }
}

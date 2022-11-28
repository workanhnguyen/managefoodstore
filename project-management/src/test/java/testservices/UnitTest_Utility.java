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
}

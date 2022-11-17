/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testmodule;
import com.nva.pojo.MyPower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 *
 * @author ASUS
 */
public class Tester {
    @Test
    public void test01() {
        Assertions.assertEquals(MyPower.nhan(2, 3), 6);
    }
}

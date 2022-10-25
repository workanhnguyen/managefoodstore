package Main;

import commonuse.CauHinh;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/database/data-nguoidung.txt";
        File file = new File(filePath);

        try {
            Scanner fileScanner = new Scanner(file).useDelimiter("#");
            while (fileScanner.hasNext()) {
                int role = Integer.parseInt(fileScanner.next());
                if (role == 1) {
                    System.out.println("Vai trò: Quản lý");
                }
                String tenDangNhap = fileScanner.next();
                String matKhau = fileScanner.next();
                System.out.printf("Thông tin:\nHọ tên: %s %s\nNgày sinh: %s\nQuê quán: %s",
                        fileScanner.next(), fileScanner.next(), fileScanner.next(), fileScanner.next());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
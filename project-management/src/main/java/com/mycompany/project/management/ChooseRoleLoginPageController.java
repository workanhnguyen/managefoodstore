/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.management;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author ASUS
 */
public class  ChooseRoleLoginPageController {
    /**
     * Quy ước:
     * - Giá trị 0: là nhân viên
     * - Giá trị 1: là quản lý
     */
    public static int loginRole = 0;
    
    @FXML
    private void switchToManagerMainPage() throws IOException {
        loginRole = 1;
        App.setRoot("manager-main-page");
    }
    
    @FXML
    private void switchToEmployeeMainPage() throws IOException {
        loginRole = 0;
        App.setRoot("employee-main-page");
    }
    @FXML
    public Combobox<String> comboBox;
    

    private static class Combobox<T> {

        public Combobox() {
        }
    }
    
}


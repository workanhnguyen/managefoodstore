package com.mycompany.project.management;

import java.io.IOException;

import commonuse.Utility;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class HomePageController {
    @FXML
    private void switchToChooseRoleLoginPage() throws IOException {
        App.setRoot("main-login-page");
    }
    @FXML 
    private void showAuthorsInfo() {
        Utility.showAlertDialog("Thông tin tác giả",String.format("Authors:\n" +
                "\n" +
                "2051012004 - Nguyễn Vân Anh (Dev + Leader)\n" +
                "2051052115 - Trịnh Tấn Sĩ (Dev)\n" +
                "2054052023 - Phạm Thị Thùy Hương (Dev)\n" +
                "2054052007 - Phạm Nguyễn Như Bình (Tester)\n" +
                "2054052064 - Phạm Thu Thủy (Tester)\n" +
                "@2022 - Trường Đại học Mở Thành phố Hồ Chí Minh"), Alert.AlertType.INFORMATION);
    }
}

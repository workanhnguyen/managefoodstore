package com.mycompany.project.management;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.nva.pojo.Ban;
import com.nva.services.BanServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class EmployeeFunctionsPageController implements Initializable {
    //Khai bao bien FXML
    @FXML private Button ban01;
    @FXML private Button ban02;
    @FXML private Button ban03;
    @FXML private Button ban04;
    @FXML private Button ban05;
    @FXML private Button ban06;
    @FXML private Button ban07;
    @FXML private Button ban08;
    @FXML private Button ban09;
    @FXML private Button ban10;
    
    //Khai bao bien thuong
    public static String maBan;
    BanServices b = new BanServices();
    List<Ban> banList = b.getDanhSachBan();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        render();
    }
    @FXML
    private void switchToMainLoginPage() throws IOException {
        App.setRoot("main-login-page");
    }
    @FXML
    private void switchToEmployeeOrderPage(ActionEvent event) throws IOException {
        String str = event.getTarget().toString();
        maBan = str.substring(str.indexOf("ban", 0), str.indexOf("ban") + 5).toUpperCase();
        for (Ban ban: banList) {
            if (ban.getMaBan().equals(maBan)) {
                if (!ban.isTinhTrang()) {
                    App.setRoot("handle-bill-page");
                } else {
                    App.setRoot("employee-order-page");
                }
            }
        }
    }
    @FXML
    private void render() {
        for(Ban ban: banList) {
            switch (ban.getMaBan()) {
                case "BAN01":
                    ban01.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban01.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban01.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN02":
                    ban02.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban02.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban02.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN03":
                    ban03.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban03.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban03.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN04":
                    ban04.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban04.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban04.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN05":
                    ban05.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban05.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban05.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN06":
                    ban06.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban06.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban06.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN07":
                    ban07.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban07.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban07.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN08":
                    ban08.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban08.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban08.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN09":
                    ban09.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban09.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban09.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
                case "BAN10":
                    ban10.setText(String.format("BÀN %s SL: %d", ban.getMaBan().substring(3), ban.getSoLuongChoNgoi()));
                    if (!ban.isTinhTrang()) {
                        ban10.setStyle("-fx-background-color: #c21517; -fx-text-fill: white;");
                    } else {
                        ban10.setStyle("-fx-background-color: rgb(81, 202, 111);-fx-text-fill: black;");
                    }
                    break;
            }
        }
    }
}

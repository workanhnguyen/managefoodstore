package com.mycompany.project.management;

import java.io.IOException;
import javafx.fxml.FXML;

public class RegisterMemberPageController {
    @FXML
    private void switchToHandleBillPage() throws IOException {
        App.setRoot("handle-bill-page");
    }
}

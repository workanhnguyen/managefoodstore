package commonuse;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public static final int limitRewardPoint = 10000;
    /** Giá trị trả về sẽ tương ứng với các lỗi sau:
     * 1: Không có lỗi - Thành công
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự chữ hoặc kí tự đặc biệt
     * -2: chuỗi không bắt đầu bằng số 0
     * -3: chuỗi không đủ hoặc vượt quá 10 kí tự
     */
    public static int kiemTraSoDienThoaiHopLe(String inputStr) {
        Pattern p = Pattern.compile("\\d*");
        Matcher matcher = p.matcher(inputStr);
        if (!matcher.matches()) return -1;
        else if (inputStr.isBlank() || inputStr.isEmpty()) return 0;
        else if (inputStr.charAt(0) != '0') return -2;
        else if (inputStr.length() != 10) return -3;
        else return 1;
    }
    /**
     * Giá trị trả về sẽ tương ứng với các lỗi sau:
     * 1: Không có lỗi (Thành công)
     * 0: chuỗi rỗng
     * -1: chuỗi chứa khoảng trắng
     * -2: chuỗi không phải là mật khẩu mạnh
     * -3: chuỗi không đạt số lượng kí tự (8 <= x <= 20)
     * */
    public static int kiemTraMatKhauHopLe(String inputStr) {
        Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[?><*\\\\@#$%!&:,.=+\\-_~`^/;'\"|()\\[\\]{}]).{8,20})");
        Matcher matcher = p.matcher(inputStr);
        if (inputStr.isBlank() || inputStr.isEmpty()) return 0;
        else if (inputStr.contains(" ")) return -1;
        else if (inputStr.length() < 8 || inputStr.length() > 20) return -3;
        else if (!matcher.matches()) return -2;
        else return 1;
    }
    /** Tạo ra một hộp thoại */
    public static Optional<ButtonType> showAlertDialog(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        return alert.showAndWait();
    }
}

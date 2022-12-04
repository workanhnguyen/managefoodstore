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
        Pattern p = Pattern.compile(Constant.EXIST_IT_NHAT_MOT_SO_NGUYEN + Constant.EXIST_IT_NHAT_MOT_KY_TU_CHU_THUONG +
                Constant.EXIST_IT_NHAT_MOT_KY_TU_CHU_HOA + Constant.EXIST_IT_NHAT_MOT_KY_TU_DAC_BIET + ".{8,20}");
        Matcher matcher = p.matcher(inputStr);
        if (inputStr.isBlank() || inputStr.isEmpty()) return 0;
        else if (inputStr.contains(" ")) return -1;
        else if (inputStr.length() < 8 || inputStr.length() > 20) return -3;
        else if (!matcher.matches()) return -2;
        else return 1;
    }
    /**
     * Giá trị trả về tương ứng với các lỗi sau:
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự đặc biệt hoặc số
     * -2: chuôỗi vượt quá độ dài quy định
     * */
    public static int kiemTraHoVaTenHopLe(String inputStr) {
        String ho, ten;
        // Kiểm tra trong chuỗi tồn tại số
        Pattern p1 = Pattern.compile(Constant.EXIST_IT_NHAT_MOT_SO_NGUYEN+ ".{1,55}");
        // Kiểm tra trong chuỗi tồn tại ký tự đặc biệt
        Pattern p2 = Pattern.compile(Constant.EXIST_IT_NHAT_MOT_KY_TU_DAC_BIET + ".{1,55}");
        Matcher matcher1 = p1.matcher(inputStr);
        Matcher matcher2 = p2.matcher(inputStr);

        if (inputStr.isEmpty() || inputStr.isBlank()) return 0;
        else if (inputStr.length() > 55) return -2;
        else if (matcher1.matches() || matcher2.matches()) return -1;
        else if (!inputStr.contains(" ")) return -1;
        else {
            ho = inputStr.substring(0, inputStr.lastIndexOf(" "));
            ten = inputStr.substring(inputStr.lastIndexOf(" ") + 1, inputStr.length());
            if (ho.length() > 40 || ten.length() > 15) return -2;
        }
        return 1;
    }
    /**
     * Giá trị trả về tương ứng với các lỗi sau:
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự đặc biệt hoặc chữ cái
     * -2: Lương <= 0
     * */
    public static int kiemTraLuongHopLe(String luongCoBan) {
        luongCoBan = luongCoBan.trim();
        Pattern p = Pattern.compile(Constant.IS_SO_NGUYEN);
        Matcher matcher = p.matcher(luongCoBan);
        if (luongCoBan.isBlank() || luongCoBan.isEmpty()) return 0;
        else if (!matcher.matches()) return -1;
        else if (Integer.parseInt(luongCoBan) <= 0) return -2;
        else return 1;
    }
    /**
     * Giá trị trả về tương ứng với các lỗi sau:
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự đặc biệt hoặc chữ cái
     * -2: Hệ số lương <= 0
     * */
    public static int kiemTraHeSoLuongHopLe(String heSoLuong) {
        heSoLuong = heSoLuong.trim();
        Pattern p1 = Pattern.compile(Constant.IS_SO_THAP_PHAN);
        Matcher matcher = p1.matcher(heSoLuong);
        if (heSoLuong.isBlank() || heSoLuong.isEmpty()) return 0;
        else if (!matcher.matches()) return -1;
        else if (Double.parseDouble(heSoLuong) <= 0) return -2;
        else return 1;
    }
    /**
     * Giá trị trả về tương ứng với các lỗi sau:
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự đặc biệt hoặc chữ cái
     * -2: giá trị <= 0
     * */
    public static int kiemTraSoLuongHopLe(String inputStr) {
        Pattern p = Pattern.compile("\\d*");
        Matcher matcher = p.matcher(inputStr);
        if (!matcher.matches()) return -1;
        else if (inputStr.isBlank() || inputStr.isEmpty()) return 0;
        else if (Integer.parseInt(inputStr) <= 0) return -2;
        else return 1;
    }
    /**
     * Giá trị trả về tương ứng với các lỗi sau:
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự đặc biệt hoặc chữ cái
     * -2: giá trị <= 0
     * */
    public static int kiemTraDonGiaHopLe(String inputStr) {
        Pattern p = Pattern.compile("\\d*");
        Matcher matcher = p.matcher(inputStr);
        if (!matcher.matches()) return -1;
        else if (inputStr.isBlank() || inputStr.isEmpty()) return 0;
        else if (Integer.parseInt(inputStr) <= 0) return -2;
        else return 1;
    }
    /**
     * Giá trị trả về tương ứng với các lỗi sau:
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự đặc biệt hoặc chữ cái
     * -2: giá trị tháng không hợp lệ
     * */
    public static int kiemTraThangHopLe(String inputStr) {
        Pattern p = Pattern.compile("\\d*");
        Matcher matcher = p.matcher(inputStr);
        if (inputStr.isBlank() || inputStr.isEmpty()) return 0;
        else if (!matcher.matches()) return -1;
        else if (Integer.parseInt(inputStr) <= 0 ||  Integer.parseInt(inputStr) > 12) return -2;
        else return 1;
    }
    /**
     * Giá trị trả về tương ứng với các lỗi sau:
     * 0: chuỗi rỗng
     * -1: chuỗi chứa kí tự đặc biệt hoặc chữ cái
     * -2: giá trị năm không hợp lệ (< 1900)
     * */
    public static int kiemTraNamHopLe(String inputStr) {
        Pattern p = Pattern.compile("\\d*");
        Matcher matcher = p.matcher(inputStr);
        if (inputStr.isBlank() || inputStr.isEmpty()) return 0;
        else if (!matcher.matches()) return -1;
        else if (Integer.parseInt(inputStr) < 1900) return -2;
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

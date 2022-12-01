package commonuse;

public class Constant {
    public static final String IS_SO_THAP_PHAN = "^(-?0[.]\\d+)$|^(-?[1-9]+\\d*([.]\\d+)?)$|^0$";
    public static final String IS_SO_NGUYEN = "(\\d*)";
    public static final String EXIST_IT_NHAT_MOT_SO_NGUYEN = "(?=(.*[0-9]))";
    public static final String EXIST_IT_NHAT_MOT_KY_TU_DAC_BIET = "(?=.*[?><*\\\\@#$%!&:,.=+\\-_~`^/;'\"|()\\[\\]{}])";
    public static final String EXIST_IT_NHAT_MOT_KY_TU_CHU_THUONG = "(?=.*[a-z])";
    public static final String EXIST_IT_NHAT_MOT_KY_TU_CHU_HOA = "(?=.*[A-Z])";
}

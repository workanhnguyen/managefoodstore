package commonuse;


import com.nva.pojo.MonAn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<MonAn> getDanhSachMonAn() throws SQLException {
        Connection conn = JdbcUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM MonAn");

        List<MonAn> danhSachMonAn = new ArrayList<>();
        while (rs.next()) {
            MonAn monAn = new MonAn(rs.getString("MaMonAn"),
                    rs.getString("TenMonAn"),
                    rs.getInt("DonGia"));
            danhSachMonAn.add(monAn);
        }
        return danhSachMonAn;
    }
}

package com.nva.services;

import com.nva.pojo.NguyenLieu;
import commonuse.JdbcUtils;
import com.nva.pojo.PhieuMuaHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class NguyenLieuServices {
    public List<NguyenLieu> getDanhSachNguyenLieu() {
        List<NguyenLieu> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM nguyenlieu");

            while (rs.next()) {
                NguyenLieu nl = new NguyenLieu(rs.getString("MaNguyenLieu"),
                        rs.getString("TenNguyenLieu"),
                        rs.getInt("SoLuong"),
                        rs.getString("DonVi"));
                danhSach.add(nl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public boolean kiemTraTinhTrangNguyenLieu(List<String> danhSachMaNguyenLieu) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            for (String maNguyenLieu: danhSachMaNguyenLieu) {
                ResultSet rs = stm.executeQuery(String.format(
                        "SELECT SoLuong\n" +
                                "FROM nguyenlieu\n" +
                                "WHERE MaNguyenLieu = '%s'", maNguyenLieu));
                if (rs.next()) {
                    if (rs.getInt("SoLuong") <= 0) return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean suDungNguyenLieu(List<String> danhSachMaNguyenLieu) throws SQLException {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            for (String maNguyenLieu: danhSachMaNguyenLieu) {
                int rs = stm.executeUpdate(String.format("" +
                        "UPDATE nguyenlieu\n" +
                        "SET SoLuong = SoLuong - 1\n" +
                        "WHERE MaNguyenLieu = '%s' AND SoLuong >= 1", maNguyenLieu));
                if (rs == 0)
                    return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public boolean hoanTacNguyenLieu(List<String> danhSachMaNguyenLieu) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            for (String maNguyenLieu: danhSachMaNguyenLieu) {
                int rs = stm.executeUpdate(String.format("" +
                        "UPDATE nguyenlieu\n" +
                        "SET SoLuong = SoLuong + 1\n" +
                        "WHERE MaNguyenLieu = '%s'", maNguyenLieu));
                if (rs == 0)
                    return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    public List<NguyenLieu> showNguyenLieuThieu(){
        List<NguyenLieu> danhSach = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM nguyenlieu WHERE Soluong <= 10");

            while (rs.next()) {
                NguyenLieu nl = new NguyenLieu(rs.getString("MaNguyenLieu"),
                        rs.getString("TenNguyenLieu"),
                        rs.getInt("SoLuong"),
                        rs.getString("DonVi"));
                danhSach.add(nl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSach;
    }
    public boolean capNhatSoLuongNguyenLieu(String maNguyenLieu, int soLuongCongThem) {
        try (Connection conn = JdbcUtils.getConn()) {
            Statement stm = conn.createStatement();
            int rs = stm.executeUpdate(String.format("" +
                    "UPDATE nguyenlieu\n" +
                    "SET SoLuong = SoLuong + %d\n" +
                    "WHERE MaNguyenLieu = '%s'", soLuongCongThem, maNguyenLieu));
            if (rs == 0)
                return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

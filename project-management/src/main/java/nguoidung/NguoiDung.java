package nguoidung;

import java.util.Date;

public class NguoiDung {

	private String tenDangNhap;
	private String matKhau;
	private boolean laQuanLy;
	private String hoTen;
	private Date ngaySinh;
	private String diaChi;

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isLaQuanLy() {
		return laQuanLy;
	}

	public void setLaQuanLy(boolean laQuanLy) {
		this.laQuanLy = laQuanLy;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}

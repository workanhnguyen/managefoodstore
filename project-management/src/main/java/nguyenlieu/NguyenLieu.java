package nguyenlieu;

public class NguyenLieu {

	private int maNguyenLieu;
	private String tenNguyenLieu;
	private int soLuongTrongKho;
	private boolean tinhTrang;

	@Override
	public String toString() {
		return null;
	}

	public int getMaNguyenLieu() {
		return maNguyenLieu;
	}

	public void setMaNguyenLieu(int maNguyenLieu) {
		this.maNguyenLieu = maNguyenLieu;
	}

	public String getTenNguyenLieu() {
		return tenNguyenLieu;
	}

	public void setTenNguyenLieu(String tenNguyenLieu) {
		this.tenNguyenLieu = tenNguyenLieu;
	}

	public int getSoLuongTrongKho() {
		return soLuongTrongKho;
	}

	public void setSoLuongTrongKho(int soLuongTrongKho) {
		this.soLuongTrongKho = soLuongTrongKho;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}

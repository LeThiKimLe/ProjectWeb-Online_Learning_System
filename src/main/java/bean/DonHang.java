package bean;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ConnectDataBase;

/**
 * DonHang generated by hbm2java
 */
public class DonHang implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maDonHang;
	private String hocVien;
	private int tongSoTien;
	private Date ngayThanhToan;

	public DonHang() {
		tongSoTien=0;
	}

	public DonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	
	public String autoID() throws SQLException
	{
		Connection conn = null;
		try {
			conn = ConnectDataBase.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = "SELECT COUNT(*) as SoLuong FROM DonHang";
		
		PreparedStatement pstm=null;
		try {
			pstm = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ResultSet rs = pstm.executeQuery();
        String kqString="";
        while (rs.next()) 
        {
        	int soluong = rs.getInt("SoLuong");
        	if (soluong+1<10)
        		kqString= "DH000"+ String.valueOf(soluong+1);
        	else {
				kqString= "DH00"+ String.valueOf(soluong+1);
			}
        }
        return kqString;  
	}

	public String getMaDonHang()
	{
		return this.maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getHocVien() {
		return this.hocVien;
	}

	public void setHocVien(String hocVien) {
		this.hocVien = hocVien;
	}

	public int getTongSoTien() {
		return this.tongSoTien;
	}

	public void setTongSoTien(int tongSoTien) {
		this.tongSoTien = tongSoTien;
	}

	public Date getNgayThanhToan() {
		return this.ngayThanhToan;
	}

	public void setNgayThanhToan(Date ngayThanhToan) {
		this.ngayThanhToan = ngayThanhToan;
	}
	
	public void ThemItem( Connection conn,String maKhoaHoc, int giatien) throws SQLException
	{
		DoTrongDonHang newitemDonHang= new DoTrongDonHang(this.maDonHang, maKhoaHoc);
		
        String sql = "Insert into DoTrongDonHang values (?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, newitemDonHang.getId());
        pstm.setString(2, newitemDonHang.getDonHang());
        pstm.setString(3, newitemDonHang.getMaKhoaHoc());
        pstm.executeUpdate();
        
        String sql2 = "Insert into DangKyKhoaHoc values (?,?)";
        PreparedStatement pstm2 = conn.prepareStatement(sql2);
        pstm2.setString(1, this.hocVien);
        pstm2.setString(2, maKhoaHoc);
        pstm2.executeUpdate();
        
        this.tongSoTien=this.tongSoTien+giatien;
	}

	
	public void TaoHoaDon(Connection conn) throws SQLException
	{
        String sql = "Insert into DonHang values (?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, this.maDonHang);
        pstm.setBigDecimal(2, BigDecimal.valueOf(0));
        pstm.setDate(3, this.ngayThanhToan);
        pstm.setString(4, this.hocVien);
        pstm.executeUpdate();
	}
	
	public DonHang(Connection conn,String hocVien, Date ngayThanhToan) throws SQLException
	{
		this.maDonHang = this.autoID();
		this.hocVien = hocVien;
		this.tongSoTien = 0;
		this.ngayThanhToan = ngayThanhToan;
		this.TaoHoaDon(conn);
	}
	
	
	public void HoanTatHoaDon( Connection conn) throws SQLException
	{
		String sql = "Update DonHang set TongSoTien=? where MaDonHang=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setBigDecimal(1, BigDecimal.valueOf(this.tongSoTien));
        pstm.setString(2, this.maDonHang);
        pstm.executeUpdate();
	}
	
}
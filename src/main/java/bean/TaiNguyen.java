package bean;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * TaiNguyen generated by hbm2java
 */
public class TaiNguyen implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maBaiHoc;
	private String baiGiang;
	private String lythuyet;
	private String baiTap;

	public TaiNguyen() {
	}
	
	public TaiNguyen(String maBaiHoc)
	{
		this.maBaiHoc=maBaiHoc;
	}
	
	public TaiNguyen(Connection conn,String maBaiHoc) throws SQLException
	{
		String sql = "Select * from TaiNguyen a where a.MaBaiHoc=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, maBaiHoc);
        ResultSet rs = pstm.executeQuery();
	    this.maBaiHoc=maBaiHoc;
        while (rs.next())
        {
        	this.baiGiang=rs.getString("BaiGiang");
        	this.lythuyet=rs.getString("LyThuyet");
        	this.baiTap=rs.getString("BaiTap");
        }
	}
	

	public String getMaBaiHoc() {
		return maBaiHoc;
	}

	public void setMaBaiHoc(String maBaiHoc) {
		this.maBaiHoc = maBaiHoc;
	}

	public String getBaiGiang() {
		return baiGiang;
	}

	public void setBaiGiang(String baiGiang) {
		this.baiGiang = baiGiang;
	}

	public String getLythuyet() {
		return lythuyet;
	}

	public void setLythuyet(String lythuyet) {
		this.lythuyet = lythuyet;
	}

	public String getBaiTap() {
		return baiTap;
	}

	public void setBaiTap(String baiTap) {
		this.baiTap = baiTap;
	}

}

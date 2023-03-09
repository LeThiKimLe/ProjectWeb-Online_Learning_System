package bean;

/**
 * PhanMon generated by hbm2java
 */
public class PhanMon implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maPhanMon;
	private KhoiLop khoiLop;
	private Mon mon;
	private String tenPhanMon;
	
	public PhanMon() {
	}

	public PhanMon(String maPhanMon) {
		this.maPhanMon = maPhanMon;
	}

	public PhanMon(String maPhanMon, KhoiLop khoiLop, Mon mon, String tenPhanMon) {
		this.maPhanMon = maPhanMon;
		this.khoiLop = khoiLop;
		this.mon = mon;
		this.tenPhanMon = tenPhanMon;
		
	}

	public String getMaPhanMon() {
		return this.maPhanMon;
	}

	public void setMaPhanMon(String maPhanMon) {
		this.maPhanMon = maPhanMon;
	}

	public KhoiLop getKhoiLop() {
		return this.khoiLop;
	}

	public void setKhoiLop(KhoiLop khoiLop) {
		this.khoiLop = khoiLop;
	}

	public Mon getMon() {
		return this.mon;
	}

	public void setMon(Mon mon) {
		this.mon = mon;
	}

	public String getTenPhanMon() {
		return this.tenPhanMon;
	}

	public void setTenPhanMon(String tenPhanMon) {
		this.tenPhanMon = tenPhanMon;
	}

}
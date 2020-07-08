package top.young.model;

public class Late {
	private String Ano;
	private String Bno;
	private String Dno;
	private String Sno;
	private String Ltime;
	private String Lreason;
	public String getAno() {
		return Ano;
	}
	public void setAno(String ano) {
		Ano = ano;
	}
	public String getBno() {
		return Bno;
	}
	public void setBno(String bno) {
		Bno = bno;
	}
	public String getDno() {
		return Dno;
	}
	public void setDno(String dno) {
		Dno = dno;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getLtime() {
		return Ltime;
	}
	public void setLtime(String ltime) {
		Ltime = ltime;
	}
	public String getLreason() {
		return Lreason;
	}
	public void setLreason(String lreason) {
		Lreason = lreason;
	}
	public Late(String ano, String bno, String dno, String sno, String ltime, String lreason) {
		super();
		Ano = ano;
		Bno = bno;
		Dno = dno;
		Sno = sno;
		Ltime = ltime;
		Lreason = lreason;
	}
	public Late() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

package top.young.model;

public class Repair {
	private String id;
	private String Ano;
	private String Bno;
	private String Dno;
	private String Submittime;
	private String Rreason;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getSubmittime() {
		return Submittime;
	}
	public void setSubmittime(String submittime) {
		Submittime = submittime;
	}
	public String getRreason() {
		return Rreason;
	}
	public void setRreason(String rreason) {
		Rreason = rreason;
	}
	public Repair( String ano, String bno, String dno, String submittime, String rreason) {
		super();
		Ano = ano;
		Bno = bno;
		Dno = dno;
		Submittime = submittime;
		Rreason = rreason;
	}
	public Repair() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

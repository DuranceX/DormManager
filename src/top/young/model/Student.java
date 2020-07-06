package top.young.model;

public class Student {
	private String Sno;
	private String Mno;
	private String Ccno;
	public Student(String sno, String mno, String ccno, String sname, String ssex) {
		super();
		Sno = sno;
		Mno = mno;
		Ccno = ccno;
		Sname = sname;
		Ssex = ssex;
	}
	public String getCcno() {
		return Ccno;
	}
	public void setCcno(String ccno) {
		Ccno = ccno;
	}
	private String Sname;
	private String Ssex;
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getMno() {
		return Mno;
	}
	public void setMno(String mno) {
		Mno = mno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSsex() {
		return Ssex;
	}
	public void setSsex(String ssex) {
		Ssex = ssex;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

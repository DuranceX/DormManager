package top.young.model;

public class Student {
	private String Sno;
	private String Mno;
	private String Sclass;
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
	public String getSclass() {
		return Sclass;
	}
	public void setSclass(String sclass) {
		Sclass = sclass;
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
	public Student(String sno, String mno, String sclass, String sname, String ssex) {
		super();
		Sno = sno;
		Mno = mno;
		Sclass = sclass;
		Sname = sname;
		Ssex = ssex;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

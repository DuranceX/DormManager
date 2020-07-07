package top.young.model;

public class Accommodation {
	private String Sno;
	private String Ano;
	private String Bno;
	private String Dno;

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
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

	public Accommodation(String sno, String ano, String bno, String dno) {
		super();
		Sno = sno;
		Ano = ano;
		Bno = bno;
		Dno = dno;
	}

	public Accommodation() {
		super();
		// TODO Auto-generated constructor stub
	}

}

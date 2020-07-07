package top.young.model;

public class Building {
	private String Ano;
	private String Bno;

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

	public Building(String ano, String bno) {
		super();
		Ano = ano;
		Bno = bno;
	}

	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}

}

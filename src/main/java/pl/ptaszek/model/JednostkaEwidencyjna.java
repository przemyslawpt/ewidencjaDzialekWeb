package pl.ptaszek.model;

import java.util.List;

public class JednostkaEwidencyjna {

	private String nazwa;

	private String number;

	private List<ObrebGeodezyjny> obszarGeodezyjnyList;

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<ObrebGeodezyjny> getObszarGeodezyjnyList() {
		return obszarGeodezyjnyList;
	}

	public void setObszarGeodezyjnyList(List<ObrebGeodezyjny> obszarGeodezyjnyList) {
		this.obszarGeodezyjnyList = obszarGeodezyjnyList;
	}

	public JednostkaEwidencyjna(String nazwa, String number, List<ObrebGeodezyjny> obszarGeodezyjnyList) {
		super();
		this.nazwa = nazwa;
		this.number = number;
		this.obszarGeodezyjnyList = obszarGeodezyjnyList;
	}

}

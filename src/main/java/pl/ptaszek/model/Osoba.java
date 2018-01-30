package pl.ptaszek.model;
public class Osoba {

	private String tytulGrzecznosciowy;
	
	private String imie;

	private String nazwisko;
	
	private String pesel;

	public Osoba(String tytulGrzecznosciowy, String imie, String nazwisko, String pesel) {
		super();
		this.tytulGrzecznosciowy = tytulGrzecznosciowy;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.pesel = pesel;
	}

	public String getTytulGrzecznosciowy() {
		return tytulGrzecznosciowy;
	}

	public void setTytulGrzecznosciowy(String tytulGrzecznosciowy) {
		this.tytulGrzecznosciowy = tytulGrzecznosciowy;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + ((pesel == null) ? 0 : pesel.hashCode());
		result = prime * result + ((tytulGrzecznosciowy == null) ? 0 : tytulGrzecznosciowy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Osoba other = (Osoba) obj;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (pesel == null) {
			if (other.pesel != null)
				return false;
		} else if (!pesel.equals(other.pesel))
			return false;
		if (tytulGrzecznosciowy == null) {
			if (other.tytulGrzecznosciowy != null)
				return false;
		} else if (!tytulGrzecznosciowy.equals(other.tytulGrzecznosciowy))
			return false;
		return true;
	}
   
}

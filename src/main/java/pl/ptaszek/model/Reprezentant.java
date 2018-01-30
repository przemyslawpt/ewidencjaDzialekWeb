package pl.ptaszek.model;

public class Reprezentant extends Osoba {

	public Reprezentant(String tytulGrzecznosciowy, String imie, String nazwisko, String pesel) {
		super(tytulGrzecznosciowy, imie, nazwisko, pesel);

	}

	private Stanowisko stanowisko;

	public Stanowisko getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(Stanowisko stanowisko) {
		this.stanowisko = stanowisko;
	}

}

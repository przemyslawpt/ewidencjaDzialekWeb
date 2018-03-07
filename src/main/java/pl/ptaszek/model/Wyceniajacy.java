package pl.ptaszek.model;

public class Wyceniajacy extends Osoba {

	private String opisStanowisko;

	public Wyceniajacy(String tytulGrzecznosciowy, String imie, String nazwisko, String pesel, String opisStanowisko) {
		super(tytulGrzecznosciowy, imie, nazwisko, pesel);
		this.opisStanowisko = opisStanowisko;
	}

	public String getOpisStanowisko() {
		return opisStanowisko;
	}

	public void setOpisStanowisko(String opisStanowisko) {
		this.opisStanowisko = opisStanowisko;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((opisStanowisko == null) ? 0 : opisStanowisko.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wyceniajacy other = (Wyceniajacy) obj;
		if (opisStanowisko == null) {
			if (other.opisStanowisko != null)
				return false;
		} else if (!opisStanowisko.equals(other.opisStanowisko))
			return false;
		return true;
	}

}

package pl.ptaszek.model;

public class Rzeczoznawca extends Osoba {

	private String numberUprawnien;

	public Rzeczoznawca(String tytulGrzecznosciowy, String imie, String nazwisko, String pesel,
			String numberUprawnien) {
		super(tytulGrzecznosciowy, imie, nazwisko, pesel);
		this.numberUprawnien = numberUprawnien;
	}

	public String getNumberUprawnien() {
		return numberUprawnien;
	}

	public void setNumberUprawnien(String numberUprawnien) {
		this.numberUprawnien = numberUprawnien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numberUprawnien == null) ? 0 : numberUprawnien.hashCode());
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
		Rzeczoznawca other = (Rzeczoznawca) obj;
		if (numberUprawnien == null) {
			if (other.numberUprawnien != null)
				return false;
		} else if (!numberUprawnien.equals(other.numberUprawnien))
			return false;
		return true;
	}

}

package pl.ptaszek.model;
/**
 * Do poprawienia.
 *
 */
public class Kontrahent {

	private Osoba osoba;

	private String nazwa;

	private Adres adres;

	public Kontrahent(Osoba osoba, String nazwa, Adres adres) {
		super();
		this.osoba = osoba;
		this.nazwa = nazwa;
		this.adres = adres;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result + ((osoba == null) ? 0 : osoba.hashCode());
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
		Kontrahent other = (Kontrahent) obj;
		if (adres == null) {
			if (other.adres != null)
				return false;
		} else if (!adres.equals(other.adres))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		if (osoba == null) {
			if (other.osoba != null)
				return false;
		} else if (!osoba.equals(other.osoba))
			return false;
		return true;
	}

}

package pl.ptaszek.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Opisuje wlasciciela dzialki
 * 
 */
public class WlascicielDzialki {

	/**
	 * 
	 */
	private String nazwa;
	/**
	 * 
	 */
	private BigDecimal procentowyUdzial;
	/**
	 * 
	 */
	private String podstawaWlasnosci;

	private Adres adres;

	private String numerIdentyfikacjiPodatkowej;

	private String regon;

	private List<Reprezentant> reprezentant;

	public WlascicielDzialki(String nazwa, BigDecimal procentowyUdzial, String podstawaWlasnosci, Adres adres,
			String numerIdentyfikacjiPodatkowej, String regon, List<Reprezentant> reprezentant) {
		super();
		this.nazwa = nazwa;
		this.procentowyUdzial = procentowyUdzial;
		this.podstawaWlasnosci = podstawaWlasnosci;
		this.adres = adres;
		this.numerIdentyfikacjiPodatkowej = numerIdentyfikacjiPodatkowej;
		this.regon = regon;
		this.reprezentant = reprezentant;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public BigDecimal getProcentowyUdzial() {
		return procentowyUdzial;
	}

	public void setProcentowyUdzial(BigDecimal procentowyUdzial) {
		this.procentowyUdzial = procentowyUdzial;
	}

	public String getPodstawaWlasnosci() {
		return podstawaWlasnosci;
	}

	public void setPodstawaWlasnosci(String podstawaWlasnosci) {
		this.podstawaWlasnosci = podstawaWlasnosci;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public String getNumerIdentyfikacjiPodatkowej() {
		return numerIdentyfikacjiPodatkowej;
	}

	public void setNumerIdentyfikacjiPodatkowej(String numerIdentyfikacjiPodatkowej) {
		this.numerIdentyfikacjiPodatkowej = numerIdentyfikacjiPodatkowej;
	}

	public String getRegon() {
		return regon;
	}

	public void setRegon(String regon) {
		this.regon = regon;
	}

	public List<Reprezentant> getReprezentant() {
		return reprezentant;
	}

	public void setReprezentant(List<Reprezentant> reprezentant) {
		this.reprezentant = reprezentant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adres == null) ? 0 : adres.hashCode());
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		result = prime * result
				+ ((numerIdentyfikacjiPodatkowej == null) ? 0 : numerIdentyfikacjiPodatkowej.hashCode());
		result = prime * result + ((podstawaWlasnosci == null) ? 0 : podstawaWlasnosci.hashCode());
		result = prime * result + ((procentowyUdzial == null) ? 0 : procentowyUdzial.hashCode());
		result = prime * result + ((regon == null) ? 0 : regon.hashCode());
		result = prime * result + ((reprezentant == null) ? 0 : reprezentant.hashCode());
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
		WlascicielDzialki other = (WlascicielDzialki) obj;
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
		if (numerIdentyfikacjiPodatkowej == null) {
			if (other.numerIdentyfikacjiPodatkowej != null)
				return false;
		} else if (!numerIdentyfikacjiPodatkowej.equals(other.numerIdentyfikacjiPodatkowej))
			return false;
		if (podstawaWlasnosci == null) {
			if (other.podstawaWlasnosci != null)
				return false;
		} else if (!podstawaWlasnosci.equals(other.podstawaWlasnosci))
			return false;
		if (procentowyUdzial == null) {
			if (other.procentowyUdzial != null)
				return false;
		} else if (!procentowyUdzial.equals(other.procentowyUdzial))
			return false;
		if (regon == null) {
			if (other.regon != null)
				return false;
		} else if (!regon.equals(other.regon))
			return false;
		if (reprezentant == null) {
			if (other.reprezentant != null)
				return false;
		} else if (!reprezentant.equals(other.reprezentant))
			return false;
		return true;
	}

}

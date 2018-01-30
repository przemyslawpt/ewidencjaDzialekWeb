package pl.ptaszek.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * Opisuje dzialke.
 *
 */
//@Entity
//@Table(name = "dzialka")
public class Dzialka {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	/**
	 * Numer ewidencyjny dzialki. Polski standard UFE-223.
	 */
	private String numerEwidencyjny;
	/**
	 * Rozmiar dzialki w metrach kwadratowych
	 */
	private String wielkoscDzialki;

	private Osoba wlasciciel;

	private Adres adres;

	private ObrebGeodezyjny obrebGeodezyjny;

	private String numberKsiegiWieczystej;

	/**
	 * Przeznaczenie dzialki jest opisem.
	 */
	private String przeznaczenieDzialki;

	List<String> dokumentyPowiazaneLista;

	List<Wycena> wycenaList;

	private String trzyletnieWykorzystanieOpis;
	
	private String obciazeniaOgraniczonymiPrawamiRzeczowymi;

	public Dzialka() {
	}

	public Dzialka(String numerEwidencyjny, String wielkoscDzialki, Osoba wlasciciel, Adres adres) {
		super();
		this.numerEwidencyjny = numerEwidencyjny;
		this.wielkoscDzialki = wielkoscDzialki;
		this.wlasciciel = wlasciciel;
		this.adres = adres;
	}

	public String getNumerEwidencyjny() {
		return numerEwidencyjny;
	}

	public void setNumerEwidencyjny(String numerEwidencyjny) {
		this.numerEwidencyjny = numerEwidencyjny;
	}

	public String getWielkoscDzialki() {
		return wielkoscDzialki;
	}

	public String getNumberKsiegiWieczystej() {
		return numberKsiegiWieczystej;
	}

	public void setNumberKsiegiWieczystej(String numberKsiegiWieczystej) {
		this.numberKsiegiWieczystej = numberKsiegiWieczystej;
	}

	public void setWielkoscDzialki(String wielkoscDzialki) {
		this.wielkoscDzialki = wielkoscDzialki;
	}

	public Osoba getWlasciciel() {
		return wlasciciel;
	}

	public void setWlasciciel(Osoba wlasciciel) {
		this.wlasciciel = wlasciciel;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public String toString() {
		return "Numer Ewidencyjny: " + numerEwidencyjny + ", Wielkosc dzialki: " + wielkoscDzialki;
	}

	public String getTyp() {
		return "dzialkaBazowa";
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dzialka other = (Dzialka) obj;
		if (adres == null) {
			if (other.adres != null)
				return false;
		} else if (!adres.equals(other.adres))
			return false;
		if (numerEwidencyjny == null) {
			if (other.numerEwidencyjny != null)
				return false;
		} else if (!numerEwidencyjny.equals(other.numerEwidencyjny))
			return false;
		if (wielkoscDzialki == null) {
			if (other.wielkoscDzialki != null)
				return false;
		} else if (!wielkoscDzialki.equals(other.wielkoscDzialki))
			return false;
		if (wlasciciel == null) {
			if (other.wlasciciel != null)
				return false;
		} else if (!wlasciciel.equals(other.wlasciciel))
			return false;
		return true;
	}

}

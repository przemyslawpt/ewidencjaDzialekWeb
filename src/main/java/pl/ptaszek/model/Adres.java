package pl.ptaszek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**@Entity
 
 * @author Radek
 *
 */
@Table(name = "adres")
public class Adres {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String ulica;
	
	private String numerDomu;

	private String kodPocztowy;

	private String miejscowosc;

	private String numerLokalu;

	public Adres() {
	}

	public Adres(String ulica, String numerDomu, String kodPocztowy, String miejscowosc, String numerLokalu) {
		super();
		this.ulica = ulica;
		this.numerDomu = numerDomu;
		this.kodPocztowy = kodPocztowy;
		this.miejscowosc = miejscowosc;
		this.numerLokalu = numerLokalu;
	}

	public String getNumberLokalu() {
		return numerLokalu;
	}

	public void setNumberLokalu(String numberLokalu) {
		this.numerLokalu = numberLokalu;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNumerDomu() {
		return numerDomu;
	}

	public void setNumerDomu(String numerDomu) {
		this.numerDomu = numerDomu;
	}

	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	/**
	 * Zwraca tekstowa reprezentacje obiektu.
	 * 
	 * @return teksowy opis obiektu
	 */
	public String toString() {
		return "Ulica: " + ulica + ", numer domu: " + numerDomu + ", kod pocztowy: " + kodPocztowy + ", miejscowosc: "
				+ miejscowosc;
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
		Adres other = (Adres) obj;
		if (kodPocztowy == null) {
			if (other.kodPocztowy != null)
				return false;
		} else if (!kodPocztowy.equals(other.kodPocztowy))
			return false;
		if (miejscowosc == null) {
			if (other.miejscowosc != null)
				return false;
		} else if (!miejscowosc.equals(other.miejscowosc))
			return false;
		if (numerDomu == null) {
			if (other.numerDomu != null)
				return false;
		} else if (!numerDomu.equals(other.numerDomu))
			return false;
		if (ulica == null) {
			if (other.ulica != null)
				return false;
		} else if (!ulica.equals(other.ulica))
			return false;
		return true;
	}

}

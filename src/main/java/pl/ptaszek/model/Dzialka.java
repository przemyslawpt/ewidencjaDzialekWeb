package pl.ptaszek.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dzialka")
public class Dzialka {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		private String numerEwidencyjny;
		
		private String obreb; 
		
		private String wlasnoscRodzajDokumentu; 
		
		private String wlasnoscNumerDokumentu;

		private String charakterWladania;

		private String udzialy; 

		private String powierzchniaDzialki; 
		
		private String powierzchniaZabudowy; 
		
		private String oszacowanaWartosc; 
	
		private String przeznaczenie; 
		
		private String aktualneWykorzystanie; 
		
		private String planWykorzystaniaLata; 
		
		private String uwagi; 
		
		private String skladKomisji; 
		
		private Date operationDate;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNumerEwidencyjny() {
			return numerEwidencyjny;
		}

		public void setNumerEwidencyjny(String numerEwidencyjny) {
			this.numerEwidencyjny = numerEwidencyjny;
		}

		public String getObreb() {
			return obreb;
		}

		public void setObreb(String obreb) {
			this.obreb = obreb;
		}

		public String getWlasnoscRodzajDokumentu() {
			return wlasnoscRodzajDokumentu;
		}

		public void setWlasnoscRodzajDokumentu(String wlasnoscRodzajDokumentu) {
			this.wlasnoscRodzajDokumentu = wlasnoscRodzajDokumentu;
		}

		public String getWlasnoscNumerDokumentu() {
			return wlasnoscNumerDokumentu;
		}

		public void setWlasnoscNumerDokumentu(String wlasnoscNumerDokumentu) {
			this.wlasnoscNumerDokumentu = wlasnoscNumerDokumentu;
		}

		public String getCharakterWladania() {
			return charakterWladania;
		}

		public void setCharakterWladania(String charakterWladania) {
			this.charakterWladania = charakterWladania;
		}

		public String getUdzialy() {
			return udzialy;
		}

		public void setUdzialy(String udzialy) {
			this.udzialy = udzialy;
		}

		public String getPowierzchniaDzialki() {
			return powierzchniaDzialki;
		}

		public void setPowierzchniaDzialki(String powierzchniaDzialki) {
			this.powierzchniaDzialki = powierzchniaDzialki;
		}

		public String getPowierzchniaZabudowy() {
			return powierzchniaZabudowy;
		}

		public void setPowierzchniaZabudowy(String powierzchniaZabudowy) {
			this.powierzchniaZabudowy = powierzchniaZabudowy;
		}

		public String getOszacowanaWartosc() {
			return oszacowanaWartosc;
		}

		public void setOszacowanaWartosc(String oszacowanaWartosc) {
			this.oszacowanaWartosc = oszacowanaWartosc;
		}

		public String getPrzeznaczenie() {
			return przeznaczenie;
		}

		public void setPrzeznaczenie(String przeznaczenie) {
			this.przeznaczenie = przeznaczenie;
		}

		public String getAktualneWykorzystanie() {
			return aktualneWykorzystanie;
		}

		public void setAktualneWykorzystanie(String aktualneWykorzystanie) {
			this.aktualneWykorzystanie = aktualneWykorzystanie;
		}

		public String getPlanWykorzystaniaLata() {
			return planWykorzystaniaLata;
		}

		public void setPlanWykorzystaniaLata(String planWykorzystaniaLata) {
			this.planWykorzystaniaLata = planWykorzystaniaLata;
		}

		public String getUwagi() {
			return uwagi;
		}

		public void setUwagi(String uwagi) {
			this.uwagi = uwagi;
		}

		public String getSkladKomisji() {
			return skladKomisji;
		}

		public void setSkladKomisji(String skladKomisji) {
			this.skladKomisji = skladKomisji;
		}

		public Date getOperationDate() {
			return operationDate;
		}

		public void setOperationDate(Date operationDate) {
			this.operationDate = operationDate;
		}
	
}

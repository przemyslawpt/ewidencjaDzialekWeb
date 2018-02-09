package pl.ptaszek.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class DzialkaStara2 {
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		private String numerEwidencyjny;
		
		private String obreb;

		private String dokumentPotwierdzajacyWlasnosc;

		private String charakterWladania;

		private String udzialy;

		private String powierzchnia;

		private String klasyfikacjaGruntow;

		private String wartosc;
		
		private String powierzchniaDzialki;
		
		private String uzytkiSymbol;

		private String uzytkiPowierzchnia;

		private String przeznaczenie;

		private String aktualneWykorzystanie;

		private String planWykorzystania;

		private String uwagi;

		public DzialkaStara2(long id, String numerEwidencyjny, String obreb, String dokumentPotwierdzajacyWlasnosc,
				String charakterWladania, String udzialy, String powierzchnia, String klasyfikacjaGruntow,
				String wartosc, String powierzchniaDzialki, String uzytkiSymbol, String uzytkiPowierzchnia,
				String przeznaczenie, String aktualneWykorzystanie, String planWykorzystania, String uwagi) {
			super();
			this.id = id;
			this.numerEwidencyjny = numerEwidencyjny;
			this.obreb = obreb;
			this.dokumentPotwierdzajacyWlasnosc = dokumentPotwierdzajacyWlasnosc;
			this.charakterWladania = charakterWladania;
			this.udzialy = udzialy;
			this.powierzchnia = powierzchnia;
			this.klasyfikacjaGruntow = klasyfikacjaGruntow;
			this.wartosc = wartosc;
			this.powierzchniaDzialki = powierzchniaDzialki;
			this.uzytkiSymbol = uzytkiSymbol;
			this.uzytkiPowierzchnia = uzytkiPowierzchnia;
			this.przeznaczenie = przeznaczenie;
			this.aktualneWykorzystanie = aktualneWykorzystanie;
			this.planWykorzystania = planWykorzystania;
			this.uwagi = uwagi;
		}

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

		public String getDokumentPotwierdzajacyWlasnosc() {
			return dokumentPotwierdzajacyWlasnosc;
		}

		public void setDokumentPotwierdzajacyWlasnosc(String dokumentPotwierdzajacyWlasnosc) {
			this.dokumentPotwierdzajacyWlasnosc = dokumentPotwierdzajacyWlasnosc;
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

		public String getPowierzchnia() {
			return powierzchnia;
		}

		public void setPowierzchnia(String powierzchnia) {
			this.powierzchnia = powierzchnia;
		}

		public String getKlasyfikacjaGruntow() {
			return klasyfikacjaGruntow;
		}

		public void setKlasyfikacjaGruntow(String klasyfikacjaGruntow) {
			this.klasyfikacjaGruntow = klasyfikacjaGruntow;
		}

		public String getWartosc() {
			return wartosc;
		}

		public void setWartosc(String wartosc) {
			this.wartosc = wartosc;
		}

		public String getPowierzchniaDzialki() {
			return powierzchniaDzialki;
		}

		public void setPowierzchniaDzialki(String powierzchniaDzialki) {
			this.powierzchniaDzialki = powierzchniaDzialki;
		}

		public String getUzytkiSymbol() {
			return uzytkiSymbol;
		}

		public void setUzytkiSymbol(String uzytkiSymbol) {
			this.uzytkiSymbol = uzytkiSymbol;
		}

		public String getUzytkiPowierzchnia() {
			return uzytkiPowierzchnia;
		}

		public void setUzytkiPowierzchnia(String uzytkiPowierzchnia) {
			this.uzytkiPowierzchnia = uzytkiPowierzchnia;
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

		public String getPlanWykorzystania() {
			return planWykorzystania;
		}

		public void setPlanWykorzystania(String planWykorzystania) {
			this.planWykorzystania = planWykorzystania;
		}

		public String getUwagi() {
			return uwagi;
		}

		public void setUwagi(String uwagi) {
			this.uwagi = uwagi;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((aktualneWykorzystanie == null) ? 0 : aktualneWykorzystanie.hashCode());
			result = prime * result + ((charakterWladania == null) ? 0 : charakterWladania.hashCode());
			result = prime * result
					+ ((dokumentPotwierdzajacyWlasnosc == null) ? 0 : dokumentPotwierdzajacyWlasnosc.hashCode());
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + ((klasyfikacjaGruntow == null) ? 0 : klasyfikacjaGruntow.hashCode());
			result = prime * result + ((numerEwidencyjny == null) ? 0 : numerEwidencyjny.hashCode());
			result = prime * result + ((obreb == null) ? 0 : obreb.hashCode());
			result = prime * result + ((planWykorzystania == null) ? 0 : planWykorzystania.hashCode());
			result = prime * result + ((powierzchnia == null) ? 0 : powierzchnia.hashCode());
			result = prime * result + ((powierzchniaDzialki == null) ? 0 : powierzchniaDzialki.hashCode());
			result = prime * result + ((przeznaczenie == null) ? 0 : przeznaczenie.hashCode());
			result = prime * result + ((udzialy == null) ? 0 : udzialy.hashCode());
			result = prime * result + ((uwagi == null) ? 0 : uwagi.hashCode());
			result = prime * result + ((uzytkiPowierzchnia == null) ? 0 : uzytkiPowierzchnia.hashCode());
			result = prime * result + ((uzytkiSymbol == null) ? 0 : uzytkiSymbol.hashCode());
			result = prime * result + ((wartosc == null) ? 0 : wartosc.hashCode());
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
			DzialkaStara2 other = (DzialkaStara2) obj;
			if (aktualneWykorzystanie == null) {
				if (other.aktualneWykorzystanie != null)
					return false;
			} else if (!aktualneWykorzystanie.equals(other.aktualneWykorzystanie))
				return false;
			if (charakterWladania == null) {
				if (other.charakterWladania != null)
					return false;
			} else if (!charakterWladania.equals(other.charakterWladania))
				return false;
			if (dokumentPotwierdzajacyWlasnosc == null) {
				if (other.dokumentPotwierdzajacyWlasnosc != null)
					return false;
			} else if (!dokumentPotwierdzajacyWlasnosc.equals(other.dokumentPotwierdzajacyWlasnosc))
				return false;
			if (id != other.id)
				return false;
			if (klasyfikacjaGruntow == null) {
				if (other.klasyfikacjaGruntow != null)
					return false;
			} else if (!klasyfikacjaGruntow.equals(other.klasyfikacjaGruntow))
				return false;
			if (numerEwidencyjny == null) {
				if (other.numerEwidencyjny != null)
					return false;
			} else if (!numerEwidencyjny.equals(other.numerEwidencyjny))
				return false;
			if (obreb == null) {
				if (other.obreb != null)
					return false;
			} else if (!obreb.equals(other.obreb))
				return false;
			if (planWykorzystania == null) {
				if (other.planWykorzystania != null)
					return false;
			} else if (!planWykorzystania.equals(other.planWykorzystania))
				return false;
			if (powierzchnia == null) {
				if (other.powierzchnia != null)
					return false;
			} else if (!powierzchnia.equals(other.powierzchnia))
				return false;
			if (powierzchniaDzialki == null) {
				if (other.powierzchniaDzialki != null)
					return false;
			} else if (!powierzchniaDzialki.equals(other.powierzchniaDzialki))
				return false;
			if (przeznaczenie == null) {
				if (other.przeznaczenie != null)
					return false;
			} else if (!przeznaczenie.equals(other.przeznaczenie))
				return false;
			if (udzialy == null) {
				if (other.udzialy != null)
					return false;
			} else if (!udzialy.equals(other.udzialy))
				return false;
			if (uwagi == null) {
				if (other.uwagi != null)
					return false;
			} else if (!uwagi.equals(other.uwagi))
				return false;
			if (uzytkiPowierzchnia == null) {
				if (other.uzytkiPowierzchnia != null)
					return false;
			} else if (!uzytkiPowierzchnia.equals(other.uzytkiPowierzchnia))
				return false;
			if (uzytkiSymbol == null) {
				if (other.uzytkiSymbol != null)
					return false;
			} else if (!uzytkiSymbol.equals(other.uzytkiSymbol))
				return false;
			if (wartosc == null) {
				if (other.wartosc != null)
					return false;
			} else if (!wartosc.equals(other.wartosc))
				return false;
			return true;
		}
}
		
		

		
		
		

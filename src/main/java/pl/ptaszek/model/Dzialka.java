package pl.ptaszek.model;

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

		private String charakterWladania;

		private String udzialy;

		private String powierzchnia;

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
}

		

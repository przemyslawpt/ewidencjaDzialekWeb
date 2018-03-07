package pl.ptaszek.model;

/**
 * Opisuje obreb geodezyjny.
 *
 */
public class ObrebGeodezyjny {

	/**
	 * Number ewidencyjny.
	 */
	private String numerIdentyfinacyjny;

	private String miejscowosc;

	private String solectwo;

	public String getNumerIdentyfinacyjny() {
		return numerIdentyfinacyjny;
	}

	public void setNumerIdentyfinacyjny(String numerIdentyfinacyjny) {
		this.numerIdentyfinacyjny = numerIdentyfinacyjny;
	}

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	public String getSolectwo() {
		return solectwo;
	}

	public void setSolectwo(String solectwo) {
		this.solectwo = solectwo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((miejscowosc == null) ? 0 : miejscowosc.hashCode());
		result = prime * result + ((numerIdentyfinacyjny == null) ? 0 : numerIdentyfinacyjny.hashCode());
		result = prime * result + ((solectwo == null) ? 0 : solectwo.hashCode());
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
		ObrebGeodezyjny other = (ObrebGeodezyjny) obj;
		if (miejscowosc == null) {
			if (other.miejscowosc != null)
				return false;
		} else if (!miejscowosc.equals(other.miejscowosc))
			return false;
		if (numerIdentyfinacyjny == null) {
			if (other.numerIdentyfinacyjny != null)
				return false;
		} else if (!numerIdentyfinacyjny.equals(other.numerIdentyfinacyjny))
			return false;
		if (solectwo == null) {
			if (other.solectwo != null)
				return false;
		} else if (!solectwo.equals(other.solectwo))
			return false;
		return true;
	}

}

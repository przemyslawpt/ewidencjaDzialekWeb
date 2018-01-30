package pl.ptaszek.model;
/**
 * Klasa gruntu.
 *
 */
public class KlasaGruntu {

	private String rodzajGruntu;
	private String klasaBonitacyjna;
	private String oznaczenieKlasy;

	public KlasaGruntu(String rodzajGruntu, String klasaBonitacyjna, String oznaczenieKlasy) {
		super();
		this.rodzajGruntu = rodzajGruntu;
		this.klasaBonitacyjna = klasaBonitacyjna;
		this.oznaczenieKlasy = oznaczenieKlasy;
	}

	public String getRodzajGruntu() {
		return rodzajGruntu;
	}

	public void setRodzajGruntu(String rodzajGruntu) {
		this.rodzajGruntu = rodzajGruntu;
	}

	public String getKlasaBonitacyjna() {
		return klasaBonitacyjna;
	}

	public void setKlasaBonitacyjna(String klasaBonitacyjna) {
		this.klasaBonitacyjna = klasaBonitacyjna;
	}

	public String getOznaczenieKlasy() {
		return oznaczenieKlasy;
	}

	public void setOznaczenieKlasy(String oznaczenieKlasy) {
		this.oznaczenieKlasy = oznaczenieKlasy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((klasaBonitacyjna == null) ? 0 : klasaBonitacyjna.hashCode());
		result = prime * result + ((oznaczenieKlasy == null) ? 0 : oznaczenieKlasy.hashCode());
		result = prime * result + ((rodzajGruntu == null) ? 0 : rodzajGruntu.hashCode());
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
		KlasaGruntu other = (KlasaGruntu) obj;
		if (klasaBonitacyjna == null) {
			if (other.klasaBonitacyjna != null)
				return false;
		} else if (!klasaBonitacyjna.equals(other.klasaBonitacyjna))
			return false;
		if (oznaczenieKlasy == null) {
			if (other.oznaczenieKlasy != null)
				return false;
		} else if (!oznaczenieKlasy.equals(other.oznaczenieKlasy))
			return false;
		if (rodzajGruntu == null) {
			if (other.rodzajGruntu != null)
				return false;
		} else if (!rodzajGruntu.equals(other.rodzajGruntu))
			return false;
		return true;
	}

}

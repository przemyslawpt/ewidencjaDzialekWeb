package pl.ptaszek.model;

public class PowierzchniaKlasyGruntu {
	
	private String powierzchnia;
	
	private KlasaGruntu klasaGruntu;

	public PowierzchniaKlasyGruntu(String powierzchnia, KlasaGruntu klasaGruntu) {
		super();
		this.powierzchnia = powierzchnia;
		this.klasaGruntu = klasaGruntu;
	}

	public String getPowierzchnia() {
		return powierzchnia;
	}

	public void setPowierzchnia(String powierzchnia) {
		this.powierzchnia = powierzchnia;
	}

	public KlasaGruntu getKlasaGruntu() {
		return klasaGruntu;
	}

	public void setKlasaGruntu(KlasaGruntu klasaGruntu) {
		this.klasaGruntu = klasaGruntu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((klasaGruntu == null) ? 0 : klasaGruntu.hashCode());
		result = prime * result + ((powierzchnia == null) ? 0 : powierzchnia.hashCode());
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
		PowierzchniaKlasyGruntu other = (PowierzchniaKlasyGruntu) obj;
		if (klasaGruntu == null) {
			if (other.klasaGruntu != null)
				return false;
		} else if (!klasaGruntu.equals(other.klasaGruntu))
			return false;
		if (powierzchnia == null) {
			if (other.powierzchnia != null)
				return false;
		} else if (!powierzchnia.equals(other.powierzchnia))
			return false;
		return true;
	} 

}

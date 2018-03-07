package pl.ptaszek.model;
public class ObciazenieRzeczowe {

	private TypObciazenia typObciazenia;

	public ObciazenieRzeczowe(TypObciazenia typObciazenia) {
		super();
		this.typObciazenia = typObciazenia;
	}

	public TypObciazenia getTypObciazenia() {
		return typObciazenia;
	}

	public void setTypObciazenia(TypObciazenia typObciazenia) {
		this.typObciazenia = typObciazenia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typObciazenia == null) ? 0 : typObciazenia.hashCode());
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
		ObciazenieRzeczowe other = (ObciazenieRzeczowe) obj;
		if (typObciazenia != other.typObciazenia)
			return false;
		return true;
	}

}

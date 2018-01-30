package pl.ptaszek.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Wycena {

	private BigDecimal cena;

	private Date data;

	List<Wyceniajacy> wyceniajacyList;

	public Wycena(BigDecimal cena, Date data, List<Wyceniajacy> wyceniajacyList) {
		super();
		this.cena = cena;
		this.data = data;
		this.wyceniajacyList = wyceniajacyList;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Wyceniajacy> getWyceniajacyList() {
		return wyceniajacyList;
	}

	public void setWyceniajacyList(List<Wyceniajacy> wyceniajacyList) {
		this.wyceniajacyList = wyceniajacyList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cena == null) ? 0 : cena.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((wyceniajacyList == null) ? 0 : wyceniajacyList.hashCode());
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
		Wycena other = (Wycena) obj;
		if (cena == null) {
			if (other.cena != null)
				return false;
		} else if (!cena.equals(other.cena))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (wyceniajacyList == null) {
			if (other.wyceniajacyList != null)
				return false;
		} else if (!wyceniajacyList.equals(other.wyceniajacyList))
			return false;
		return true;
	}

}

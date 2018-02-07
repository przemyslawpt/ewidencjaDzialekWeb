package pl.ptaszek.model;

import java.util.List;

public class DzialkaNiezabudowana extends DzialkaStara{
	
  private List<PowierzchniaKlasyGruntu> powierzchniaKlasyGruntu;

 public DzialkaNiezabudowana() {
	 
 }
  
public DzialkaNiezabudowana(List<PowierzchniaKlasyGruntu> powierzchniaKlasyGruntu) {
	super();
	this.powierzchniaKlasyGruntu = powierzchniaKlasyGruntu;
}

public List<PowierzchniaKlasyGruntu> getPowierzchniaKlasyGruntu() {
	return powierzchniaKlasyGruntu;
}

public void setPowierzchniaKlasyGruntu(List<PowierzchniaKlasyGruntu> powierzchniaKlasyGruntu) {
	this.powierzchniaKlasyGruntu = powierzchniaKlasyGruntu;
}
/**
 * Nie mo�na doda� to string.
 */
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((powierzchniaKlasyGruntu == null) ? 0 : powierzchniaKlasyGruntu.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	DzialkaNiezabudowana other = (DzialkaNiezabudowana) obj;
	if (powierzchniaKlasyGruntu == null) {
		if (other.powierzchniaKlasyGruntu != null)
			return false;
	} else if (!powierzchniaKlasyGruntu.equals(other.powierzchniaKlasyGruntu))
		return false;
	return true;
}



}

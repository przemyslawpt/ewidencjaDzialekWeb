package pl.ptaszek.dao;

import java.util.Date;
import java.util.List;

import pl.ptaszek.model.DzialkaHistory;

public interface DzialkaHistoryDao {

	void save(DzialkaHistory dzialka);

	DzialkaHistory get(Long id);

	List<DzialkaHistory> findBy(String numerEwidencyjnyDzialka, String obrebGeodezyjny, String rodzajDokumentuWlasnosci,
			String numerDokumentuWlasnosci, String charakterWladania, String udzialy, String powierzchniaDzialki,
			String powierzchniaZabudowy, String oszacowanaWartosc, String przeznaczenie, String aktualneWykorzystanie,
			String planWykorzystania, String uwagi, String skladKomisji, Date stanNaDzien);

}
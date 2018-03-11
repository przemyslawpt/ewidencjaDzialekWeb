package pl.ptaszek.dao;

import java.util.List;

import pl.ptaszek.model.Dzialka;

public interface DzialkaDao {

	void save(Dzialka dzialka);
	
	void update(Dzialka dzialka);

	Dzialka get(Long id);
	
	List<Dzialka> findBy(String numerEwidencyjnyDzialka, String obrebGeodezyjny, String rodzajDokumentuWlasnosci,
			String numerDokumentuWlasnosci, String charakterWladania, String udzialy, String powierzchniaDzialki,
			String powierzchniaZabudowy, String oszacowanaWartosc, String przeznaczenie, String aktualneWykorzystanie,
			String planWykorzystania, String uwagi, String skladKomisji);
	
	List<Dzialka> list();
	
	void saveAll(List<Dzialka> dzialkaList);
}
package pl.ptaszek.service;

import java.util.Date;
import java.util.List;

import pl.ptaszek.model.CalkowitaWartoscPrzeznaczenia;
import pl.ptaszek.model.Dzialka;
import pl.ptaszek.model.DzialkaHistory;

public interface DzialkaService {

	void save(Dzialka dzialka);
	
	void update(Dzialka dzialka);

	void saveAll(List<Dzialka> dzialkaList);
	
	void copyAll(List<Dzialka> dzialkaList);
	
	Dzialka get(Long id);
	
	List<Dzialka> findBy(String numerEwidencyjnyDzialka, String obrebGeodezyjny,
			String rodzajDokumentuWlasnosci, String numerDokumentuWlasnosci, String charakterWladania,
			String udzialy, String powierzchniaDzialki, String powierzchniaZabudowy, String oszacowanaWartosc,
			String przeznaczenie, String aktualneWykorzystanie, String planWykorzystania, String uwagi,
			String skladKomisji);
	
	List<DzialkaHistory> findBy(String numerEwidencyjnyDzialka, String obrebGeodezyjny,
			String rodzajDokumentuWlasnosci, String numerDokumentuWlasnosci, String charakterWladania,
			String udzialy, String powierzchniaDzialki, String powierzchniaZabudowy, String oszacowanaWartosc,
			String przeznaczenie, String aktualneWykorzystanie, String planWykorzystania, String uwagi,
			String skladKomisji, Date stanNaDzien);
	
	List<Dzialka> list();
	
	List<CalkowitaWartoscPrzeznaczenia> createPodsumowanie(Date stanNaDzien);
}

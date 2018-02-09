package pl.ptaszek.service;

import java.util.List;

import pl.ptaszek.model.Dzialka;

public interface DzialkaService {

	void save(Dzialka dzialka);

	Dzialka get(Long id);
	
	List<Dzialka> findBy(String numerEwidencyjny, String obreb);
	
	List<Dzialka> list();
}

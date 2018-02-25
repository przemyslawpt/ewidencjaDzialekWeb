package pl.ptaszek.dao;

import java.util.List;

import pl.ptaszek.model.Dzialka;

public interface DzialkaDao {

	void save(Dzialka user);

	Dzialka get(Long id);
	
	List<Dzialka> findBy(String numerEwidencyjny, String obreb);
	
	List<Dzialka> list();
	
	void saveAll(List<Dzialka> dzialkaList);
}

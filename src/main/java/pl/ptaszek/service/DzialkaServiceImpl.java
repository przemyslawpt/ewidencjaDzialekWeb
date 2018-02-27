package pl.ptaszek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ptaszek.dao.DzialkaDao;
import pl.ptaszek.model.Dzialka;

@Service
public class DzialkaServiceImpl implements DzialkaService {

	@Autowired
	private DzialkaDao dzialkaDao;

	public void save(Dzialka dzialka) {
		dzialkaDao.save(dzialka);
	}

	@Override
	public Dzialka get(Long id) {
		return dzialkaDao.get(id);
	}

	public List<Dzialka> list() {
		return dzialkaDao.list();
	}

	@Override
	public List<Dzialka> findBy(String numerEwidencyjny, String obreb) {
		return dzialkaDao.findBy(numerEwidencyjny, obreb);
	}

	@Override
	public void saveAll(List<Dzialka> dzialkaList) {
		dzialkaDao.saveAll(dzialkaList);
		
	}

}
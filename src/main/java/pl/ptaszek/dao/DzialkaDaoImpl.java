package pl.ptaszek.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.ptaszek.model.Dzialka;

@Component
public class DzialkaDaoImpl implements DzialkaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Dzialka dzialka) {
		sessionFactory.openSession().save(dzialka);		
	}

	@SuppressWarnings("unchecked")
	public List<Dzialka> list() {
		return sessionFactory.openSession().createCriteria(Dzialka.class).list();
	}

	@Override
	public Dzialka get(Long id) {
		return sessionFactory.openSession().get(Dzialka.class, id);

	}

	@Override
	public List<Dzialka> findBy(String numerEwidencyjny, String obreb) {
		return sessionFactory.openSession().createCriteria(Dzialka.class).add(Restrictions.eq("numerEwidencyjny",numerEwidencyjny)).add(Restrictions.eq("obreb",obreb)).list();

	}

}

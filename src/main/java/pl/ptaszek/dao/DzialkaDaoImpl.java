package pl.ptaszek.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.ptaszek.model.Dzialka;

@Component
public class DzialkaDaoImpl implements DzialkaDao {

	Logger logger = Logger.getLogger(DzialkaDaoImpl.class);

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
		return sessionFactory.openSession().createCriteria(Dzialka.class)
				.add(Restrictions.eq("numerEwidencyjny", numerEwidencyjny)).add(Restrictions.eq("obreb", obreb)).list();

	}

	@Override
	public void saveAll(List<Dzialka> dzialkaList) {
		Session session = sessionFactory.openSession();
		System.out.println("Dzialki to add: " + dzialkaList.size());
		logger.error("Dzialki to add: " + dzialkaList.size());
		for (Dzialka dzialka : dzialkaList) {
			session.save(dzialka);
		}
	}
}

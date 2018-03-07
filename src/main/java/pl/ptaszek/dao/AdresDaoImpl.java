package pl.ptaszek.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.ptaszek.model.Adres;

@Component
public class AdresDaoImpl implements AdresDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Adres adres) {
		sessionFactory.getCurrentSession().delete(adres);
	}

	@SuppressWarnings("unchecked")
	public List<Adres> list() {
		return sessionFactory.openSession().createCriteria(Adres.class).list();
	}

}

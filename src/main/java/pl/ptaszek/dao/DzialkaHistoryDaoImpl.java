package pl.ptaszek.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.ptaszek.model.DzialkaHistory;

@Component
public class DzialkaHistoryDaoImpl implements DzialkaHistoryDao {

	Logger logger = Logger.getLogger(DzialkaHistoryDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DzialkaHistory dzialkaHistory) {
		Session session = sessionFactory.openSession();
		session.save(dzialkaHistory);
		session.flush();
		session.close();
	}

	@Override
	public DzialkaHistory get(Long id) {
		Session session = sessionFactory.openSession();
		DzialkaHistory result = session.get(DzialkaHistory.class, id);
		session.flush();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DzialkaHistory> findBy(String numerEwidencyjnyDzialka, String obrebGeodezyjny,
			String rodzajDokumentuWlasnosci, String numerDokumentuWlasnosci, String charakterWladania, String udzialy,
			String powierzchniaDzialki, String powierzchniaZabudowy, String oszacowanaWartosc, String przeznaczenie,
			String aktualneWykorzystanie, String planWykorzystania, String uwagi, String skladKomisji,
			Date stanNaDzien) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(DzialkaHistory.class);
		if (isSetNotEmpty(numerEwidencyjnyDzialka)) {
			criteria.add(Restrictions.eq("numerEwidencyjny", numerEwidencyjnyDzialka));
		}
		if (isSetNotEmpty(obrebGeodezyjny)) {
			criteria.add(Restrictions.eq("obreb", obrebGeodezyjny));
		}
		if (isSetNotEmpty(rodzajDokumentuWlasnosci)) {
			criteria.add(Restrictions.eq("wlasnoscRodzajDokumentu", rodzajDokumentuWlasnosci));
		}
		if (isSetNotEmpty(numerDokumentuWlasnosci)) {
			criteria.add(Restrictions.eq("wlasnoscNumerDokumentu", numerDokumentuWlasnosci));
		}
		if (isSetNotEmpty(charakterWladania)) {
			criteria.add(Restrictions.eq("charakterWladania", charakterWladania));
		}
		if (isSetNotEmpty(udzialy)) {
			criteria.add(Restrictions.eq("udzialy", udzialy));
		}
		if (isSetNotEmpty(powierzchniaDzialki)) {
			criteria.add(Restrictions.eq("powierzchniaDzialki", powierzchniaDzialki));
		}
		if (isSetNotEmpty(powierzchniaZabudowy)) {
			criteria.add(Restrictions.eq("powierzchniaZabudowy", powierzchniaZabudowy));
		}
		if (isSetNotEmpty(oszacowanaWartosc)) {
			criteria.add(Restrictions.eq("oszacowanaWartosc", oszacowanaWartosc));
		}
		if (isSetNotEmpty(przeznaczenie)) {
			criteria.add(Restrictions.eq("przeznaczenie", przeznaczenie));
		}
		if (isSetNotEmpty(aktualneWykorzystanie)) {
			criteria.add(Restrictions.eq("aktualneWykorzystanie", aktualneWykorzystanie));
		}
		if (isSetNotEmpty(planWykorzystania)) {
			criteria.add(Restrictions.eq("planWykorzystaniaLata", planWykorzystania));
		}
		if (isSetNotEmpty(uwagi)) {
			criteria.add(Restrictions.eq("uwagi", uwagi));
		}
		if (isSetNotEmpty(skladKomisji)) {
			criteria.add(Restrictions.eq("skladKomisji", skladKomisji));
		}
		if (stanNaDzien != null) {
			criteria.add(Restrictions.le("operationDate", stanNaDzien));
		}
		List<DzialkaHistory> result = criteria.list();
		session.flush();
		session.close();
		return result;
	}

	private boolean isSetNotEmpty(String property) {
		if (property == null) {
			return false;
		}
		return !property.isEmpty();
	}
}

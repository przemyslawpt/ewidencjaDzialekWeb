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

import pl.ptaszek.model.Dzialka;
import pl.ptaszek.model.DzialkaHistory;
import pl.ptaszek.model.OperationType;

@Component
public class DzialkaDaoImpl implements DzialkaDao {

	Logger logger = Logger.getLogger(DzialkaDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Dzialka dzialka) {
		Session session = sessionFactory.openSession();
		session.save(dzialka);
		session.flush();
		session.close();
	}

	@Override
	public void update(Dzialka dzialka) {
		Session session = sessionFactory.openSession();
		session.update(dzialka);
		session.flush();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Dzialka> list() {
		Session session = sessionFactory.openSession();
		List<Dzialka> result = session.createCriteria(Dzialka.class).list();
		session.flush();
		session.close();
		return result;
	}

	@Override
	public Dzialka get(Long id) {
		Session session = sessionFactory.openSession();
		Dzialka result = session.get(Dzialka.class, id);
		session.flush();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dzialka> findBy(String numerEwidencyjnyDzialka, String obrebGeodezyjny,
			String rodzajDokumentuWlasnosci, String numerDokumentuWlasnosci, String charakterWladania,
			String udzialy, String powierzchniaDzialki, String powierzchniaZabudowy, String oszacowanaWartosc,
			String przeznaczenie, String aktualneWykorzystanie, String planWykorzystania, String uwagi,
			String skladKomisji){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Dzialka.class);	
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
		List<Dzialka> result = criteria.list();
		session.flush();
		session.close();
		return result;
	}
	
	private boolean isSetNotEmpty(String property) {
		if(property==null) {
			return false;
		}
		return !property.isEmpty();
	}
	
	@Override
	public void saveAll(List<Dzialka> dzialkaList) {
		Session session = sessionFactory.openSession();
		System.out.println("Dzialki to add: " + dzialkaList.size());
		logger.error("Dzialki to add: " + dzialkaList.size());
		for (Dzialka dzialka : dzialkaList) {
			dzialka.setOperationDate(new Date());
			session.save(dzialka);
			DzialkaHistory dzialkaHistory = convertDzialka(dzialka);
			dzialkaHistory.setOperationDate(new Date());
			dzialkaHistory.setOperationType(OperationType.ADD);
			session.save(dzialkaHistory);
		}
		session.flush();
		session.close();
	}
	
	private DzialkaHistory convertDzialka(Dzialka dzialka) {
		DzialkaHistory dzialkaHistory = new DzialkaHistory();
		dzialkaHistory.setRzeczywistaDzialkaId(dzialka.getId());
		dzialkaHistory.setNumerEwidencyjny(dzialka.getNumerEwidencyjny());
		dzialkaHistory.setObreb(dzialka.getObreb());
		dzialkaHistory.setWlasnoscRodzajDokumentu(dzialka.getWlasnoscRodzajDokumentu());
		dzialkaHistory.setWlasnoscNumerDokumentu(dzialka.getWlasnoscNumerDokumentu());
		dzialkaHistory.setCharakterWladania(dzialka.getCharakterWladania());
		dzialkaHistory.setUdzialy(dzialka.getUdzialy());
		dzialkaHistory.setPowierzchniaDzialki(dzialka.getPowierzchniaDzialki());
		dzialkaHistory.setPowierzchniaZabudowy(dzialka.getPowierzchniaZabudowy());
		dzialkaHistory.setOszacowanaWartosc(dzialka.getOszacowanaWartosc());
		dzialkaHistory.setPrzeznaczenie(dzialka.getPrzeznaczenie());
		dzialkaHistory.setAktualneWykorzystanie(dzialka.getAktualneWykorzystanie());
		dzialkaHistory.setPlanWykorzystaniaLata(dzialka.getPlanWykorzystaniaLata());
		dzialkaHistory.setUwagi(dzialka.getUwagi());
		dzialkaHistory.setSkladKomisji(dzialka.getSkladKomisji());
		return dzialkaHistory;
	}
}

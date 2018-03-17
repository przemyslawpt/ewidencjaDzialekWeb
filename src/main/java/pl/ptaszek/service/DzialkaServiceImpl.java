package pl.ptaszek.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ptaszek.controller.DzialkaWebController;
import pl.ptaszek.dao.DzialkaDao;
import pl.ptaszek.dao.DzialkaHistoryDao;
import pl.ptaszek.model.CalkowitaWartoscPrzeznaczenia;
import pl.ptaszek.model.Dzialka;
import pl.ptaszek.model.DzialkaHistory;
import pl.ptaszek.model.OperationType;

@Service
public class DzialkaServiceImpl implements DzialkaService {
	
	Logger logger = Logger.getLogger(DzialkaServiceImpl.class);
	
	@Autowired
	private DzialkaDao dzialkaDao;
	@Autowired
	private DzialkaHistoryDao dzialkaHistoryDao;

	public void save(Dzialka dzialka) {
		dzialka.setOperationDate(new Date());
		dzialkaDao.save(dzialka);
		DzialkaHistory dzialkaHistory = convertDzialka(dzialka);
		dzialkaHistory.setOperationType(OperationType.ADD);
		dzialkaHistory.setOperationDate(new Date());
		dzialkaHistoryDao.save(dzialkaHistory);
	}
	
	@Override
	public void update(Dzialka dzialka) {
		dzialka.setOperationDate(new Date());
		dzialkaDao.update(dzialka);
		DzialkaHistory dzialkaHistory = convertDzialka(dzialka);
		dzialkaHistory.setOperationType(OperationType.UPDATE);
		dzialkaHistory.setOperationDate(new Date());
		dzialkaHistoryDao.save(dzialkaHistory);
	}

	@Override
	public Dzialka get(Long id) {
		return dzialkaDao.get(id);
	}

	public List<Dzialka> list() {
		return dzialkaDao.list();
	}

	@Override
	public List<Dzialka> findBy(String numerEwidencyjnyDzialka, String obrebGeodezyjny, String rodzajDokumentuWlasnosci,
			String numerDokumentuWlasnosci, String charakterWladania, String udzialy, String powierzchniaDzialki,
			String powierzchniaZabudowy, String oszacowanaWartosc, String przeznaczenie, String aktualneWykorzystanie,
			String planWykorzystania, String uwagi, String skladKomisji) {
		
		return dzialkaDao.findBy(numerEwidencyjnyDzialka, obrebGeodezyjny, rodzajDokumentuWlasnosci,
				numerDokumentuWlasnosci, charakterWladania, udzialy, powierzchniaDzialki, powierzchniaZabudowy,
				oszacowanaWartosc, przeznaczenie, aktualneWykorzystanie, planWykorzystania, uwagi, skladKomisji);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DzialkaHistory> findBy(String numerEwidencyjnyDzialka, String obrebGeodezyjny,
			String rodzajDokumentuWlasnosci, String numerDokumentuWlasnosci, String charakterWladania, String udzialy,
			String powierzchniaDzialki, String powierzchniaZabudowy, String oszacowanaWartosc, String przeznaczenie,
			String aktualneWykorzystanie, String planWykorzystania, String uwagi, String skladKomisji,
			Date stanNaDzien) {

		List<DzialkaHistory> allFilteredFromHistory = dzialkaHistoryDao.findBy(numerEwidencyjnyDzialka, obrebGeodezyjny,
				rodzajDokumentuWlasnosci, numerDokumentuWlasnosci, charakterWladania, udzialy, powierzchniaDzialki,
				powierzchniaZabudowy, oszacowanaWartosc, przeznaczenie, aktualneWykorzystanie, planWykorzystania, uwagi,
				skladKomisji, stanNaDzien);

		Map<Long, DzialkaHistory> rzeczywistaDzialkaIdMap = new HashMap<>();
		for (DzialkaHistory dzialkaHistory : allFilteredFromHistory) {
			Long dzialkaId = dzialkaHistory.getRzeczywistaDzialkaId();
			if (!rzeczywistaDzialkaIdMap.containsKey(dzialkaId)) {
				rzeczywistaDzialkaIdMap.put(dzialkaId, dzialkaHistory);
			} else {
				if (dzialkaHistory.getOperationDate()
						.after(rzeczywistaDzialkaIdMap.get(dzialkaId).getOperationDate())) {
					rzeczywistaDzialkaIdMap.put(dzialkaId, dzialkaHistory);
				}
			}
		}
		return new ArrayList(rzeczywistaDzialkaIdMap.values());
	}

	@Override
	public void saveAll(List<Dzialka> dzialkaList) {
		dzialkaDao.saveAll(dzialkaList);	
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

	@Override
	public List<CalkowitaWartoscPrzeznaczenia> createPodsumowanie(Date stanNaDzien) {
		List<CalkowitaWartoscPrzeznaczenia> calkowitaWartoscPrzeznaczeniaList = new ArrayList<CalkowitaWartoscPrzeznaczenia>();
		List<DzialkaHistory> dzialkaList = findBy(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, stanNaDzien);
		Map<String, List<String>> przeznaczenieWartoscListMap = new HashMap<>();
		for (DzialkaHistory dzialka : dzialkaList) {
			addToMap(przeznaczenieWartoscListMap, dzialka.getPrzeznaczenie(), dzialka.getOszacowanaWartosc());
		}
		int allitemsCounter = 0;
		for (String key : przeznaczenieWartoscListMap.keySet()) {
			allitemsCounter = allitemsCounter + przeznaczenieWartoscListMap.get(key).size();
		}
		logger.error("Liczba elementow:" + allitemsCounter);
		for (String key : przeznaczenieWartoscListMap.keySet()) {
			CalkowitaWartoscPrzeznaczenia calkowitaWartoscPrzeznaczenia = new CalkowitaWartoscPrzeznaczenia();
			calkowitaWartoscPrzeznaczenia.setPrzeznaczenie(key);
			BigDecimal wartosc = BigDecimal.ZERO;
			for (String oszacowanaWartosc : przeznaczenieWartoscListMap.get(key)) {
				if (oszacowanaWartosc != null) {
					oszacowanaWartosc = oszacowanaWartosc.trim();
					BigDecimal tempOszacowaniaWartosc;
					try {
						tempOszacowaniaWartosc = new BigDecimal(oszacowanaWartosc);
					} catch (Exception ex) {
						tempOszacowaniaWartosc = BigDecimal.ZERO;
						logger.error("Niepprawna wartosc liczbowa dla przeznaczenie: " + oszacowanaWartosc);
					}
					wartosc = wartosc.add(tempOszacowaniaWartosc);
				}
			}
			calkowitaWartoscPrzeznaczenia
					.setCalkowitaWartoscOszacowana(wartosc.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
			calkowitaWartoscPrzeznaczeniaList.add(calkowitaWartoscPrzeznaczenia);
		}
		return calkowitaWartoscPrzeznaczeniaList;
	}
	
	private void addToMap(Map<String, List<String>> map, String key, String value) {
		key = key.trim();
		if (map.get(key) == null) {
			map.put(key, new ArrayList<String>());
		}
		map.get(key).add(value.trim().replace(",", "."));
	}
	
}
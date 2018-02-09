package pl.ptaszek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ptaszek.dao.AdresDao;
import pl.ptaszek.model.Adres;


@Service
public class AdresServiceImpl implements AdresService {

	@Autowired
	private AdresDao adresDao;

	public void save(Adres adres) {
		adresDao.save(adres);
	}

	public List<Adres> list() {
		return adresDao.list();
	}

}
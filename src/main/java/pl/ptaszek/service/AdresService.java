package pl.ptaszek.service;

import java.util.List;

import pl.ptaszek.model.Adres;

public interface AdresService {

	void save(Adres adres);

	List<Adres> list();

}

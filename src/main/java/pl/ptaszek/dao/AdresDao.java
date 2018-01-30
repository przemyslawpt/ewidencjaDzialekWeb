package pl.ptaszek.dao;

import java.util.List;

import pl.ptaszek.model.Adres;

public interface AdresDao {

	void save(Adres user);

	List<Adres> list();
}

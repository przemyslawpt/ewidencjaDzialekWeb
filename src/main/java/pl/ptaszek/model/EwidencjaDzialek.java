package pl.ptaszek.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Przechowuje rejestr dzialek z przypisaniem do osoby
 **/
public class EwidencjaDzialek {
	/**
	 * Rejestr dzialek
	 */
	private Map<Osoba, Set<Dzialka>> rejestr;

	public EwidencjaDzialek() {
		rejestr = new HashMap<Osoba, Set<Dzialka>>();
	}

	/**
	 * @param osoba
	 *            osoba
	 * @param dzialka
	 *            dzialka
	 */
	public void dodajDzialka(Osoba osoba, Dzialka dzialka) {
		Set<Dzialka> dzialkiOsoby = rejestr.get(osoba);
		if (dzialkiOsoby == null) {
			rejestr.put(osoba, new HashSet<Dzialka>());
		}
		rejestr.get(osoba).add(dzialka);
	}

	/**
	 * Usuwa dzialke
	 * 
	 * @param osoba
	 * @param dzialka
	 */
	public void usunDzialka(Osoba osoba, Dzialka dzialka) {
		if (rejestr.get(osoba) == null) {
			return;
		}
		rejestr.get(osoba).remove(dzialka);
	}

	/**
	 * Wyswietla dzialki dla danej osoby
	 * 
	 * @param osoba
	 * @return
	 */
	public Set<Dzialka> podajDzialki(Osoba osoba) {
		return rejestr.get(osoba);
	}

	public void wyswietlDzialki(Osoba osoba) {
		System.out.println("------------");
		System.out.println(osoba);
		Set<Dzialka> dzialkiOsoby = rejestr.get(osoba);
		if (dzialkiOsoby == null) {
			return;
		}
		System.out.println("------------");
		for (Dzialka dzialka : dzialkiOsoby) {
			System.out.println(dzialka);
		}
		System.out.println("------------");
	}

	/**
	 * 
	 * @return ilosc dzialek dla osoby
	 */
	public int podajlIloscDzialek(Osoba osoba) {
		Set<Dzialka> dzialkiOsoby = rejestr.get(osoba);
		if (dzialkiOsoby == null) {
			return -1;
		}
		return dzialkiOsoby.size();

	}
}

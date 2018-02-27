package pl.ptaszek.config;

import org.beanio.*;
import org.springframework.util.StringUtils;

import pl.ptaszek.model.Dzialka;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Konwersja danych z Excell do kolekcji obiektow.
 * @author PPs
 *
 */
public class Konwersja {

	private static final String PATH = "C:\\Users\\Radek\\ewidencjaDzialekWeb\\src\\main\\java\\pl\\ptaszek\\config\\";
	
	public static List<Dzialka> stworzDzialkiZPliku() {
		List<Dzialka> dzialkaList = new ArrayList<>();
		StreamFactory factory = StreamFactory.newInstance();
		// load the mapping file
		factory.load(PATH + "konwersjaMapowanie.xml");
		// use a StreamFactory to create a BeanReader
		 BeanReader in = factory.createReader("Dzialki", new File(PATH+"GMINNA EWIDENCJA_20.02.2018v2.csv"));
		//BeanReader in = factory.createReader("Dzialki", new File(PATH + "oneL.csv"));
		Dzialka dzialka;
		while ((dzialka = (Dzialka) in.read()) != null) {
			if (StringUtils.isEmpty(dzialka.getUdzialy())) {
				dzialka.setUdzialy("1/1");
			}
			if (!"OBRĘB".equals(dzialka.getObreb()) && !StringUtils.isEmpty(dzialka.getNumerEwidencyjny())) {
				dzialkaList.add(dzialka);
			}
		}
		in.close();
		return dzialkaList;
	}
	
	public static void main(String[] argc) {
		List<Dzialka> dzialkaList = stworzDzialkiZPliku(); 
        Integer licznik = 0;
        for(Dzialka dzialka: dzialkaList) {
           System.out.println("----");
           System.out.println("Nr " + licznik++);
           System.out.println("Obreb: " + dzialka.getObreb());
           System.out.println("Numer ewidencyjny: " + dzialka.getNumerEwidencyjny());;
           System.out.println("rodzajDokumentyPotwierdzajacyWlasnosc: " + dzialka.getWlasnoscRodzajDokumentu());
           System.out.println("numerDokumentuPotwierdzajacyWlasnosc: " + dzialka.getWlasnoscNumerDokumentu());
           System.out.println("charakterWladania: " + dzialka.getCharakterWladania());
           System.out.println("udzialy: " + dzialka.getUdzialy());
           System.out.println("powierzchniaDzialki: " + dzialka.getPowierzchniaDzialki());
           System.out.println("powierzchniaZabudowy: " + dzialka.getPowierzchniaZabudowy());
           System.out.println("przeznaczenie: " + dzialka.getPrzeznaczenie());
           System.out.println("aktualneWykorzystanie: " + dzialka.getAktualneWykorzystanie());
           System.out.println("oszacowanaWartoscNieruchomosci: " + dzialka.getOszacowanaWartosc());
           System.out.println("planWykorzystaniaLata: " + dzialka.getPlanWykorzystaniaLata());
           System.out.println("uwagi: " + dzialka.getUwagi());
           System.out.println("skladKomisji: " + dzialka.getSkladKomisji());
           System.out.println("");
           System.out.println("----");
        }
/*   		private String numerEwidencyjny; //  C
		
   		private String obreb; // B
   		
   		private String rodzajDokumentyPotwierdzajacyWlasnosc; //  M
   		
   		private String numerDokumentuPotwierdzajacyWlasnosc; // L

   		private String charakterWladania; // G

   		private String udzialy; //H kiedy puste 1/1

   		private String powierzchniaDzialki; //E
   		
   		private String powierzchniaZabudowy; //BG
   		
   		private String oszacowanaWartoscNieruchomosci; // O SUM(P,BF)
   		
   		private String przeznaczenie; //BJ
   		
   		private String aktualneWykorzystanie; // BH
*/        }
 
}

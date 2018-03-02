package pl.ptaszek.config;

import org.beanio.*;
import org.springframework.util.StringUtils;

import pl.ptaszek.model.Dzialka;

import java.io.*;
import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Konwersja danych z Excell do kolekcji obiektow.
 * @author PPs
 *
 */
public class Konwersja {


	private static final String PATH = "C:\\ewidencjaDzialekWeb\\ewidencjaDzialekWeb\\src\\main\\java\\pl\\ptaszek\\config\\";
	
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
	
	public static void wydrukujListaDzialek() {
		List<Dzialka> dzialki = new ArrayList<>();
		Dzialka dzialka1 = new Dzialka();
		dzialka1.setNumerEwidencyjny("12");
		dzialka1.setObreb("Domaradz");
		Dzialka dzialka2 = new Dzialka();
		dzialka2.setNumerEwidencyjny("18");
		dzialka2.setObreb("Zieleniec");
		dzialki.add(dzialka1);
		dzialki.add(dzialka2);
		String text = "Stan dzialek na dzien 1 grudnia 2016";
		// zadania stworzyc plik dzialki.csv ktory bedzie zawieraj
		// linie z text oraz dwie dzialki z wykorzystanie biblioteki BeanIO
		//plik do mapowania w obecnym katalogu: asiaMapowanie.xml
		// plik wynikowy z plikiem "csv" otwieralnym w excelu asiaWyniki.csv
		System.out.println("Gdzie jest plik ? Bierz sie do roboty leniu.");
	}
	
	public static void mgain(String[] argc) {
		wydrukujListaDzialek(); 
        Integer licznik = 0;
//        for(Dzialka dzialka: dzialkaList) {
//           System.out.println("----");
//           System.out.println("Nr " + licznik++);
//           System.out.println("Obreb: " + dzialka.getObreb());
//           System.out.println("Numer ewidencyjny: " + dzialka.getNumerEwidencyjny());;
//           System.out.println("rodzajDokumentyPotwierdzajacyWlasnosc: " + dzialka.getWlasnoscRodzajDokumentu());
//           System.out.println("numerDokumentuPotwierdzajacyWlasnosc: " + dzialka.getWlasnoscNumerDokumentu());
//           System.out.println("charakterWladania: " + dzialka.getCharakterWladania());
//           System.out.println("udzialy: " + dzialka.getUdzialy());
//           System.out.println("powierzchniaDzialki: " + dzialka.getPowierzchniaDzialki());
//           System.out.println("powierzchniaZabudowy: " + dzialka.getPowierzchniaZabudowy());
//           System.out.println("przeznaczenie: " + dzialka.getPrzeznaczenie());
//           System.out.println("aktualneWykorzystanie: " + dzialka.getAktualneWykorzystanie());
//           System.out.println("oszacowanaWartoscNieruchomosci: " + dzialka.getOszacowanaWartosc());
//           System.out.println("planWykorzystaniaLata: " + dzialka.getPlanWykorzystaniaLata());
//           System.out.println("uwagi: " + dzialka.getUwagi());
//           System.out.println("skladKomisji: " + dzialka.getSkladKomisji());
//           System.out.println("");
//           System.out.println("----");
//        }
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

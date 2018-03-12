package pl.ptaszek.config;

import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.springframework.util.StringUtils;

import pl.ptaszek.model.Dzialka;
import pl.ptaszek.model.Komunikat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Konwersja danych z Excell do kolekcji obiektow.
 * 
 * @author PPs
 *
 */
public class Konwersja {
	private static final String PATH = "C:\\ewidencjaDzialekWeb\\ewidencjaDzialekWeb\\src\\main\\java\\pl\\ptaszek\\config\\";

//	public static void main(String[] argc) {
//		wydrukujListaDzialek();
//	}
	
	
	public static List<Dzialka> stworzDzialkiZPliku() {
		List<Dzialka> dzialkaList = new ArrayList<>();
		StreamFactory factory = StreamFactory.newInstance();
		// load the mapping file
		factory.load(PATH + "konwersjaMapowanie.xml");
		// use a StreamFactory to create a BeanReader
		BeanReader in = factory.createReader("Dzialki", new File(PATH + "GMINNA EWIDENCJA_20.02.2018v2.csv"));
		// BeanReader in = factory.createReader("Dzialki", new File(PATH + "oneL.csv"));
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
		// plik do mapowania w obecnym katalogu: asiaMapowanie.xml
		// plik wynikowy z plikiem "csv" otwieralnym w excelu asiaWyniki.csv
		System.out.println("Gdzie jest plik ? Bierz sie do roboty leniu.");
		StreamFactory factory = StreamFactory.newInstance();
		factory.load(PATH + "asiaMapowanie.xml");
		Komunikat komunikat = new Komunikat();
		Komunikat komunikat2 = new Komunikat();
		komunikat.setKomunikat("Stan ewidencji mienia na dzień 2018-03-12");
		BeanWriter out = factory.createWriter("Dzialki", new File(PATH + "ewidencjaMienia.csv"));
		out.write("komunikat", komunikat);
		out.write("komunikat2", komunikat2);
		out.write("header", new Dzialka());
		for(Dzialka dzialka: dzialki) {
        	out.write(dzialka);
        }
        out.flush();
        out.close();
	}

}

package pl.ptaszek.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.ptaszek.config.Konwersja;
import pl.ptaszek.dao.DzialkaHistoryDaoImpl;
import pl.ptaszek.model.CalkowitaWartoscPrzeznaczenia;
import pl.ptaszek.model.Dzialka;
import pl.ptaszek.model.Komunikat;
import pl.ptaszek.service.DzialkaService;

@Controller
public class DzialkaWebController {
	
	Logger logger = Logger.getLogger(DzialkaWebController.class);
private  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private DzialkaService dzialkaService;

	@GetMapping("/wyszukajDzialka") 
	public ModelAndView wyszukajDzialka() {
		ModelAndView model = new ModelAndView();
		model.setViewName("wyszukajDzialke");
		return model;
	}
	
	@GetMapping("/podsumowanie")
	public ModelAndView podsumowanie() {
		ModelAndView model = new ModelAndView();
		Date now = new Date();
		List<CalkowitaWartoscPrzeznaczenia> przeznaczenieCalkowitaWartoscList = dzialkaService.createPodsumowanie(now);
		model.addObject("result", przeznaczenieCalkowitaWartoscList);
		CalkowitaWartoscPrzeznaczenia podsumowanie = new CalkowitaWartoscPrzeznaczenia();
		podsumowanie.setPrzeznaczenie("wszystkie");
		BigDecimal wszystkieWartosc = BigDecimal.ZERO;
		for (CalkowitaWartoscPrzeznaczenia element : przeznaczenieCalkowitaWartoscList) {
			wszystkieWartosc = wszystkieWartosc.add(new BigDecimal(element.getCalkowitaWartoscOszacowana()));
		}
		podsumowanie
				.setCalkowitaWartoscOszacowana(wszystkieWartosc.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
		model.addObject("stanNaDzien", simpleDateFormat.format(now));
		model.addObject("podsumowanie", podsumowanie);
		model.setViewName("podsumowanie");
		return model;
	}
	
	
	
	@GetMapping("/podsumowanieHistory")
	public ModelAndView podsumowanieHistory(@RequestParam("stanNaDzien") String stanNaDzien) {
		ModelAndView model = new ModelAndView();
		Date date = new Date();
		try {
			date = simpleDateFormat.parse(stanNaDzien);
		} catch (Exception exception) {
			logger.warn("Nieporawna data: " + stanNaDzien);
		}
		List<CalkowitaWartoscPrzeznaczenia> przeznaczenieCalkowitaWartoscList = dzialkaService.createPodsumowanie(date);
		model.addObject("result", przeznaczenieCalkowitaWartoscList);
		CalkowitaWartoscPrzeznaczenia podsumowanie = new CalkowitaWartoscPrzeznaczenia();
		podsumowanie.setPrzeznaczenie("wszystkie");
		BigDecimal wszystkieWartosc = BigDecimal.ZERO;
		for (CalkowitaWartoscPrzeznaczenia element : przeznaczenieCalkowitaWartoscList) {
			wszystkieWartosc = wszystkieWartosc.add(new BigDecimal(element.getCalkowitaWartoscOszacowana()));
		}
		podsumowanie.setCalkowitaWartoscOszacowana(wszystkieWartosc.toPlainString());
		model.addObject("stanNaDzien", stanNaDzien);
		model.addObject("podsumowanie", podsumowanie);
		model.setViewName("podsumowanie");
		return model;
	}
	
	@PostMapping("/filtrujListeDzialek") //
	public ModelAndView saveDetails(@RequestParam("stanNaDzien") String stanNaDzien,
			@RequestParam("numerEwidencyjnyDzialka") String numerEwidencyjnyDzialka,
			@RequestParam("obrebGeodezyjny") String obrebGeodezyjny,
			@RequestParam("rodzajDokumentuWlasnosci") String rodzajDokumentuWlasnosci,
			@RequestParam("numerDokumentuWlasnosci") String numerDokumentuWlasnosci,
			@RequestParam("charakterWladania") String charakterWladania, @RequestParam("udzialy") String udzialy,
			@RequestParam("powierzchniaDzialki") String powierzchniaDzialki,
			@RequestParam("powierzchniaZabudowy") String powierzchniaZabudowy,
			@RequestParam("oszacowanaWartosc") String oszacowanaWartosc,
			@RequestParam("przeznaczenie") String przeznaczenie,
			@RequestParam("aktualneWykorzystanie") String aktualneWykorzystanie,
			@RequestParam("planWykorzystania") String planWykorzystania, @RequestParam("uwagi") String uwagi,
			@RequestParam("skladKomisji") String skladKomisji, ModelMap modelMap) {
		ModelAndView model = new ModelAndView();
		Date stanNaDzienAsDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			stanNaDzienAsDate = simpleDateFormat.parse(stanNaDzien);
		} catch (ParseException e) {
			System.out.println("Data zostala wprowadzona niepoprawnie");
		}
		if (stanNaDzienAsDate != null) {
			model.addObject("dzialkaList",
					dzialkaService.findBy(numerEwidencyjnyDzialka, obrebGeodezyjny, rodzajDokumentuWlasnosci,
							numerDokumentuWlasnosci, charakterWladania, udzialy, powierzchniaDzialki,
							powierzchniaZabudowy, oszacowanaWartosc, przeznaczenie, aktualneWykorzystanie,
							planWykorzystania, uwagi, skladKomisji, stanNaDzienAsDate));
		} else {
			model.addObject("dzialkaList",
					dzialkaService.findBy(numerEwidencyjnyDzialka, obrebGeodezyjny, rodzajDokumentuWlasnosci,
							numerDokumentuWlasnosci, charakterWladania, udzialy, powierzchniaDzialki,
							powierzchniaZabudowy, oszacowanaWartosc, przeznaczenie, aktualneWykorzystanie,
							planWykorzystania, uwagi, skladKomisji));
		}
		if (stanNaDzienAsDate != null) {
			model.addObject("stanNaDzien", stanNaDzien);
			model.setViewName("listaDzialekFiltrData");
		} else {
			model.addObject("stanNaDzien", simpleDateFormat.format(new Date()));
			model.setViewName("listaDzialekFiltr");
		}
		return model;
	}
	
	@PostMapping("/zapiszDzialka") //
	public ModelAndView dodajDzialka(@RequestParam("numerEwidencyjnyDzialka") String numerEwidencyjnyDzialka,
			@RequestParam("obrebGeodezyjny") String obrebGeodezyjny,
			@RequestParam("rodzajDokumentuWlasnosci") String rodzajDokumentuWlasnosci,
			@RequestParam("numerDokumentuWlasnosci") String numerDokumentuWlasnosci,
			@RequestParam("charakterWladania") String charakterWladania,
			@RequestParam("udzialy") String udzialy,
			@RequestParam("powierzchniaDzialki") String powierzchniaDzialki,
			@RequestParam("powierzchniaZabudowy") String powierzchniaZabudowy,
			@RequestParam("oszacowanaWartosc") String oszacowanaWartosc,
			@RequestParam("przeznaczenie") String przeznaczenie,
			@RequestParam("aktualneWykorzystanie") String aktualneWykorzystanie,
			@RequestParam("planWykorzystania") String planWykorzystania,
			@RequestParam("uwagi") String uwagi,
			@RequestParam("skladKomisji") String skladKomisji, ModelMap modelMap) {
		Dzialka dzialka = new Dzialka();
		dzialka.setNumerEwidencyjny(numerEwidencyjnyDzialka);
		dzialka.setObreb(obrebGeodezyjny);
		dzialka.setWlasnoscRodzajDokumentu(rodzajDokumentuWlasnosci);
		dzialka.setWlasnoscNumerDokumentu(numerDokumentuWlasnosci);
		dzialka.setCharakterWladania(charakterWladania);
		if (udzialy != null && udzialy.isEmpty()) {
			dzialka.setUdzialy("1/1");
		}
		dzialka.setUdzialy(udzialy);
		dzialka.setPowierzchniaDzialki(powierzchniaDzialki);
		dzialka.setPowierzchniaZabudowy(powierzchniaZabudowy);
		dzialka.setOszacowanaWartosc(oszacowanaWartosc);
		dzialka.setPrzeznaczenie(przeznaczenie);
		dzialka.setAktualneWykorzystanie(aktualneWykorzystanie);
		dzialka.setPlanWykorzystaniaLata(planWykorzystania);
		dzialka.setUwagi(uwagi);
		dzialka.setSkladKomisji(skladKomisji);
		dzialkaService.save(dzialka);
		ModelAndView model = new ModelAndView();
		model.addObject("dzialka", dzialka);
		model.setViewName("wyswietlDzialke");
		return model;
	}
	
	@PostMapping("/uaktualnijDzialka") //
	public ModelAndView updateDzialka(@RequestParam("numerEwidencyjnyDzialka") String numerEwidencyjnyDzialka,
			@RequestParam("obrebGeodezyjny") String obrebGeodezyjny,
			@RequestParam("id") Long id,
			@RequestParam("rodzajDokumentuWlasnosci") String rodzajDokumentuWlasnosci,
			@RequestParam("numerDokumentuWlasnosci") String numerDokumentuWlasnosci,
			@RequestParam("charakterWladania") String charakterWladania,
			@RequestParam("udzialy") String udzialy,
			@RequestParam("powierzchniaDzialki") String powierzchniaDzialki,
			@RequestParam("powierzchniaZabudowy") String powierzchniaZabudowy,
			@RequestParam("oszacowanaWartosc") String oszacowanaWartosc,
			@RequestParam("przeznaczenie") String przeznaczenie,
			@RequestParam("aktualneWykorzystanie") String aktualneWykorzystanie,
			@RequestParam("planWykorzystania") String planWykorzystania,
			@RequestParam("uwagi") String uwagi,
			@RequestParam("skladKomisji") String skladKomisji, ModelMap modelMap) {
		Dzialka dzialka = dzialkaService.get(id);
		dzialka.setNumerEwidencyjny(numerEwidencyjnyDzialka);
		dzialka.setObreb(obrebGeodezyjny);
		dzialka.setWlasnoscRodzajDokumentu(rodzajDokumentuWlasnosci);
		dzialka.setWlasnoscNumerDokumentu(numerDokumentuWlasnosci);
		dzialka.setCharakterWladania(charakterWladania);
		if (udzialy != null && udzialy.isEmpty()) {
			dzialka.setUdzialy("1/1");
		}
		dzialka.setUdzialy(udzialy);
		dzialka.setPowierzchniaDzialki(powierzchniaDzialki);
		dzialka.setPowierzchniaZabudowy(powierzchniaZabudowy);
		dzialka.setOszacowanaWartosc(oszacowanaWartosc);
		dzialka.setPrzeznaczenie(przeznaczenie);
		dzialka.setAktualneWykorzystanie(aktualneWykorzystanie);
		dzialka.setUwagi(uwagi);
		dzialka.setPlanWykorzystaniaLata(planWykorzystania);
		dzialka.setSkladKomisji(skladKomisji);
		dzialkaService.update(dzialka);
		ModelAndView model = new ModelAndView();
		model.addObject("dzialka", dzialka);
		model.setViewName("wyswietlDzialke");
		return model;
	}

	@RequestMapping(value = "/listaDzialek", method = RequestMethod.GET)
	public ModelAndView displayEwidencjaDzialek() {
		ModelAndView model = new ModelAndView();
		List<Dzialka> result = dzialkaService.list();
		model.addObject("dzialkaList", result);
		model.addObject("filtrowanie", true);
		model.addObject("stanNaDzien", simpleDateFormat.format(new Date()));
		model.setViewName("listaDzialek");
		return model;
	}
	
	@RequestMapping(value = "/raportEwidencja", method = RequestMethod.GET)
	public ResponseEntity<byte[]> generujPlikEwidencjiCSV() throws Exception {
		// byte[] output = regData.getBytes();
		HttpHeaders responseHeaders = new HttpHeaders();
		List<Dzialka> dzialkaList = dzialkaService.list();
		StreamFactory factory = StreamFactory.newInstance();
		factory.load(this.getClass().getClassLoader().getResourceAsStream("ewidencjaDzialekMapowanie.xml"));
		Komunikat komunikat = new Komunikat();
		komunikat.setKomunikat("Stan ewidencji mienia na dzień: " + simpleDateFormat.format(new Date()));
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new ByteArrayOutputStream());
		BeanWriter out = factory.createWriter("Dzialki", outputStreamWriter);
		out.write("komunikat", komunikat);
		out.write("header", new Dzialka());
		for (Dzialka dzialka : dzialkaList) {
			out.write(dzialka);
		}
		out.flush();
		out.close();
		
		responseHeaders.set("charset", "utf-8");
		responseHeaders.setContentType(MediaType.valueOf("text/html"));
		byte[] outputStream = outputStreamWriter.toString().getBytes();
		responseHeaders.setContentLength(outputStream.length);
		responseHeaders.set("Content-disposition", "attachment; filename=ewidencjaMienia.csv");
		return new ResponseEntity<byte[]>(outputStream, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView loginCheck() {
		ModelAndView model = new ModelAndView();
		List<Dzialka> result = dzialkaService.list();
		model.addObject("dzialkaList", result);
		model.setViewName("listaDzialek");
		return model;
	}
		
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("witaj");
		return model;
	}
	
	@RequestMapping(value = "/dodajDzialka", method = RequestMethod.GET)
	public ModelAndView dodajDzialka() {
		ModelAndView model = new ModelAndView();
		model.setViewName("dodajDzialke");
		return model;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView startowaStrona() {
		ModelAndView model = new ModelAndView();
		List<Dzialka> result = dzialkaService.list();
		model.addObject("dzialkaList", result);
		model.addObject("stanNaDzien", simpleDateFormat.format(new Date()));
		model.setViewName("listaDzialek");
		return model;
	}
	
	@RequestMapping(value = "/zaloguj", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("logowanie");
		return model;
	}
	
	@RequestMapping(value = "/podgladDzialka", method = RequestMethod.POST)
	public ModelAndView podgladDzialka(@RequestParam("dzialkaId") Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("wyswietlDzialke");
		Dzialka dzialka = dzialkaService.get(id);
		model.addObject("dzialka", dzialka);
		model.addObject("stanNa", simpleDateFormat.format(dzialka.getOperationDate()));
		return model;
	}
	
	@RequestMapping(value = "/edycjaDzialka", method = RequestMethod.POST)
	public ModelAndView edycjaDzialka(@RequestParam("dzialkaId") Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("edycjaDzialki");
		model.addObject("dzialka", dzialkaService.get(id));
		return model;
	}
	
	@RequestMapping(value = "/konwersja", method = RequestMethod.GET)
	public ModelAndView konwersja() {
		List<Dzialka> result = Konwersja.stworzDzialkiZPliku();
		dzialkaService.saveAll(result);
		ModelAndView model = new ModelAndView();
		model.setViewName("witaj");
		return model;
	}
	
	//@RequestMapping(value = "/kopiuj", method = RequestMethod.GET)
	public ModelAndView kopiuj() {
		List<Dzialka> result = dzialkaService.list();
		dzialkaService.copyAll(result);
		ModelAndView model = new ModelAndView();
		model.setViewName("witaj");
		return model;
	}
	
	

}



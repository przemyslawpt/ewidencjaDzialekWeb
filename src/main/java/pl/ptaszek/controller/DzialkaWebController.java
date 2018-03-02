package pl.ptaszek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.ptaszek.config.Konwersja;
import pl.ptaszek.model.Dzialka;
import pl.ptaszek.service.DzialkaService;

@Controller
public class DzialkaWebController {

	@Autowired
	private DzialkaService dzialkaService;

	@GetMapping("dodajDzialke")
	public String getnowaDzialkaform() {
		return "nowaDzialka";
	}

	@GetMapping("wyszukaj")
	public String getwyszukajDzialkaform() {
		return "wyszukajDzialka";
	}

	@PostMapping("/wyszukajDzialka") //
	public ModelAndView saveDetails(@RequestParam("numerEwidencyjnyDzialka") String numerEwidencyjnyDzialka,
			@RequestParam("obrebDzialka") String obrebDzialka, ModelMap modelMap) {
		ModelAndView model = new ModelAndView();
		model.addObject("dzialkaList", dzialkaService.findBy(numerEwidencyjnyDzialka, obrebDzialka));
		model.setViewName("dzialkiLista");
		return model;
	}

	@PostMapping("/zapiszDzialka") //
	public ModelAndView saveDetails(@RequestParam("numerEwidencyjnyDzialka") String numerEwidencyjnyDzialka,
			@RequestParam("obrebDzialka") String obrebDzialka,
			@RequestParam("charakterWladaniaDzialka") String charakterWladaniaDzialka,
			@RequestParam("udzialyDzialka") String udzialyDzialka,
			@RequestParam("powierzchniaDzialka") String powierzchniaDzialka, ModelMap modelMap) {
		Dzialka dzialka = new Dzialka();
		dzialka.setCharakterWladania(charakterWladaniaDzialka);
		dzialka.setObreb(obrebDzialka);
		dzialka.setUdzialy(udzialyDzialka);
		dzialka.setNumerEwidencyjny(numerEwidencyjnyDzialka);
		//dzialka.setPowierzchnia(powierzchniaDzialka);
		dzialkaService.save(dzialka);
		ModelAndView model = new ModelAndView();
		model.addObject("dzialka", dzialka);
		model.setViewName("wyswietlDzialka");
		return model;
	}

	@RequestMapping(value = "/listaDzialek", method = RequestMethod.GET)
	public ModelAndView userDetails() {
		ModelAndView model = new ModelAndView();
        Integer licznik = 0;
		List<Dzialka> result = dzialkaService.list();
		for (Dzialka dzialka : result) {
			System.out.println("----");
			System.out.println("Nr " + licznik++);
			System.out.println("Obreb: " + dzialka.getObreb());
			System.out.println("Numer ewidencyjny: " + dzialka.getNumerEwidencyjny());
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
	
	@RequestMapping(value = "/konwersja", method = RequestMethod.GET)
	public ModelAndView konwersja() {
		List<Dzialka> result = Konwersja.stworzDzialkiZPliku();
		dzialkaService.saveAll(result);
		ModelAndView model = new ModelAndView();
		model.setViewName("witaj");
		return model;
	}

}

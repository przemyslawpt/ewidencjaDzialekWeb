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
	public ModelAndView displayEwidencjaDzialek() {
		ModelAndView model = new ModelAndView();
		Integer licznik = 0;
		List<Dzialka> result = dzialkaService.list();
		model.addObject("dzialkaList", result);
		model.setViewName("listaDzialek");
		return model;
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView loginCheck() {
		ModelAndView model = new ModelAndView();
		Integer licznik = 0;
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

}

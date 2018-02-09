package pl.ptaszek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		dzialka.setPowierzchnia(powierzchniaDzialka);
		dzialkaService.save(dzialka);
		ModelAndView model = new ModelAndView();
		model.addObject("dzialka", dzialka);
		model.setViewName("wyswietlDzialka");
		return model;
	}

	@RequestMapping(value = "/listaDzialki", method = RequestMethod.GET)
	public ModelAndView userDetails() {
		ModelAndView model = new ModelAndView();
		model.addObject("dzialkaList", dzialkaService.list());
		model.setViewName("dzialkiLista");
		return model;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView();
		model.setViewName("witaj");
		return model;
	}

}

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
	public String getForm() {
		return "nowaDzialka";
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

}
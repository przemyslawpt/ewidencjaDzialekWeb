package pl.ptaszek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pl.ptaszek.service.AdresService;

@Controller
public class AdresWebController {

	@Autowired
	private AdresService adresService;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("witaj");
    	return model;
    }
	
	@RequestMapping(value = "/listWeb", method = RequestMethod.GET)
	public ModelAndView userDetails() {
		ModelAndView model = new ModelAndView();
    	model.addObject("adresList", adresService.list());
    	model.setViewName("listaAdresow");
    	return model;
	}

}
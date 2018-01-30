package pl.ptaszek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.ptaszek.model.Adres;
import pl.ptaszek.service.AdresService;

@Controller
public class AdresController {

	@Autowired
	private AdresService adresService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity userDetails() {

		List<Adres> adresList = adresService.list();
		return new ResponseEntity(adresList, HttpStatus.OK);
	}

}
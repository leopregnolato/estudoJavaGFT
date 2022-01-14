package com.gft.treinamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gft.treinamento.services.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	

	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView getPerson() {
		
		PersonService personService = new PersonService();
		ModelAndView mv = new ModelAndView("person.html");
		mv.addObject("person", personService.createPerson());
		
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/cadastrar")
	public ModelAndView formPerson() {
		ModelAndView mv = new ModelAndView("formperson.html");
		return mv;
	}

}

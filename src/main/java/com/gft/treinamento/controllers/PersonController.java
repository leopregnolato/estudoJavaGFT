package com.gft.treinamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.treinamento.entities.Person;
import com.gft.treinamento.repositories.PersonRepository;
import com.gft.treinamento.services.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView getPerson(@RequestParam Long id) {		
		ModelAndView mv = new ModelAndView("person.html");
		try {
			Person person = personService.getPerson(id);
			mv.addObject("person", person);	
		} catch (Exception e) {
			mv.addObject("message", e.getMessage()); 
		}
			
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/new")
	public ModelAndView formPerson() {
		ModelAndView mv = new ModelAndView("formperson.html");
		mv.addObject("person", new Person());
		return mv;
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView newPerson(Person person) {		
		ModelAndView mv = new ModelAndView("person.html");
		person = personService.savePerson(person);
		mv.addObject("person", person);		
		return mv;
	}

}

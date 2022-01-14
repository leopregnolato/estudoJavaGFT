package com.gft.treinamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gft.treinamento.services.PersonService;

@Controller
public class TreinamentoController {
	
	@RequestMapping(method= RequestMethod.GET, path= "/index")
	public ModelAndView index(@RequestParam(name = "name") String firstName, @RequestParam Integer age) {
		
		//System.out.println("Seja bem vind@: " + firstName + ", de " + age + " anos!");
		//http://localhost:8080/index?name=Leo&age=30
		
		ModelAndView mv = new ModelAndView("index.html");//para que o html renderize os recursos do thymeleaf
		mv.addObject("name", firstName); //para que o thymeleaf renderize em th:text="${name}"
		System.out.println("Olá cheguei aqui no index!");
		
		return mv;		
	}
	
	@RequestMapping(method= RequestMethod.GET, path= "/about")
	public ModelAndView about() {	
		
		System.out.println("Estou no about :)");
		
		return new ModelAndView("about.html");		
	}
}

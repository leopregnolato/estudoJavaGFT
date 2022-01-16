package com.gft.treinamento.services;

import org.springframework.stereotype.Service;

import com.gft.treinamento.entities.Person;

@Service
public class PersonService {
	
	public Person createPerson() {
		
		Person person = new Person();
		person.setName("João");
		person.setAge(32);
		person.setStatus(Boolean.TRUE);
		
		/* String status;
		
		if(person.getStatus()) {
			status = "Ativo";
		}else {
			status = "Inativo";
		}
		
		String status = person.getStatus() ? "Ativo" : "Inativo";
		*/
		
		return person;
		
	}

}

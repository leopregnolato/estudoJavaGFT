package com.gft.treinamento.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.treinamento.entities.Person;
import com.gft.treinamento.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
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
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPerson(Long id) throws Exception{
		Optional<Person> person = personRepository.findById(id);
		
		if(person.isEmpty()) {
			throw new Exception("Pessoa não encontrada!");
		}
		
		return person.get();
	}

}

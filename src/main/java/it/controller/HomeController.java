package it.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.dao.PersonaDao;
import it.dto.PersonaDto;
import it.model.Persona;

@RequestMapping("/home")
@Controller
public class HomeController {
	@Autowired
	private PersonaDao personaDao;
	private Logger logger = Logger.getLogger(HomeController.class);

	public PersonaDao getPersonaDao() {
		return personaDao;
	}
	public void setPersonaDao(PersonaDao personaDao) {
		this.personaDao = personaDao;
	}
	@RequestMapping(method = RequestMethod.GET)
	public String showHome() {
		logger.info("Starting/Ending controller method showHome");
		return ("/views/home.html");
	}
	
	@Transactional
	@RequestMapping(value = "/getPersonByName", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody PersonaDto getGamesByTitleAndConsole(@RequestParam(value = "nome") String nome) {
		logger.info("Starting service getPersonByName");
		PersonaDto response = new PersonaDto();
		Persona persona;
		if (!nome.equals("") && !nome.isEmpty()){
//			risultato della query a db, metodo corretto
//			persona = getPersonaDao().getPersonByName(nome);
//			risultato "statico", hardcoded, metodo temporaneo visto che non c'è un db collegato
			persona = new Persona();
			persona.setEta(23);
			persona.setNome("Fausto");
			
			response.setNome(persona.getNome());
			response.setEta(persona.getEta());
		}
		logger.info("Ending service getPersonByName");
		return response;
	}
}
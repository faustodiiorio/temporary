package it.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import it.dao.PersonaDao;
import it.model.Persona;

@Component
public class PersonaDaoImpl implements PersonaDao{
	@PersistenceContext(unitName="persistenceUnitDS")
	EntityManager entityManager;
	
	@Override
	public Persona getPersonByName(String nome) {
		return (Persona)entityManager.createNamedQuery("getPersonByName").getSingleResult();
	}
}

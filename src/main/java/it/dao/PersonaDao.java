package it.dao;

import it.model.Persona;

public interface PersonaDao {
	Persona getPersonByName(String nome);
}

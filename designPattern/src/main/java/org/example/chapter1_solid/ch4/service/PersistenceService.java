package org.example.chapter1_solid.ch4.service;

import org.example.chapter1_solid.ch4.entity.Entity;

//common interface to be implemented by all persistence services.
public interface PersistenceService<T extends Entity> {

	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
	
}

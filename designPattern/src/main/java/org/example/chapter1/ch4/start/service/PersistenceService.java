package org.example.chapter1.ch4.start.service;

import org.example.chapter1.ch4.start.entity.Entity;

import java.util.List;


//common interface to be implemented by all persistence services. 
public interface PersistenceService<T extends Entity> {

	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
	
	public List<T> findByName(String name);
}

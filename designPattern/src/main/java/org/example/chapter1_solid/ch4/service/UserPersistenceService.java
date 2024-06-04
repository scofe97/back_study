package org.example.chapter1_solid.ch4.service;

import org.example.chapter1_solid.ch4.entity.User;

import java.util.HashMap;
import java.util.Map;

//Stores User entities
public class UserPersistenceService implements PersistenceService<User>{
	
	private static final Map<Long, User> USERS = new HashMap<>();
	
	@Override
	public void save(User entity) {
		synchronized (USERS) {
			USERS.put(entity.getId(), entity);
		}
	}

	@Override
	public void delete(User entity) {
		synchronized (USERS) {
			USERS.remove(entity.getId());
		}
	}

	@Override
	public User findById(Long id) {
		synchronized (USERS) {
			return USERS.get(id);
		}
	}
}

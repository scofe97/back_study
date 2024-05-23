package org.example.chapter1.ch1;

public class UserPersistenceService {

    private Store store = new Store();
    public void saveUser(User user) {
        store.store(user);
    }
	
}

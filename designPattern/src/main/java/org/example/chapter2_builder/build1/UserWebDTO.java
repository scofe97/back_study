package org.example.chapter2_builder.build1;

import lombok.Getter;

//A product in builder pattern
@Getter
public class UserWebDTO implements UserDTO {

	private String name;
	
	private String address;
	
	private String age;

	public UserWebDTO(String name, String address, String age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + "\nage=" + age + "\naddress=" + address ;
	}
}

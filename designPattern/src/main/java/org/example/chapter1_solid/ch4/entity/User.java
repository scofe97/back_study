package org.example.chapter1_solid.ch4.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class User extends Entity{
	
	private String name;
	
	private LocalDateTime lastLogin;
}

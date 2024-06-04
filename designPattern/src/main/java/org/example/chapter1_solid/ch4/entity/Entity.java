package org.example.chapter1_solid.ch4.entity;

import lombok.Getter;
import lombok.Setter;

//Base class for all entities
@Getter @Setter
public abstract class Entity {
	
	private Long id;
}

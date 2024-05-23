package org.example.chapter1.ch3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle implements Shape {

	private int width;
	
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int computeArea() {
		return width * height;
	}
}

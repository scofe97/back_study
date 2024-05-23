package org.example.chapter1.ch3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Square implements Shape {

	private int side;

	public Square(int side) {
		this.side = side;
	}

	@Override
	public int computeArea() {
		return side * side;
	}
}

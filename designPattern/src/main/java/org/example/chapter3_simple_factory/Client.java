package org.example.chapter3_simple_factory;

public class Client {

	public static void main(String[] args) {
		Post post = PostFactory.createPost("blog");
		System.out.println("post = " + post);

	}

}

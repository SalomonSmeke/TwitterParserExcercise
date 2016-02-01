package io.salomon.tweet;

import java.util.HashMap;

public class Types {
	private final static String[][] types = new String[][]{
		{"@","mentions"},
		{"#","topics"},
		{"http://www.","link"},
		{"https://www.","link"},
		{"http://","link"},
		{"http://","link"},
		{"www.","link"},
		};
		
	public static String[][] getTypes(){
		return types;
	}
}

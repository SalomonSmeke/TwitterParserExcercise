package io.salomon.tweet;

public class Types {
	private final static String[][] types = new String[][]{
		{"@","mentions"},
		{"#","tags"},
		{"http://www.","link"},
		{"https://www.","link"},
		{"http://","link"},
		{"http://","link"},
		{"www.","link"}
		};
		
	public static String[][] getTypes(){
		return types;
	}
}

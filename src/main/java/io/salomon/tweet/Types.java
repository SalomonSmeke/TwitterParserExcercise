package io.salomon.tweet;

public class Types {
	private final static String[][] typesRules = new String[][]{
		{"@","mentions"},
		{"#","tags"},
		{"http://www.","link"},
		{"https://www.","link"},
		{"http://","link"},
		{"https://","link"},
		{"www.","link"},
		
		//Add more here!
		
		{"","words"}
		};
	
	private final static String[] types = new String[]{
			"mentions","tags","link","words"
	};
	
	public static String[] getTypes(){
		return types;
	}

	public static String[][] getTypesRules(){
		return typesRules;
	}
	
}

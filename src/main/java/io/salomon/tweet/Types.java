package io.salomon.tweet;

public class Types {
	
	//Add more types here. make sure to add its prefix to "typesPrefixes" in format {prefix,name} and its name to "types"
	private final static String[][] typesPrefixes = new String[][]{
		{"@","mentions"},
		{"#","tags"},
		{"http://www.","link"},
		{"https://www.","link"},
		{"http://","link"},
		{"https://","link"},
		{"www.","link"},
		{"&","grouping"},
		//Add more here!
		
		{"","words"}
		};
	
	private final static String[] types = new String[]{
			"mentions","tags","link","words","grouping"
	};
	
	public static String[] getTypes(){
		return types;
	}

	public static String[][] getTypesPrefixes(){
		return typesPrefixes;
	}
	
}

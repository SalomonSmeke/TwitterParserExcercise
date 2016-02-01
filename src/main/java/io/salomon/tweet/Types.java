package io.salomon.tweet;

import java.util.ArrayList;
import java.util.HashMap;

public class Types {
	private final static String[][] types = new String[][]{
		{"@","mentions"},
		{"#","tags"},
		{"http://www.","link"},
		{"https://www.","link"},
		{"http://","link"},
		{"https://","link"},
		{"www.","link"},
		{"","words"}
		};
		
	public static HashMap<String,String> getDictionary(){
		HashMap<String,String> dict = new HashMap<String,String>();
		for (int i = 0; i < types.length; i++)dict.put(types[i][0], types[i][1]);
		return dict;
	}
	
	public static ArrayList<String> getTypes(){
		ArrayList <String> out = new ArrayList<String>();
		
		for (int i = 0; i < types.length; i++){
			String temp = types[i][1];
			if (!out.contains(temp)){
				out.add(temp);
			}
		}
		
		return out;
	}
}

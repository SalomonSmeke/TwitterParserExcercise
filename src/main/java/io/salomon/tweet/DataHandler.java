package io.salomon.tweet;

import java.util.ArrayList;
import java.util.HashMap;

public class DataHandler extends Types{
	
	private HashMap dictionary = Types.getDictionary();
	private HashMap<String,StringIronBox> containers;
	private HashMap<String,Integer> counters = new HashMap<String,Integer>();
	private ArrayList<String> types = Types.getTypes();
	
	public DataHandler(String parse){
		createTypes();
		categorize(parse);
	}
	
	private void createTypes(){
		
	}
	
	private void categorize(String parse){
		
	}
}



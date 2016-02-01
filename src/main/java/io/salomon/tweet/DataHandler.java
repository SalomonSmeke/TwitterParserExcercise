package io.salomon.tweet;

import java.util.ArrayList;
import java.util.HashMap;

public class DataHandler extends Types{
	
	private ArrayList<String> properties;
	private String[][] types;
	private HashMap<String,StringIronBox> containers;
	
	public DataHandler(){
		types = Types.getTypes();
		properties = new ArrayList<String>();
		for (int i = 0; i < types.length; i++){
			String temp = types[i][1];
			if (!properties.contains(temp)){
				properties.add(temp);
			}
		}
		containers = new HashMap<String,StringIronBox>();
		for (int i = 0; i < properties.size(); i++){
			containers.put(properties.get(i), new StringIronBox());
		}
	}
	
}



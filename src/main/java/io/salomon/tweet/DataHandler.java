package io.salomon.tweet;

import java.util.HashMap;

public class DataHandler extends Types{
	
	private HashMap<String,StringIronBox> containers = new HashMap<String,StringIronBox>();
	private HashMap<String,Integer> counters = new HashMap<String,Integer>();
	private String[][] types = Types.getTypes();
	
	public DataHandler(String parse){
		createStructs();
		categorize(parse);
	}
	
	private void createStructs(){
		for (int i = 0; i < types.length; i++){
			String performanceTemp = types[i][1];
			counters.put(performanceTemp, 0);
			containers.put(performanceTemp, new StringIronBox());
		}
	}
	
	private void categorize(String parse){
		String[] tokens = parse.split(" ");
		for (int i = 0; i < tokens.length; i++){
			String token = tokens[i];
			for (int t = 0; t < types.length; t++){
				String[] performanceTemp = types[t];
				if (token.startsWith(performanceTemp[0])){
					token = token.replace(performanceTemp[0], "");
					containers.get(performanceTemp[1]).addString(token);
					counters.replace(performanceTemp[1], counters.get(performanceTemp[1])+1);
					break;
				}
			}
		}
	}


}



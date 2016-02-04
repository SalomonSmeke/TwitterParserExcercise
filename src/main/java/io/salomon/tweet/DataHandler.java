package io.salomon.tweet;

import java.util.HashMap;

public class DataHandler extends Types{
	
	private HashMap<String,StringIronBox> containers = new HashMap<String,StringIronBox>();
	private HashMap<String,Integer> counters = new HashMap<String,Integer>();
	private String[][] typesRules = Types.getTypesRules();
	private String[] types = Types.getTypes();
	
	public DataHandler(String parse){
		if (parse!=null){
		createStructs();
		categorize(parse);
		}
		else {
			System.out.println("WARN. Nothing parsed. Use DataHandler.reparse()");
		}
	}
	
	public void reparse(String parse){
		containers = new HashMap<String,StringIronBox>();
		counters = new HashMap<String,Integer>();
		if (parse!=null){
		createStructs();
		categorize(parse);
		}
		else {
			System.out.println("WARN. Nothing parsed. Use DataHandler.reparse()");
		}
	}
	
	private void createStructs(){
		for (int i = 0; i < typesRules.length; i++){
			String performanceTemp = typesRules[i][1];
			counters.put(performanceTemp, 0);
			containers.put(performanceTemp, new StringIronBox());
		}
	}
	
	private int categorize(String parse){
		int tokenAmount = 0;
		String[] tokens = parse.split(" ");
		for (int i = 0; i < tokens.length; i++){
			String token = tokens[i];
			for (int t = 0; t < typesRules.length; t++){
				String[] performanceTemp = typesRules[t];
				if (token.startsWith(performanceTemp[0])){
					token = token.replace(performanceTemp[0], "");
					containers.get(performanceTemp[1]).addString(token);
					counters.replace(performanceTemp[1], counters.get(performanceTemp[1])+1);
					tokenAmount++;
					break;
				}
			}
		}
		return tokenAmount;
	}

	public HashMap<String,StringIronBox> gContainers(){
		return containers;
	}
	
	public HashMap<String,Integer> gCounters(){
		return counters;
	}

	public String[] gTypes(){
		return types;
	}
}



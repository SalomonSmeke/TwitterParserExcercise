package io.salomon.tweet;

import java.util.HashMap;

public class DataHandler extends Types{
	
	private HashMap<String,StringIronBox> containers = new HashMap<String,StringIronBox>();
	private HashMap<String,Integer> counters = new HashMap<String,Integer>();
	private String[][] typesPrefixes = Types.getTypesPrefixes();
	private String[] types = Types.getTypes();
	private Rule[] rules = new Rules().getRules();
	
	public DataHandler(String parse){
		if (parse!=null){
		createStructs();
		parser(parse);
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
		parser(parse);
		}
		else {
			System.out.println("WARN. Nothing parsed. Use DataHandler.reparse()");
		}
	}
	
	private void createStructs(){
		for (int i = 0; i < typesPrefixes.length; i++){
			String performanceTemp = typesPrefixes[i][1];
			counters.put(performanceTemp, 0);
			containers.put(performanceTemp, new StringIronBox());
		}
	}
	
	private int parser(String parse){
		int itemAmount = 0;
		
		String[] items = parse.split(" ");
		
		for (int i = 0; i < items.length; i++){
			categorize(items[i]);
		}
		
		return itemAmount;
	}

	private void categorize(String string) {
		
		String type = "";
		
		for (int i = 0; i < typesPrefixes.length; i++){
			String[] performanceTemp = typesPrefixes[i];
			if (string.startsWith(performanceTemp[0])){
				type = performanceTemp[1];
				string = string.substring(performanceTemp[0].length());
				break;
			}
		}
		
		String[] rulesResult = new String[]{string,null};
		
		for (int i = 0; i < rules.length; i++){
			Rule performanceTemp = rules[i];
			if (performanceTemp.getType()==type && performanceTemp.getApplicability(string)==type){
				rulesResult = performanceTemp.process(string);
				break;
			}
		}
		
		if (rulesResult[1]!=null){
			System.out.println(rulesResult[1]);
		}
		if (rulesResult[0]!=null){
			System.out.println(rulesResult[0]);

		}
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



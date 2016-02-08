package io.salomon.tweet;

import java.util.HashMap;

public class DataHandler extends Types{
	
	private HashMap<String,StringIronBox> containers = new HashMap<String,StringIronBox>();
	private HashMap<String,Integer> counters = new HashMap<String,Integer>();
	private String[][] typesPrefixes = Types.getTypesPrefixes();
	private String[] types = Types.getTypes();
	private Rule[] rules = new Rules().getRules();
	
	//Initialize a datahandler takes a string.
	public DataHandler(String parse){
		if (parse!=null){
		createStructs();
		parser(parse);
		}
		else {
			System.out.println("WARN. Nothing parsed. Use DataHandler.reparse()");
		}
	}
	
	//Reinitialize if necessary
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
	
	//Uses rules to create structures appropriate to contain tweet data types
	private void createStructs(){
		for (int i = 0; i < typesPrefixes.length; i++){
			String performanceTemp = typesPrefixes[i][1];
			counters.put(performanceTemp, 0);
			containers.put(performanceTemp, new StringIronBox());
		}
	}
	
	//Place each item into its box.
	private void parser(String parse){
		int itemAmount = 0;
		
		String[] items = parse.split(" ");
		
		for (int i = 0; i < items.length; i++){
			categorize(items[i]);
		}
	}

	//Place a single item into a box.
	private void categorize(String string) {
		
		String type = "";
		
		//Iterate over the possible types
		for (int i = 0; i < typesPrefixes.length; i++){
			String[] performanceTemp = typesPrefixes[i];
			//If found, assign to type.
			if (string.startsWith(performanceTemp[0])){
				type = performanceTemp[1];
				string = string.substring(performanceTemp[0].length());
				break;
			}
		}
		//In case no rules apply, process as is
		String[] rulesResult = new String[]{string,null};
		
		//Iterate over rules.
		for (int i = 0; i < rules.length; i++){
			Rule performanceTemp = rules[i];
			//If the rule applies, proccess it.
			if (performanceTemp.getType()==type && performanceTemp.getApplicability(string)==type){
				rulesResult = performanceTemp.process(string);
				break;
			}
		}
		
		//Place into text container the parts of the item so specified by rules
		if (rulesResult[1]!=null){
			containers.get("words").addString(rulesResult[1]);
			counters.put("words", counters.get("words")+1);
		}
		
		//Place into type container the parts of the item so specified by rules
		if (rulesResult[0]!=null){
			containers.get(type).addString(rulesResult[0]);
			counters.put(type, counters.get(type)+1);
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



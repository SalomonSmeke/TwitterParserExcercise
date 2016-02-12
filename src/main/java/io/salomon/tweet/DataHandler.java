package io.salomon.tweet;

import java.util.HashMap;

public class DataHandler extends Types{

	private HashMap<String,StringIronBox> containers = new HashMap<String,StringIronBox>();
	private HashMap<String,Integer> counters = new HashMap<String,Integer>();
	private String[][] typesPrefixes = Types.getTypesPrefixes();
	private String[] types = Types.getTypes();
	private Rule[] rules = new Rules().getRules();

	/**
	 * Creates a DataHandler object that can then be printed out. 
	 * The parse argument specifies a Tweet String that should be categorized.
	 * <p>
	 * This method throws a console warning if it was passed an empty argument
	 *
	 * @param  parse  a string to be parsed
	 * @return      void
	 * @see         Tweet
	 */
	public DataHandler(String parse){
		if (parse!=null){
			createStructs();
			parser(parse);
		}
		else {
			System.out.println("WARN. Nothing parsed. Use DataHandler.reparse()");
		}
	}

	/**
	 * Modifies a DataHandler object that was instantiated with no string.
	 * Alternatively it can be used to change the text in a Tweet.
	 * The parse argument specifies a Tweet String that should be categorized. 
	 * <p>
	 * This method throws a console warning if it was passed an empty argument
	 *
	 * @param  parse  a string to be reparsed
	 * @return      void
	 * @see         Tweet
	 */
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

	/**
	 * Utilizes the Types file to create structures for a Tweet based
	 * on user specification.
	 * <p>
	 *
	 * @return      void
	 * @see         Tweet
	 * @see			StringIronBox
	 * @see			Types
	 */
	private void createStructs(){
		for (int i = 0; i < typesPrefixes.length; i++){
			String performanceTemp = typesPrefixes[i][1];
			counters.put(performanceTemp, 0);
			containers.put(performanceTemp, new StringIronBox());
		}
	}

	/**
	 * A method created to simplify the categorization of Tweets. 
	 * It splits up a string parameter parse into items by splitting at space
	 * The parse argument specifies a Tweet String that should be split and
	 * categorized. 
	 * <p>
	 * This method throws a console warning if it was passed an empty argument
	 *
	 * @param  parse  a string to be categorized and split
	 * @return      void
	 * @see         Tweet
	 */
	private void parser(String parse){
		String[] items = parse.split(" ");

		for (int i = 0; i < items.length; i++){
			categorize(items[i]);
		}
	}

	/**
	 * Places items (Tweet portions) into containers appropriate for them.
	 * The in argument is a single item that must be placed in a category set by
	 * Type  
	 * <p>
	 *
	 * @param  in 	A string to be categorized
	 * @return      void
	 * @see         Tweet
	 * @see			parser
	 * @see			createStructs
	 */
	private void categorize(String in) {

		String type = "";

		//Iterate over the possible types
		for (int i = 0; i < typesPrefixes.length; i++){
			String[] performanceTemp = typesPrefixes[i];
			//If found, assign to type.
			if (in.startsWith(performanceTemp[0])){
				type = performanceTemp[1];
				in = in.substring(performanceTemp[0].length());
				break;
			}
		}
		//In case no rules apply, process as is
		String[] rulesResult = new String[]{in,null};

		//Iterate over rules.
		for (int i = 0; i < rules.length; i++){
			Rule performanceTemp = rules[i];
			//If the rule applies, proccess it.
			if (performanceTemp.getType()==type && performanceTemp.getApplicability(in)==type){
				rulesResult = performanceTemp.process(in);
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

	/**
	 * Returns containers of Tweet portions as specified by Types and
	 * parsed by parse
	 * <p>
	 * @return      HashMap<String,StringIronBox>
	 * @see         Tweet
	 * @see			StringIronBox
	 * @see 		parse
	 * @see			Types
	 */
	public HashMap<String,StringIronBox> gContainers(){
		return containers;
	}

	/**
	 * Returns counters of Tweet portions as specified by Types and
	 * parsed by parse
	 * <p>
	 * @return      HashMap<String,StringInteger>
	 * @see         Tweet
	 * @see			StringIronBox
	 * @see 		parse
	 * @see			Types
	 */
	public HashMap<String,Integer> gCounters(){
		return counters;
	}

	/**
	 * Returns user specified types of Tweet portions as specified by Types
	 * <p>
	 * @return      String[]
	 * @see         Tweet
	 * @see			StringIronBox
	 * @see 		parse
	 * @see			Types
	 */
	public String[] gTypes(){
		return types;
	}
}



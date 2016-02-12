package io.salomon.tweet;

import java.util.HashMap;

public class Tweet {

	DataHandler handler;

	/**
	 * Initializer. Creates a Tweet and passes the tweet in to be parsed
	 * There is some null handling
	 * 
	 * @param init	String to be parsed in
	 */

	public Tweet(String init) {
		handler = new DataHandler(init);

		if (init != null){ parseIn(init);

		} else { System.out.println("WARN, did not parse null value"); }
	}

	/**
	 * Parses a string. Checks for nulls and returns a boolean accordingly
	 * 
	 * 
	 * @param in	String to be parsed
	 * @return boolean 
	 */

	private boolean parseIn(String in){
		if (in == null){
			System.out.println("Cannot parse null tweets");
			return false;
		}

		handler.reparse(in);

		return true;
	}

	/**
	 * Converts a Tweet into a string, overriden from object
	 * 
	 * @return String 
	 */

	@Override
	public String toString(){

		//Get data structures from handler
		HashMap<String,StringIronBox> containers = handler.gContainers();
		HashMap<String,Integer> counters = handler.gCounters();

		String [] types = handler.gTypes();

		String out = "Tweet composition is as follows:\n";

		//Iterate over each type
		for (int i = 0; i < types.length; i++){

			//Grab the box for each type
			StringIronBox temp = containers.get(types[i]);

			String append = "\t" + types[i] + "[" + counters.get(types[i]) + "] : \t";

			//Iterate over each element in the box
			for (int y = 0; y < temp.size(); y++){
				append = append + temp.getAt(y) + ", ";
			}

			out = out + append.substring(0,append.length()-2) + "\n";
		}
		return out;
	}

	//Alternative printing mechanism
	public void print(){ System.out.println(this.toString()); }

	/**
	 * Prints how rules work. just for niceness.
	 */
	public void meta(){

		System.out.println("To add more rules that apply to a type of string (like a tag) go to \"rules\" file. \n To add new types. Go in the \"Types\" file. Results wil update accordingly.");

	}
}

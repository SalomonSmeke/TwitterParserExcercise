package io.salomon.tweet;

import java.util.HashMap;

//TODO Create tweet
public class Tweet {
	
	DataHandler handler;
	
	//Instantiation of a Tweet object. Takes in a string. Will not parse nulls.
	public Tweet(String init) {
		if (init != null){
			parseIn(init);
		} else{
			System.out.println("WARN, did not parse null value");
		}
	}
	
	//ReParsing in case of tweet replacement
	private boolean parseIn(String in){
		if (in == null){
			System.out.println("Cannot parse null tweets");
			return false;
		}
		handler.reparse(in);
		return true;
	}

	//Obtain the archived data from string iron boxes.
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
	public void print(){
		System.out.println(this.toString());
	}
	
	//Information on changing rules
	public void meta(){
		System.out.println("To add more rules that apply to a type of string (like a tag) go to \"rules\" file. \n To add new types. Go in the \"Types\" file. Results wil update accordingly.");
	}
}

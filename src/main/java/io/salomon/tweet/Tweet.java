package io.salomon.tweet;

import java.util.HashMap;

//TODO Create tweet
public class Tweet {
	DataHandler handler;
	public Tweet(String init) {
		if (init != null){
			parseIn(init);
		} else{
			System.out.println("WARN, did not parse null value");
		}
	}
	
	private boolean parseIn(String in){
		if (in.length()==0){
			System.out.println("Cannot parse empty tweets");
			return false;
		}
		handler = new DataHandler(in);
		return true;
	}
	
	@Override
	public String toString(){
		HashMap<String,StringIronBox> containers = handler.gContainers();
		HashMap<String,Integer> counters = handler.gCounters();
		String [] types = handler.gTypes();
		
		String out = "Tweet composition is as follows:\n";
		
		for (int i = 0; i < types.length; i++){
			StringIronBox temp = containers.get(types[i]);
			String append = "\t" + types[i] + "[" + counters.get(types[i]) + "] : \t";
			for (int y = 0; y < temp.size(); y++){
				append = append + temp.getAt(y) + ", ";
			}
			out = out + append.substring(0,append.length()-2) + "\n";
		}
		return out;
	}
	
	public void print(){
		System.out.println(this.toString());
	}
	
}

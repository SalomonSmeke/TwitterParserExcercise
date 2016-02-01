package io.salomon.tweet;

//TODO Create tweet
public class Tweet {
	
	public Tweet(String init) {
		parseIn(init);
	}
	
	private boolean parseIn(String in){
		if (in.length()==0){
			System.out.println("Cannot parse empty tweets");
			return false;
		}
		DataHandler handler = new DataHandler(in);
		return true;
	}
	
	
}

package io.salomon.tweet;

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
	
	
	
}

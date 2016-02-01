package io.salomon.tweet;

//TODO Create tweet
public class Tweet {
	
	private String[] splitContents;
	
	public Tweet(String init) {
		if (!parse(init)){
			System.out.println("Error parsing tweet");
		}
	}
	
	private boolean parse(String in){
		return true;
	}
	
	
}

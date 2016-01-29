package io.salomon.tweet;

import java.util.ArrayList;

/*
 * This class defines how things are stored. 
 * If mentions should be a class, or comma separated strings. Its all here.
 */
public class dataContainer{
	
	
	protected final class mentions {
		protected mentions(){
			ArrayList<unmutableItem> list = new ArrayList<unmutableItem>();
		}
	}
	
	protected final class topics {
		protected topics(){
			ArrayList<unmutableItem> list = new ArrayList<unmutableItem>();
		}
	}
	
	private final class unmutableItem {
		private final String item;
		
		private unmutableItem (String text){
			item = text;
		}
	}
	
	
}



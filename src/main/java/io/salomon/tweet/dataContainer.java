package io.salomon.tweet;

import java.util.ArrayList;

import org.omg.CORBA.portable.UnknownException;

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
	//TODO Oh! These two are equal... time to make a class for string storage.
	protected final class topics {
		ArrayList<unmutableItem> list;
		protected topics(){
			list = new ArrayList<unmutableItem>();
		}
		protected boolean addTopic(String text){
			try{
				list.add(new unmutableItem(text));
			}catch(UnknownException e){
				System.out.println(e);
				return false;
			}
			return true;
		}
	}
	
	private final class unmutableItem {
		private final String item;
		
		private unmutableItem (String text){item = text;}
		@Override
		public String toString(){return item;}
	}
}



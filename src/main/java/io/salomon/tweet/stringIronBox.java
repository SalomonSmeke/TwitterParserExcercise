package io.salomon.tweet;

import java.util.ArrayList;

import org.omg.CORBA.portable.UnknownException;

public final class stringIronBox {

	private ArrayList<unmutableItem> list;
	
	//TODO make it so you can initialize ironbox with a string or collection of strings.
	public stringIronBox(){
		list = new ArrayList<unmutableItem>();
	}
	
	public boolean addString(String text){
		try{
			list.add(new unmutableItem(text));
		}catch(UnknownException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public boolean removeString(String text){
		try{
			if(list.contains(new unmutableItem(text))){
				list.remove(new unmutableItem(text));
			} else{
				return false;
			}
		}catch(UnknownException e){
			System.out.println(e);
			return false;
		}
		return true;
	}

	private final class unmutableItem {
		private final String item;

		private unmutableItem (String text){item = text;}
		@Override
		public String toString(){return item;}
		
		@Override
		public boolean equals(Object in){
			if (in.toString() == this.item) return true;
			else return false;
		}
	}

}

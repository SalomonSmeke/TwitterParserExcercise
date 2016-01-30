package io.salomon.tweet;

import java.util.ArrayList;

import org.omg.CORBA.portable.UnknownException;

public final class stringIronBox {

	private ArrayList<immutableItem> list;
	
	//TODO make it so you can initialize iron-box with a string or collection of strings.
	public stringIronBox(){
		list = new ArrayList<immutableItem>();
	}
	
	public boolean addString(String text){
		try{
			list.add(new immutableItem(text));
		}catch(UnknownException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public boolean removeString(String text){
		try{
			if(list.contains(new immutableItem(text)))
				list.remove(new immutableItem(text));
			 else return false;
		}catch(UnknownException e){
			System.out.println(e);
			return false;
		}
		return true;
	}

	private class immutableItem {
		private final String item;
		private immutableItem (String text){item = text;}
		@Override
		public String toString(){return item;}
		@Override
		public boolean equals(Object in){
			if (in.toString() == this.item) return true;
			else return false;
		}
	}

}

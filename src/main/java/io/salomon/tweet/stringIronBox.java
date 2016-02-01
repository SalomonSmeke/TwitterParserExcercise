package io.salomon.tweet;

import java.util.ArrayList;

import org.omg.CORBA.portable.UnknownException;

public final class StringIronBox {

	private ArrayList<immutableItem> list;
	
	//TODO make it so you can initialize iron-box with a string or collection of strings.
	public StringIronBox(){
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
	
	public boolean contains(String text){
		if(list.contains(new immutableItem(text))){
			return true;
		} else {
			return false;
		}
	}
	
	public String getAt(int index){
		if (index>list.size()-1) throw new IndexOutOfBoundsException("IronBox does not contain that many elements.");
		return list.get(index).toString();
	}
	
	public int size(){
		return list.size();
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

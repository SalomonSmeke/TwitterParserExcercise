package io.salomon.tweet;

import java.util.ArrayList;

import org.omg.CORBA.portable.UnknownException;

//Just an experiment honestly. A datastructure for those who dont want strings messed with. Its super straightforward and thus mostly undocumented. 
public final class StringIronBox {

	private ArrayList<ImmutableItem> list;

	/**
	 * Initializer. Creates a StringIronBox of immutable items
	 * 
	 * @return      void
	 * @see         Tweet
	 * @see			Rule
	 * @see			Tweet
	 * @see			Types
	 */
	public StringIronBox(){
		list = new ArrayList<ImmutableItem>();
	}

	/**
	 * Adding a string to an iron box
	 * <p>
	 * returns true or false if success or fail
	 * 
	 * @param 		int
	 * @return      boolean
	 * @see         StringIronBox
	 * @see			ImmutableItem
	 */
	public boolean addString(String in){
		try{
			list.add(new ImmutableItem(in));
		}catch(UnknownException e){
			System.out.println(e);
			return false;
		}
		return true;
	}

	/**
	 * Removing a string from an iron box... doesnt work!
	 * ITS AND IRON BOX. THINGS GO IN NOT OUT DUH.
	 * <p>
	 * returns false
	 * 
	 * @param		in
	 * @return      boolean
	 * @see         StringIronBox
	 * @see			ImmutableItem
	 */
	public boolean removeString(String in){
		System.out.println("NOPE. Aint gonna remove from an iron box homie");
		return false;
	}

	/**
	 * Check if a string text is contained in an iron box
	 * <p>
	 * returns false or true based on result
	 * 
	 * @param		in
	 * @return      boolean
	 * @see         StringIronBox
	 * @see			ImmutableItem
	 */
	public boolean contains(String in){
		if(list.contains(new ImmutableItem(in))){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Return element at an index in an iron box
	 * <p>
	 * returns index or error if not contained.
	 * 
	 * @param		index
	 * @return      String
	 * @see         StringIronBox
	 * @see			ImmutableItem
	 */
	public String getAt(int index){
		if (index>list.size()-1) throw new IndexOutOfBoundsException("IronBox does not contain that many elements.");
		return list.get(index).toString();
	}

	/**
	 * Return amount of elements in iron box
	 * <p>
	 * returns size
	 * 
	 * @return      int
	 * @see         StringIronBox
	 * @see			ImmutableItem
	 */
	public int size(){
		return list.size();
	}

	private class ImmutableItem {
		private final String item;

		private ImmutableItem (String text){item = text;}
		@Override
		public String toString(){return item;}

		@Override
		public boolean equals(Object in){
			if (in.toString() == this.item) return true;
			else return false;
		}
	}


}

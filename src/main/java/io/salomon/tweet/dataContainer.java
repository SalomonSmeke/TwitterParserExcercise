package io.salomon.tweet;

/*
 * This class defines how things are stored. 
 * If mentions should be a class, or comma separated strings. Its all here.
 */
public class dataContainer{
	
	
	protected final class mentions {
		stringIronBox sib;
		protected mentions() {
			sib = new stringIronBox();
		}
	}
	//TODO Oh! These two are equal... add constructor & get set functionality to ironbox.
	protected final class topics {
		
	}
	
	private final class immutableItem {
		private final String item;
		
		private immutableItem (String text){item = text;}
		@Override
		public String toString(){return item;}
	}
}



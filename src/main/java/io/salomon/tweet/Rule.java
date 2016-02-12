package io.salomon.tweet;

public class Rule {

	/*
	 * Necessary ugliness here. I know I know. Wrap it in an object. 
	 * Well, I CANT CAUSE IM MAKING IT EASY FOR THE USER NOT FOR YOU MISTER CODE MAN. 
	 * (gender used for humor only, ha ha)
	 */

	private String type;
	private String start;
	private String end;
	private boolean required;
	private String behavior;
	private String []tokens;

	/**
	 * Takes a text handling rule as created by the user and makes it
	 * into a self contained parser :O
	 * <p>
	 * These come from the Rules file. And yes the params are ugly
	 *
	 * @param  type  the type of item this rule applies to
	 * @param  start 	the beginning of rule applicability (null for always applicable, "" to applicable after one char)
	 * @param  end  the end of rule applicability (null for always applicable, "" to applicable after one char)
	 * @param  required  true for these tokens are required, false for they are not allowed
	 * @param  behavior  split for using the first half as is, text for converting all item to text
	 * @param  tokens  the triggers for the rule
	 * @see         Tweet
	 * @see			Rules
	 * @see			Tweet
	 * @see			Types
	 */
	public Rule(String type, String start, String end, boolean required, String behavior, String []tokens){
		this.type = type;
		this.start=start;
		this.end=end;
		this.required=required;
		this.behavior=behavior;
		this.tokens=tokens;
	}

	/**
	 * Returns what if a rule is applicable to an item 
	 * It is very strict. Not only is matching done here but also in parsing by
	 * using the String result of this function (which is only non-empty if there is a match)
	 * to verify a match.
	 * <p>
	 * This method returns empty if no match or type if match.
	 *
	 * @param  in  a string to be checked for applicability
	 * @return      String
	 * @see         Tweet
	 * @see			Types
	 */	
	public String getApplicability(String in){
		boolean flag = false;
		in = removeUnapplicableStart(in);
		in = removeUnapplicableEnd(in);
		for (int i = 0; i < tokens.length; i++){
			if (in.contains(tokens[i])){
				flag = true;
			}
		}
		if (flag) return type;
		return "";
	}

	/**
	 * Returns type a rule is applicable to
	 * <p>
	 * @return      String
	 * @see         Tweet
	 * @see			Rules
	 * @see			Types
	 */	
	public String getType(){
		return type;
	}

	/**
	 * Processes a string that has been determined to be applicable.
	 * However! it still has some checks to make sure it is applicable.
	 * Because people misuse stuff. Most of what it does is just pass the item into
	 * proccessRequired or NotAllowed depending on the rule set up.
	 * <p>
	 * This method returns a String[]. The elements on 1 are to become text
	 * the elements on 0 are to become whatever type the item is.
	 *
	 * @param  in  a string to be processed with the rule
	 * @return      String[]
	 * @see         Tweet
	 * @see			Types
	 * @see			Rules
	 */	
	public String[] process(String in){
		if (required){
			return processRequired(in);
		}
		return processNotAllowed(in);
	}

	/**
	 * If a rule is processed as required, this method takes a string and applies a rule to
	 * the portions that are necessary. Then it places the parts of the string that will be 
	 * applied to the item type on an array index 0, then index 1 for text.
	 * <p>
	 *
	 * @param  in  a string to be processed as required
	 * @return      String[]
	 * @see         Tweet
	 * @see			Types
	 */	
	private String[] processRequired(String in){
		String save = in;
		in = removeUnapplicableStart(in);
		in = removeUnapplicableStart(in);
		boolean flag = false;
		for (int i = 0; i < tokens.length; i++){
			if (in.contains(tokens[i])){
				flag = true;
				break;
			}
		}
		if (flag){
			return new String[]{save};
		} else {
			return new String[]{null,save};
		}
	}

	/**
	 * If a rule is processed as not allowed, this method takes a string and applies a rule to
	 * the portions that are necessary. Then it places the parts of the string that will be 
	 * applied to the item type on an array index 0, then index 1 for text.
	 * <p>
	 *
	 * @param  in  a string to be processed as not allowed
	 * @return      String[]
	 * @see         Tweet
	 * @see			Types
	 */	
	private String[] processNotAllowed(String in){
		String save = in;
		in = removeUnapplicableStart(in);
		in = removeUnapplicableStart(in);
		int offset = save.indexOf(in);
		int index = 0;
		boolean flag = false;
		for (int i = 0; i < tokens.length; i++){
			if (in.contains(tokens[i])){
				flag = true;
				index = save.indexOf(tokens[i],offset);
				break;
			}
		}
		if (!flag){
			return new String[]{save}; //should not reach
		}
		if (behavior=="split"){
			return new String[]{save.substring(0, index),save.substring(index)};
		}
		if (behavior=="text"){
			return new String[]{null,save};
		}
		return null; //should not reach
	}

	//remove parts of the string specified as unapplicable. so rule can operate on body.
	private String removeUnapplicableStart(String in){
		if (start==null){
			return in;
		}
		if (start==""){
			return in.substring(1);
		}
		if (in.contains(start)){
			return in.substring(in.indexOf(start));
		} else {
			return "";
		}
	}
	private String removeUnapplicableEnd(String in){
		if (end==null){
			return in;
		}
		if (end==""){
			return in.substring(0,in.length()-1);
		}
		if (in.contains(end)){
			return in.substring(0,in.indexOf(end));
		} else {
			return in;
		}
	}
}

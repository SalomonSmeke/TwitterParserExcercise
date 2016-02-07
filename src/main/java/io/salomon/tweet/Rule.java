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
	
	
	public Rule(String type, String start, String end, boolean required, String behavior, String []tokens){
		this.type = type;
		this.start=start;
		this.end=end;
		this.required=required;
		this.behavior=behavior;
		this.tokens=tokens;
	}
	
	//Check if a rule applies to a string. Returns the type of rule if string qualifies. Nothing otherwise.
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
	
	public String getType(){
		return type;
	}
	
	public String[] process(String in){
		if (required){
			return processRequired(in);
		}
		return processNotAllowed(in);
	}
	
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

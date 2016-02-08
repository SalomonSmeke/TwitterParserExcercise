package io.salomon.tweet;

public class Rules {
	//Type, start of rule applicability (null for always, "" for one character), end of rule applicability, required=true notallowed=false, post-violarion handling.
	//String, char, char, boolean, split or text (split it in two or turn it into text), String[] triggers.
	private Rule[] userRulesSetup = new Rule[]{
		new Rule("mentions", null, null, false, "split", new String[]{
				
				"º","\\","ª","!","|","\"","·","#","$","//","¬","(",")","?","'","´","‚",
				"¿","¡","[","*","]","+","{","ç","}","Ç","-","ñ","Ñ",":",".",";","<",">"
				
		}),
		
		new Rule("mentions", null, null, false, "text", new String[]{
				
				"http://","https://","HTTP://","HTTPS://","@"
				
		}),
		
		new Rule("tags", null, null, false, "split", new String[]{
				
				"º","\\","ª","!","|","\"","·","@","$","//","¬","(",")","?","'","´","‚",
				"¿","¡","[","*","]","+","{","ç","}","Ç","-","ñ","Ñ",":",".",";","<",">"
				
		}),
		
		new Rule("tags", null, null, false, "text", new String[]{
				
				"http://","https://","HTTP://","HTTPS://","#"
				
		})
	};
	
	public Rules (){
		
	}
	
	public Rule[] getRules(){
		return userRulesSetup;
	}
}
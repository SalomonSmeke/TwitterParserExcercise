package io.salomon.tweet;

public class Rules {
	//Type, start of rule applicability, end of rule applicability, required/notallowed, post-violarion handling.
	//String, char, char, boolean, int {make it all text, treat the second part separately}, String[] triggers.
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
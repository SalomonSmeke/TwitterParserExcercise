package io.salomon.tweet;

public class Rules {

	private Rule[] userRulesSetup = new Rule[]{

			new Rule("mentions", null, null, false, "text", new String[]{

					"http://","https://","HTTP://","HTTPS://","@"

			}),

			new Rule("mentions", null, null, false, "split", new String[]{

					"º","\\","ª","!","|","\"","·","#","$","//","¬","(",")","?","'","´","‚",
					"¿","¡","[","*","]","+","{","ç","}","Ç","-","ñ","Ñ",":",".",";","<",">"

			}),

			new Rule("tags", null, null, false, "text", new String[]{

					"http://","https://","HTTP://","HTTPS://","#"

			}),

			new Rule("tags", null, null, false, "split", new String[]{

					"º","\\","ª","!","|","\"","·","@","$","//","¬","(",")","?","'","´","‚",
					"¿","¡","[","*","]","+","{","ç","}","Ç","-","ñ","Ñ",":",".",";","<",">"

			})

	};

	public Rules (){}

	/**
	 * A grouping of Rules that can be created by the user. the parameters below belong to a rule.
	 * <p>
	 * Yes the params are ugly, theyre for user ease.
	 *
	 * type  the type of item this rule applies to
	 * start 	the beginning of rule applicability (null for always applicable, "" to applicable after one char)
	 * end  the end of rule applicability (null for always applicable, "" to applicable after one char)
	 * required  true for these tokens are required, false for they are not allowed
	 * behavior  split for using the first half as is, text for converting all item to text
	 * tokens  the triggers for the rule
	 * 
	 * @return      Rule[]
	 * @see         Tweet
	 * @see			Rule
	 * @see			Tweet
	 * @see			Types
	 */
	public Rule[] getRules(){
		return userRulesSetup; 
	}
}
# TwitterParserExcercise
A twitter parser with emphasis on user addable rules, testability, and string immutability.

## UGH FINE. It really does make sense to write a readme. otherwise this thing makes no sense.
This parses tweets. Picks out the tags, links, etc. And feeds them back categorized.
Thats all fine, well, and not a big deal.

What is a little different is how easy it is to add new rules to the parser. Dont want to takes links with the letter "l" on them? no problem.

''' 		new Rule("links", null, null, false, "text", new String[]{"l"}), '''

Want the offending portion of text to be tossed in separately and the other part to be a link? want the "l" to not be applicable after /?

''' 		new Rule("links", "/", null, false, "split", new String[]{"l"}), '''

That kinda thing

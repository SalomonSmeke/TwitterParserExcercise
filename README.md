# TwitterParserExcercise
A twitter parser with emphasis on user addable rules, testability, and string immutability.

## UGH FINE. It really does make sense to write a readme. otherwise this thing makes no sense.
This parses tweets. Picks out the tags, links, etc. And feeds them back categorized.
Thats all fine, well, and not a big deal.

What is a little different is how easy it is to add new rules to the parser. Dont want to take links with the letter "l" in them? no problem.

''' 		new Rule("links", null, null, false, "text", new String[]{"l"}), '''

Want the offending portion of text to be tossed in separately and the other part to be a link? want the "l" to not be applicable after /?

''' 		new Rule("links", "/", null, false, "split", new String[]{"l"}), '''

That kinda thing

ugh. but I want the rule to not be applicable after a #. I use l's in some angular stuff.

Fine!

''' 		new Rule("links", "/", "#", false, "split", new String[]{"l"}), '''

you know. i take that back. ?# is the thing. and if the url isnt mine (pretendperson.io) or my associates (pretendhomie. something) i want it to just be text. Oh. and we dont want any X's or Z's in the url at all.

''' 		new Rule("links", "/", "?#", false, "split", new String[]{"l"}), '''

''' 		new Rule("links", null, null, false, "text", new String[]{"X","Z"}), '''

''' 		new Rule("links", null, "/", true, "text", new String[]{"pretendperson.io","pretendhomie."}), '''

Oh man! Id love to add a new thing anything that starts with & should be a grouping!

Cool. Done.

{"&","grouping"}

Come at it.

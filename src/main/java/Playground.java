import io.salomon.tweet.Tweet;
/*
 * This file intended to demonstrate/play-with the functionality of the Tweet object.
 * This file is NOT a testing structure
 */
public class Playground {
    public static void main(String []args){
    	Tweet testTweet = new Tweet("@mentio#nsample #tagsample http://linksample.com samplewords sample @phttp:// ");
    	
    	System.out.println(testTweet);
    	
    	testTweet.meta();
    }
}

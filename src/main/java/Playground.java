import io.salomon.tweet.Tweet;

/**
 * Is used as a playground to test the functionality of Tweet.
 * Operates as a "main"
 */

public class Playground {
	public static void main(String []args){
		Tweet testTweet = new Tweet("@mentio#nsample #tagsample http://linksample.com samplewords sample @phttp:// ");

		System.out.println(testTweet);
		System.out.println(testTweet.meta());
	}
}

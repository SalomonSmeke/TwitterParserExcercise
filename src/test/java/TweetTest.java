import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;

import io.salomon.tweet.*;

public class TweetTest {
	
	@Test public void testImmutableString() throws Exception{
		/*
		 * This one is a doozy. How do we test a private class inside a public class? Geez Louise.
		 * http://www.artima.com/suiterunner/private2.html
		 */
	    
		//First, make an instance of the external class
        stringIronBox publicClass = new stringIronBox();
        
        //Now grab the inner private class
        Class<?> privateClass = Class.forName("io.salomon.tweet.stringIronBox$immutableItem");
        
        //Get the private constructor. Inside of stringIronBox. With a string argument.
        Constructor<?> constructor = privateClass.getDeclaredConstructor(stringIronBox.class, String.class);
        
        //Make it accessible to us (cause its private)
        constructor.setAccessible(true);
        
        //FINALLY Make our target object.
        Object immutableItem = constructor.newInstance(publicClass,"testText!");

        //Test the object's contents = what we put in there.
		assertEquals("testText!",immutableItem.toString());
	}
}

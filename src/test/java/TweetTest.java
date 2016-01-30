import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import java.lang.reflect.Constructor;

import io.salomon.tweet.*;

public class TweetTest {
	
	@Test public void testImmutableString() throws Exception{
		/*
		 * This one is a doozy. How do we test a private class inside a public class? Geez Louise.
		 * http://www.artima.com/suiterunner/private2.html
		 */
	    
		System.out.println("A string put into an immutable item should come out the same");
		
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

	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test public void testStringIronBox(){
		stringIronBox testable = new stringIronBox();
		
		assertTrue(testable.addString("String 1"));
		assertTrue(testable.removeString("String 1"));
		assertFalse(testable.removeString("Not contained string"));
	    thrown.expect(IndexOutOfBoundsException.class);
	    testable.getAt(0);
	}
}

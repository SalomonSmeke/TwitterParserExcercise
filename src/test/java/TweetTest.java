import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import java.lang.reflect.Constructor;

import io.salomon.tweet.*;

public class TweetTest {
	
	@Rule public ExpectedException thrown = ExpectedException.none();
	
	
	//Begin String Iron Box test chunk
	@Test public void testImmutableString() throws Exception{
		/*
		 * This one is a doozy. How do we test a private class inside a public class? jeez Louise.
		 * http://www.artima.com/suiterunner/private2.html <- helpful
		 */
	    
		System.out.println("TEST: A string put into an immutable item should come out the same");
		
		//First, make an instance of the external class
        StringIronBox publicClass = new StringIronBox();
		System.out.println("	INSTANTIATED EXTERNAL CLASS OK");
        //Now grab the inner private class
        Class<?> privateClass = Class.forName("io.salomon.tweet.StringIronBox$immutableItem");
		System.out.println("	INSTANTIATED INTERNAL CLASS OK");
        //Get the private constructor. Inside of stringIronBox. With a string argument.
        Constructor<?> constructor = privateClass.getDeclaredConstructor(StringIronBox.class, String.class);
		System.out.println("	OBTAINED PRIVATE CONSTRUCTOR OK");
        //Make it accessible to us (cause its private)
        constructor.setAccessible(true);
		System.out.println("	SET ACCESS TO PRIVATE CONSTRUCTOR OK");
        //FINALLY Make our target object.
        Object immutableItem = constructor.newInstance(publicClass,"testText!");
		System.out.println("	CONSTRUCT PRIVATE OBJECT OK");
        //Test the object's contents = what we put in there.
		assertEquals("testText!",immutableItem.toString());
		System.out.println("	GET CONTAINED STRING OK");
		System.out.println("TEST: \u2713");
	}
    
	@Test public void testStringIronBoxAdd(){
		System.out.println("TEST: A string put into the iron box should come out the same");
		StringIronBox testable = new StringIronBox();
		System.out.println("	INSTANTIATED OK");
		assertTrue(testable.addString("String 1"));
		System.out.println("	ADDED OK");
		assertEquals("String 1", testable.getAt(0));
		System.out.println("	GET OK");
		System.out.println("TEST: \u2713");
	}
	
	@Test public void testStringIronBoxContains(){
		System.out.println("TEST: A string put into the iron box should be contained, others should not");
		StringIronBox testable = new StringIronBox();
		System.out.println("	INSTANTIATED OK");
		assertTrue(testable.addString("String 1"));
		System.out.println("	ADDED OK");
		assertTrue(testable.contains("String 1"));
		System.out.println("	CONTAINS OK");
		System.out.println("TEST: \u2713");
	}
	
	@Test public void testStringIronBoxRemovalKey(){
		System.out.println("TEST: A string put into the iron box should be removable by Key");
		StringIronBox testable = new StringIronBox();
		System.out.println("	INSTANTIATED OK");
		assertTrue(testable.addString("String 1"));
		System.out.println("	ADDED OK");
		assertTrue(testable.contains("String 1"));
		System.out.println("	CONTAINS OK");
		assertFalse(testable.removeString("String 2"));
		System.out.println("	INCORRECT REMOVE OK");
		assertTrue(testable.removeString("String 1"));
		System.out.println("	CORRECT REMOVE OK");
		assertFalse(testable.contains("String 1"));
		System.out.println("	DOES NOT CONTAIN OK");
		System.out.println("TEST: \u2713");
	}
	
	@Test public void testStringIronBoxIndex(){
		System.out.println("TEST: An iron box should be the size of what it contains");
		StringIronBox testable = new StringIronBox();
		System.out.println("	INSTANTIATED OK");
		assertTrue(testable.addString("String 1"));
		System.out.println("	ADDED OK");
		assertEquals(testable.size(),1);
		System.out.println("	SIZE 1 OK");
		assertTrue(testable.addString("String 1"));
		System.out.println("	ADDED OK");
		assertEquals(testable.size(),2);
		System.out.println("	SIZE 2 OK");
		assertTrue(testable.removeString("String 1"));
		System.out.println("	REMOVED OK");
		assertEquals(testable.size(),1);
		System.out.println("	SIZE 1 OK");
		System.out.println("TEST: \u2713");
	}
	
	@Test public void testStringIronBoxOutOfBounds(){
		System.out.println("TEST: An iron box should have bounds equal to size \nWARN. EXCEPTION EXPECTED. TEST WILL END WITHOUT MARK");
		StringIronBox testable = new StringIronBox();
		System.out.println("	INSTANTIATED OK");
		assertTrue(testable.addString("String 1"));
		System.out.println("	ADDED OK");
		thrown.expect(IndexOutOfBoundsException.class);
		testable.getAt(0);
		System.out.println("	GET WITHIN BOUNDS OK");
		testable.getAt(1);
		System.out.println("***SHOULD NOT REACH***");
	}
	//END String Iron Box test chunk
	
	
}

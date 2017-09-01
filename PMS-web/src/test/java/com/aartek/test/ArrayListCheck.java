package com.aartek.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.aartek.controller.Testclass;

public class ArrayListCheck {
	public static Testclass tc;
	@BeforeClass
	public static void init() {
	 tc = new Testclass();
	System.out.println("In before class");
	}
	List<Integer> l;
	
	@Before
	 public void beforeTest() {
        l = new ArrayList<Integer>();
        l.add(4);
        l.add(5);
       l.add(-6);
//        l.add(8);
    }


	@Test @Ignore
	public void testAllADD() {
		assertEquals(9,tc.alladd(l));
	}
	@Test
	public void testAll()
	{
		assertEquals(3,tc.alladd(l));
	}
	
	@Test
	public void testFindMax()
	{
		assertEquals(4, tc.findMax(new int[] {1,3,4,2}));
		assertEquals(-1,tc.findMax(new int[] {-12,-1,-3,-4,-2}));
	}
	
	@Test
	public void testCube()
	{
		assertEquals(27, tc.cube(3));
	}
	
	 @Test(expected = ArithmeticException.class)
	    public void testDivisionWithException() {
	        int j = 1 / 0;
	    }

	 @Test(expected = IndexOutOfBoundsException.class)
	    public void testEmptyList() {
	        new ArrayList<Integer>().get(0);
	    }

	
	@After
	public void afterc()
	{
		l = null;
		System.out.println("after");
	}

	@AfterClass
	public static void aftercla()
	{
		System.out.println("afterclasssss");
	}
	
	

}

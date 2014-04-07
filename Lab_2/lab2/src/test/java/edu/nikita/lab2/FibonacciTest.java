package edu.nikita.lab2;

import junit.framework.TestCase;

public class FibonacciTest extends TestCase {

	public void testComputeSanity() {
		try {
			if(Fibonacci.Compute(4) == 3)
				return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Fibonacci.Compute should compute so it matches Wikipedia");
	}
	
	public void testComputeWrongInput() {
		try {
			Fibonacci.Compute(-1);
		} catch (Exception e) {
			return;
		}
		fail("Fibonacci.Compute should throw exceptions when gets N < 0 as argument");
	}

	/*
	public void testBad() {
		try {
			if(Fibonacci.Compute(4) == 146)
				return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Fibonacci.Compute should compute so it always 146% right");
	}
	*/
}

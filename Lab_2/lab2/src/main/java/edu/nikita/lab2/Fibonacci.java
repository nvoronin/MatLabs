package edu.nikita.lab2;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fibonacci {
	
	private static Logger logger = LoggerFactory.getLogger(Fibonacci.class.getName());
	
	private static HashMap<Integer,Integer> accumulator = new HashMap<Integer,Integer>();
	
	public static Integer Compute(Integer n) throws Exception{
		if (n < 0)
		{
			//
			// exception
			//
			Exception e = new Exception("Argument is out of range");
			logger.error("Can't compute Fibonacci for {}", n, e);
			throw e;
		}
		else if(n == 0)
		{
			return 0;
		}
		else if(n == 1)
		{
			return 1;
		}
		else if (!accumulator.containsKey(n)){
			int val = Compute(n - 1) + Compute(n - 2);
			accumulator.put(n, val);
		}
		return accumulator.get(n);
	}
	
}

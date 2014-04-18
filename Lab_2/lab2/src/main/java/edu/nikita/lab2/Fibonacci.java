package edu.nikita.lab2;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fibonacci implements IFunction {
	
	private static Logger logger = LoggerFactory.getLogger(Fibonacci.class.getName());
	
	private static HashMap<Long,Long> accumulator = new HashMap<Long,Long>();
	
	/* (non-Javadoc)
	 * @see edu.nikita.lab2.IFunction#Compute(java.lang.Integer)
	 */
	public Long Compute(Long n) throws Exception{
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
			return (long)0;
		}
		else if(n == 1)
		{
			return (long)1;
		}
		else if (!accumulator.containsKey(n)){
			Long val = Compute(n - 1) + Compute(n - 2);
			accumulator.put(n, val);
		}
		return accumulator.get(n);
	}
	
}

package edu.nikita.lab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberSeries {
	private IFunction func;

	protected IFunction getFunc() {
		return func;
	}

	@Autowired
	public void setFunc(IFunction func) {
		this.func = func;
	}
	
	public void Produce(){
		System.out.println( "Doge said Wow!" );
        try {
        	IFunction f = getFunc();
			System.out.println( "1 Doge said " + f.Compute((long)1).toString() );
			System.out.println( "2 Doge said " + f.Compute((long)2).toString() );
			System.out.println( "3 Doge said " + f.Compute((long)3).toString() );
			System.out.println( "4 Doge said " + f.Compute((long)4).toString() );
			System.out.println( "0 Doge said " + f.Compute((long)0).toString() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

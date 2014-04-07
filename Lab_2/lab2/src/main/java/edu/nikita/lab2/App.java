package edu.nikita.lab2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Doge said Wow!" );
        try {
			System.out.println( "1 Doge said " + Fibonacci.Compute(1).toString() );
			System.out.println( "2 Doge said " + Fibonacci.Compute(2).toString() );
			System.out.println( "3 Doge said " + Fibonacci.Compute(3).toString() );
			System.out.println( "4 Doge said " + Fibonacci.Compute(4).toString() );
			System.out.println( "0 Doge said " + Fibonacci.Compute(0).toString() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

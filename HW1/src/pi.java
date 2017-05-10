import java.util.*;
public class pi {
	public static void main(String[]args){
		Scanner theInput = new Scanner(System.in);	
		System.out.print("How many digits of pi would you like? ");
		int n = theInput.nextInt();
		double calculatePi= pi(n);
		System.out.println("Pi to "  + n + " digits is: "+ calculatePi);
		
	}
	
	
	public static double pi(int n){
		double piFormula = 0;	
	    for(int i = 0; i < 10000; i++) {
	    	 
	        if (i%2 == 0)
	        	piFormula = piFormula + 1.0/(2.0*i+1.0);
	        else
	        	piFormula = piFormula - 1.0/(2.0*i+1.0);        	
	    }  
	    piFormula = 4.0 * piFormula;
	    String pi1 = Double.toString(piFormula);
	    if(pi1.length()>n+1){
	    	String answer = pi1.substring(0,n+2);
	    	double result = Double.parseDouble(answer);
	    	return result;
	    }
	    return 0.0;
    		
	}
	
}

//How many digits of pi would you like? 5
//Pi to 5 digits is: 3.14159

//How many digits of pi would you like? 7
//Pi to 7 digits is: 3.1414926

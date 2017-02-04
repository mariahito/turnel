import java.util.*;
public class jump {
	public static void main(String []args){
		Scanner theInput = new Scanner (System.in);
		System.out.print("Enter velocity in mhp: ");
		double velocity = theInput.nextDouble();
		System.out.println(escape(velocity));
	}
	public static String escape(double v){
		double mass2=0;
		String answer = "";
		double convertion = 0.44704;
		double G = 6.67e-11;
		double M = 1.3e22;
		double R = 1.153e6;
		double escape = Math.sqrt((2*G*M)/R);
		if (v <= escape)
			return("The astronaut will return!");
		else{
			
			if (v*convertion > escape){
				
				double num2 = (R * Math.pow(v, 2.0))/(2 * G);
				mass2 = num2 - M;
				answer = "The astronaut will not return to Halley's comet. In order for the astronaut to return the comet would need to"+
						" have a mass larger than "+ mass2;
			}
		}
		return answer; 
				
	}
}

//Enter velocity in mhp: 100000
//The astronaut will not return to Halley's comet. In order for the astronaut to return
//the comet would need to have a mass larger than 8.641878410794602E25

//Enter velocity in mhp: 160
//The astronaut will return!



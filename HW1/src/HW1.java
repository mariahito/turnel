
public class HW1 {
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
//How many digits of pi would you like? 5
//Pi to 5 digits is: 3.14159

//How many digits of pi would you like? 7
//Pi to 7 digits is: 3.1414926

	
public static String easter(int y){
		int a = y % 19;
		int c = y % 100;
		int b = y/100;
		int d = b/4;
		int e = b % 4;
		int g = (8*b+13)/25;
		int h = (19*a+b-d-g+15)%30;
		int j = c/4;
		int k = c % 4;
		int m = (a+11*h)/319;
		int r = (2*e+2*j-k-h+m+32)%7;
		int n = (h-m+r+90)/25;
		int p = (h-m+r+n+19)%32;
		String date;

		switch(n) 
		{  
		case 1:date = "January ";break;
		case 2:date = "February";break;
		case 3:date = "March";break;
		case 4:date = "April";break;
		case 5:date = "May";break;
		case 6:date = "June";break;
		case 7:date = "July";break;
		case 8:date = "August";break;
		case 9:date = "September";break;
		case 10:date = "October";break;
		case 11:date = "November";break;
		case 12:date = "December";break;
		default:date = "";break;
		} 
		return date + " "+ p;
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

//Enter velocity in mhp: 100000
//The astronaut will not return to Halley's comet. In order for the astronaut to return
//the comet would need to have a mass larger than 8.641878410794602E25

//Enter velocity in mhp: 160
//The astronaut will return!



public static int[] random(int r, int a, int b){
		String num = "";
		int numberArray[] = new int [25];
		for (int i = 0; i < numberArray.length; i++) {
			int answer = (a*r+b);
			numberArray [i] = answer;
			r = answer;
		}
		for(int i=0;i<numberArray.length;i++){
			System.out.println(numberArray[i]);
		}
		System.out.println();
		System.out.println("This is the memory address of the array");
		return numberArray; 
	}		
	
/*Enter a value for r: 45
Enter a value for a: 65
Enter a value for b: 235
3160
205635
13366510
868823385
638945412
-1418220945
-1990047974
-504099195
1593290928
484695451
1440433478
-861104207
-137198372
-327959353
157478770
1646185693
-372112120
1582516211
-215661154
-1133072887
-635293388
1655602975
240011210
-1579140299
435095904
*/

/* Enter a value for r: 12
Enter a value for a: 987
Enter a value for b: 456
12300
12140556
-902172660
-1386184692
1930276876
-1782202356
1902866444
1228472332
1321414668
-1433780212
-2096828404
604602380
-257904628
-1148796916
8810508
106037260
1579560972
-46448628
1399844876
-1332576244
-992759796
-601374708
-851349492
1531641868
-97964020
*/

}

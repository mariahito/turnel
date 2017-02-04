import java.util.*;
public class easter {
	public static void main(String[]args){
		Scanner theInput = new Scanner (System.in);
		System.out.print("Enter a year: ");
		int y = theInput.nextInt();
		
		String easterDate= easter(y);
		System.out.println("In " + y + " Easter Sunday fell on " + easterDate );
	}
	
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
//shortcut for if-else if statement. Applied only for integers or characters 
//Big Java pg. 175
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
}
//Enter a year: 2001
//In 2001 Easter Sunday fell on April 15

//Enter a year: 1989
//In 1992 Easter Sunday fell on March 26



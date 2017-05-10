//Maria Hito (mh4wt)
//Homework 6
import java.awt.Color;
import java.util.Scanner;

public class Recursion {

	public static void main(String[]args){
		Scanner word = new Scanner(System.in);
		System.out.print("Enter word to reverse: ");
		String input;
		input = word.nextLine();
		System.out.println(reverseString(input));	
		
		System.out.println("Count strides");
		System.out.println("Possible ways to climb stairs: " + countWays(5));
		
		System.out.println("Ackermann's function");
		System.out.println(Ackermann(0,0));
		System.out.println(Ackermann(0,1));
		System.out.println(Ackermann(1,1));
		System.out.println(Ackermann(2,2));
		System.out.println(Ackermann(3,3));
		
		World world1 = new World(900,900,Color.WHITE);
		Turtle bob = new Turtle(world1);
		bob.setDelay(0.0);
		bob.pickPenUp();
		bob.goTo(-300,0.0);
		snowflake(bob,3,420.0);
	}
	
// Reverse string
	public static String reverseString(String reverse){
		if(reverse == null){
			return reverse;
		}
		if(reverse.length() <= 1 ){
			return reverse;
		}
		return reverseString(reverse.substring(1)) + reverse.charAt(0);
	}

//Count strides
	public static int countWays(int numStairs){
		if(numStairs <= 1){  //base case
			return 1;
		}	
		return countWays(numStairs - 1) + countWays(numStairs -2);
	}

//Ackermann's function
	public static int Ackermann(int m,int n){
		if(m == 0){    //base case
			return n + 1;
		}
		if(m > 0 && n == 0){
			return Ackermann(m - 1,1);
		}
		else
			return Ackermann(m - 1,Ackermann(m,n - 1));
	}
	
//Snow flake
	
	 public static void helperSnowflake(Turtle t,int depth,double length) {
		if(depth == 0){  //base case
			t.forward(length);
		}
		else{
		    helperSnowflake(t,depth-1,length/4); 
		    
		    t.left(60.0);
		    
		    helperSnowflake(t,depth-1,length/4);
		 
		    t.right(120.0);
		    
		   helperSnowflake(t,depth-1,length/4);
		   
		   t.left(60.0);
		   
		   helperSnowflake(t,depth-1,length/4);
		}
	 }
	 public static void snowflake(Turtle t,int depth,double length){
		t.putPenDown();
		helperSnowflake(t,depth,length);
		t.right(120.0);
		helperSnowflake(t,depth,length);
		t.right(120.0);
		helperSnowflake(t,depth,length); 		
	 }
}

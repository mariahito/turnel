import java.util.Scanner;

public class randnums {
	public static void main(String[] args){
		Scanner theInput = new Scanner(System.in);
		System.out.print("Enter a value for r: ");
		int r = theInput.nextInt();
		System.out.print("Enter a value for a: ");
		int a = theInput.nextInt();
		System.out.print("Enter a value for b: ");
		int b = theInput.nextInt();
		
		System.out.println(random(r,a,b));		
	}
	
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



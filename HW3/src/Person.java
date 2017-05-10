//Maria Hito (mh4wt)
//Homework 3
import java.util.ArrayList;

public class Person {
	private String name;
	private ArrayList<Book> checkedOut= new ArrayList<>();
	private String address;
	private int libraryCardNum;

	//Constructor
	public Person(String name,String address,int libraryCardNum){
		this.name = name;
		this.address = address;
		this.libraryCardNum = libraryCardNum;
	}

	public Person(){
		//Empty constructor. Constructor being  called in JUnit tests
	}

	//Accessors
	public String getName(){
		return name;
	}
	public ArrayList<Book> getCheckedOut() {
		return checkedOut;
	}

	public String getAddress(){
		return address;
	}

	public int getLibraryCardNum(){
		return libraryCardNum;
	}

	//Mutators
	public void setName(String name){
		this.name = name; // calling object for methods
	}

	public void setAddress(String address){
		this.address = address;
	}

	//Methods
	public boolean addBook(Book b){
		if(checkedOut.contains(b)){
			return false;
		}
		else{
			checkedOut.add(b);
		}
		return true;
	}

	public boolean equals(Object o){
		if (o instanceof Person) {
			Person p = (Person) o; 
			return this.libraryCardNum == p.libraryCardNum;
		}
		return false;	
	}

	public String toString(){
		return "Name: " + name + "Library card: " + libraryCardNum + "Checked out: " + checkedOut;
	}

}

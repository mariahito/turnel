//Maria Hito (mh4wt), Homework 2
//IPA for functions
import java.util.ArrayList;

public class Person {
	private String name;
	private int id;
	private ArrayList<Book> booksCount;

	public Person(String name,int id){
		this.name = name;
		this.id = id;
		this.booksCount = new ArrayList<Book>();
	}

	//Accessors return values of private fields	
	public int getid(){
		return id;
	}

	public String getName(){
		return name;
	}
	public ArrayList<Book> getBooks() {
		return booksCount;
	}

	//Mutators set a value of a private field. Not return type  
	//accept a parameter that is the same data type as their corresponding private field
	public void setName(String name){
		this.name = name;
	}

	public boolean addBook(Book b){
		if(booksCount.contains(b))
			return false;
		else
			booksCount.add(b);
		return true;
	}

	public boolean hasRead(Book b){
		if(booksCount.contains(b)){
			return true;
		}
		else
			return false;
	}

	public boolean forgetBook(Book b){
		if(booksCount.contains(b)){
			booksCount.remove(b);
			return true;
		}
		else
			return false;
	}

	public int numBooksRead(){
		return booksCount.size();
	}

	public boolean equals(Object o){
		// Check if an object is an instance of a specific class. Normally use it, when you have 
		//a reference or parameter to an object that is of a super class	
		if (o instanceof Person) {
			Person p = (Person) o; //  cast o to Person
			if (this.id == p.id) 
				return true;
			else
				return false;
		}
		else 
			return false;
	}

	public String toString(){
		return "Name: " + getName() + "ID: " + getid() + "Books read: " + booksCount.toString();
	}

	public static ArrayList<Book> commonBooks(Person a, Person b){
		ArrayList<Book> commonB = new ArrayList<Book>();
		ArrayList<Book> aRead = a.getBooks();
		ArrayList<Book> bRead = b.getBooks();
		for(int i=0; i < aRead.size();i++){
			Book book = aRead.get(i);
			for(int z=0; z < bRead.size();i++){
				if(book.equals(bRead.get(z))){
					commonB.add(book);
				}
			}
		}
		return commonB;
	}

	public static double similarity(Person a, Person b){
		int commonBook = commonBooks(a,b).size();
		if(commonBook == 0){
			return 0.0;
		}
		else {
			if (a.getBooks().size()< b.getBooks().size())
				return (double) commonBook / (double) a.getBooks().size();
			else
				return (double) commonBook / (double) b.getBooks().size();
		}
	}
}



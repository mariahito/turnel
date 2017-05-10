//Maria Hito(mh4wt)
//Homework 3
//I found how to use SimpleDate Format object in the following website
//http://www.java2s.com/Tutorial/Java/0040__Data-Type/SimpleDateFormat.htm
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Library {
	private ArrayList<Book>libraryBooks= new ArrayList<Book>() ;
	private ArrayList<Person>patrons=new ArrayList<Person>();
	private String name;
	private int numBooks = 0;
	//private int numPeople;
	private String currentDate;

	//Constructor
	public Library(String name){		
		this.name = name;

	}

	public Library(){
		this.name = null;

	}

	public void addBook(Book b){
		if(!libraryBooks.contains(b) && b != null){
			libraryBooks.add(b);
		}

	}
	public void addPerson(Person p)
	{
		if(!patrons.contains(p) && p != null){
			patrons.add(p);
		}
	}
	//Accessors
	public ArrayList<Book>getLibraryBooks(){
		return libraryBooks;
	}

	public ArrayList<Person>getPatrons(){
		return patrons;
	}

	public String getName(){
		return name;
	}

	public int getNumBooks(){
		int sum=0;

		for(Book b: libraryBooks){
			if(!b.getCheckedOut()){
				sum++;
			}
		}
		this.numBooks =sum;
		return numBooks;
	}

	public int getNumPeople(){
		int numPeople;
		numPeople = patrons.size();
		return numPeople;
	}

	public String getCurrentDate(){
		return currentDate;
	}

	//Mutators
	public void setLibraryBooks(ArrayList<Book>libraryBooks){
		this.libraryBooks = libraryBooks;
	}

	public void setPatrons(ArrayList<Person>patrons){
		this.patrons = patrons;
	}
	public void setName(String name){
		this.name = name;
	}

	public void setCurrentDate(String currentDate){
		this.currentDate =currentDate;
	}

	//Methods

	// Return number of copies of the book in the library
	public int checkNumCopies(String title,String author){
		int numBookCopies = 0;
		for(Book b:libraryBooks){
			if((b.getTitle().equals(title))&& (b.getAuthor().equals(author))){
				numBookCopies++;	
			}
		}
		return numBookCopies;
	}

	//Returns number of books in the library
	public int totalNumBooks(){
		int totalBooks = 0;
		if(libraryBooks != null){
			totalBooks = libraryBooks.size();
		}
		return totalBooks;
	}

	//Checks out the book if the person is a patron and the book is in the library and not checked out
	public boolean checkOut(Person p,Book b,String dueDate){
		if((patrons.contains(p))&& (libraryBooks.contains(b)&& !b.getCheckedOut())){
			for(Book a: libraryBooks){
				if(a.equals(b)){
					a.setCheckedOut(true);
					p.addBook(a);
					a.setDueDate(dueDate);
					return true;
				}
			}
		}
		return false;
	}


	//Returns array List of books due on the given date
	public ArrayList<Book>booksDueOnDate(String date){
		ArrayList<Book> bookDue = new ArrayList<Book>();
		for(Book b: libraryBooks){
			if(libraryBooks.get(libraryBooks.indexOf(b)).getDueDate().equals(date)){
				bookDue.add(b);
			}
		}
		return bookDue;
	}

	public double lateFee(Person p){
		double fee = 0;
		long diffDay = 0;
		for(Book b : p.getCheckedOut()){
			//specify a pattern String. The contents of the pattern String determine the format of the date and time
			DateFormat myFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
			String date = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy").format(new Date());
			try{
				Date date1 = (Date)myFormat.parse(date);
				Date date2 = myFormat.parse(b.getDueDate());
				long diff = date1.getTime()-date2.getTime();
				diffDay = diff;
				diffDay=TimeUnit.DAYS.convert(diffDay, TimeUnit.MILLISECONDS);
				//calculate the number of days between the current date and the date the book is due

			}catch(ParseException e){
				e.printStackTrace();
			}
			fee = fee + (b.getBookValue()*0.01* diffDay);
		}
		return fee;
	}

}
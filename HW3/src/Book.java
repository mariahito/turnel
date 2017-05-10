// Maria Hito(mh4wt)
//Homework 3
public class Book {
	private String title;
	private String author;
	private String dueDate ;
	private boolean checkedOut;
	private int bookId;
	private double bookValue;

	//Constructor
	public Book(String title, String author,int bookId,double bookValue){
		this.title = title;
		this.author = author;

		String dueDate = "DD MM YYYY";
		this.dueDate = dueDate;
		boolean checkedOut = false;
		this.checkedOut = checkedOut;
		this.bookId = bookId;
		this.bookValue = bookValue;
	}

	//Accessors
	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public String getDueDate(){
		return dueDate;
	}

	public boolean getCheckedOut(){
		return checkedOut;
	}

	public int getBookId(){
		return bookId;
	}

	public double getBookValue(){
		return bookValue;
	}

	//Mutators
	public void setTtile(String title){
		this.title = title;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public void setDueDate(String dueDate){
		this.dueDate = dueDate;
	}

	public void setCheckedOut(boolean checkedOut){
		this.checkedOut = checkedOut;
	}

	public void setBookValue(double bookValue){
		this.bookValue = bookValue;
	}

	//Methods
	public boolean equals(Object o){
		if (o instanceof Book) {
			Book b = (Book) o; 
			return this.bookId == b.bookId;
		}	
		return false;
	}

	public String toString(){
		return "Book title: " + title + "author: "+ author+ "Due date: " + dueDate;
	}
}

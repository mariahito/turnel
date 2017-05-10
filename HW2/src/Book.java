//Maria Hito (mh4wt), Homework 2
import java.util.ArrayList;

public class Book {
	private String title;
	private String author;

	public Book(String title, String author){
		this.title = title;
		this.author = author;
	}

	public String getTitle(){
		return title;
	}

	public String getAuthor(){
		return author;
	}

	public boolean equals(Object o){
		if (o instanceof Book) {
			Book b = (Book) o; //casting o to Book
			if ((this.author == b.author)&&(this.title == b.title))
				return true;
			else
				return false;
		}
		return false;
	}

	public String toString(){
		return "Book title: " + getTitle() + "author "+ getAuthor();
	}
}

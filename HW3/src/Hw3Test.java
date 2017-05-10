import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;

public class Hw3Test {
	@Before
	public void setUp()throws Exception{
		//used to indicate that attached method will be run before any test in the class
	}

	@Test(timeout = 100)
	public void testTotalNumBooks(){
		int booksCheckedOut = 0;
		Library tester = new Library();
		assertEquals(booksCheckedOut,tester.totalNumBooks());
	}

	@Test(timeout=100)
	public void testCheckNumCopies() {
		Book b = new Book("Maze Runner","James Dashner",45981,35);
		Book b2 = new Book("Hunger Games","Suzanne Collins",35335,45);
		Library tester = new Library();
		tester.addBook(b);
		tester.addBook(b2);
		if(b.equals(b2)){
			assertEquals("Equal ",1,tester.getNumBooks());
		}
		else {
			assertEquals("Equal ",2,tester.getNumBooks());
		}
	}		

	@Test(timeout=100)
	public void testCheckOut() {
		Library testLibrary = new Library("Library test");
		Book b1 = new Book("Hunger Games","Suzanne Collins",35335,35);
		Book b2 = new Book("Harry Potter","J K Rowling",56748,48);
		Book b3 = new Book("some book","author",56748,48);
		Person nick = new Person();
		Person amy = new Person();
		nick.setName("Nick");
		amy.setName("Amy");
		testLibrary.addBook(b1);
		testLibrary.addBook(b2);
		testLibrary.addPerson(nick);
		testLibrary.addPerson(amy);
		System.out.println("Book is not in Library");
		testLibrary.checkOut(nick,b3,"12 20 2016");
		assertEquals(false,b1.getCheckedOut());
	}

	@Test(timeout=100)
	public void testCheckOut2() {
		Library testLibrary = new Library("Library test");
		Book b1 = new Book("Hunger Games","Suzanne Collins",35335,35);
		Book b2 = new Book("Harry Potter","J K Rowling",56748,48);
		Person nick = new Person();
		Person amy = new Person();
		nick.setName("Nick");
		amy.setName("Amy");
		testLibrary.addBook(b1);
		testLibrary.addBook(b2);
		testLibrary.addPerson(nick);
		testLibrary.addPerson(amy);
		System.out.println("Amy checked out Hunger Games");
		testLibrary.checkOut(amy,b2,"12 20 2016");
		assertEquals(true,b2.getCheckedOut());
	}

	@Test(timeout=100)
	public void testCheckOut3() {
		Library testLibrary = new Library("Library test");
		Book b1 = new Book("Hunger Games","Suzanne Collins",35335,35);
		Book b2 = new Book("Harry Potter","J K Rowling",56748,48);
		Person nick = new Person();
		Person amy = new Person();
		Person anna = new Person();
		nick.setName("Nick");
		amy.setName("Amy");
		anna.setName("Anna");
		testLibrary.addBook(b1);
		testLibrary.addBook(b2);
		testLibrary.addPerson(nick);
		testLibrary.addPerson(amy);
		System.out.println("Anna is not a Patron");
		testLibrary.checkOut(anna,b2,"12 20 2016");
		assertEquals(true,b2.getCheckedOut());
	}

	@Test(timeout=100)
	public void testBooksDueOnDate() {
		Library testcases = new Library();
		Book b1=new Book("Harry Potter","J K Rowling",56748,48);
		Book b2=new Book("Hunger Games","Suzanne Collins",35335,35);
		Book b3=new Book("Some Book","some author",78956,35);
		testcases.addBook(b1);
		testcases.addBook(b2);
		testcases.addBook(b3);
		b1.setDueDate("12 20 2010");
		b2.setDueDate("10 24 2008");
		b3.setDueDate("12 20 2010");
		assertEquals(2, testcases.booksDueOnDate("12 20 2010").size());
	}

	@Test(timeout=100)
	public void testLateFee()throws ParseException
	{
		DateFormat format=new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		Date date=(Date)format.parse("Mon Jun 18 00:00:00 IST 2012");
		Date current = new Date();
		Book b=new Book("Title","Auther",4771,100);
		Person p=new Person();
		Library lib=new Library();
		lib.addPerson(p);
		p.addBook(b);
		b.setDueDate(date.toString());
		long diff =current.getTime() - date.getTime();
		long days=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		int isEqual=Double.compare(days*0.01*b.getBookValue(), lib.lateFee(p));
		assertEquals( 0,isEqual);
	}


}

package objects;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;

public class Bookshelf {

	public static void main(String[] args) {
		Person author1 = new Person("Noah", "Webster", true);
		Person author2 = new Person("Anthony", "Burgess", true);
		Person author3 = new Person("George", "R.R", "Martin", true);
		Person author4 = new Person("Philip", "K", "Dick", true);
		
		Book book1 = new Book("Dictionary", 1001, author1);
		Book book2 = new Book("The Clockwork Orange", 749, author2);
		Book book3 = new Book("A Song of Ice and Fire: Game of Thrones", 694, author3);
		
		Person person1 = new Person("Yang", "Xiao", "Long", false);
		Person person2 = new Person("Ruby", "Rose", false);
		Person person3 = new Person("Nora", "Valkyrie", false);
		Person person4 = new Person("Jaune", "Arc", true);
		
		ArrayList<Person> libraryCardHolders = new ArrayList<Person>();
		
		libraryCardHolders.add(person1);
		libraryCardHolders.add(person2);
		libraryCardHolders.add(person3);
		libraryCardHolders.add(person4);
		
		//book2.setOnFire();
		
		ArrayList<Book> shelf = new ArrayList<Book>();
		shelf.add(book1);
		shelf.add(book2);
		shelf.add(book3);
		shelf.add(new Book("Tales of Duncan and Egg: Hedge Knight", 300, author3));
		//Book book4 = new Book("Tales of Duncan and Egg: Hedge Knight", 160, author3);
		//shelf.add(book4);
		Book book5 = new Book("The Minority Report", 589, author4);
		shelf.add(0, book5);
		
		book1.setJacketColor(Color.orange);
		book2.setJacketColor(new Color(140,40,10));
		book3.setJacketColor(Color.blue);
		//book4.setJacketColor(Color.blue);
		book5.setJacketColor(Color.yellow);
		
//		Author and LastName
//		Collections.sort(shelf, new Comparator<Book>() {
//		    public int compare(Book a, Book b) {
//		        //return a.getNumberOfPages() - b.getNumberOfPages();
//		    	String aLast = a.getAuthor().getLastName();
//		    	String bLast = b.getAuthor().getLastName();
//		    	return aLast.compareTo(bLast);
//		        //return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
//		    }
//		});

//Height
		sortByAuthor(true, shelf);
		printAll(shelf); 
		
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		        return a.getHeight() - b.getHeight();
		    }
		});
		
		
		Library lib = new Library(shelf, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 

		lib.setSize(new Dimension(500,500));

		lib.setVisible(true);

		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void sortByAuthor(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		        //return a.getNumberOfPages() - b.getNumberOfPages();
		    	String aLast = a.getAuthor().getLastName();
		    	String bLast = b.getAuthor().getLastName();
		    	if(ascending){
		    		return aLast.compareTo(bLast);
		    	}
		    	return bLast.compareTo(aLast);
		        //return a.getAuthor().getLastName().compareTo(b.getAuthor().getLastName());
		    }
		});
	}
	
	public static void sortByPageNumber(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	if(ascending){
		    		return a.getNumberOfPages() - b.getNumberOfPages();
		    	}
		    	return b.getNumberOfPages() - a.getNumberOfPages();
		    }
		});
	}
	
	public static void sortByHeight(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	if(ascending){
		    		return a.getHeight() - b.getHeight();
		    	}
		    	return b.getHeight() - a.getHeight();
		    }
		});
	}
	
	public static void sortByTitle(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {
		    public int compare(Book a, Book b) {
		    	if(ascending){
		    		return a.getTitle().toString().compareTo(b.getTitle());
		    	}
		    	return b.getTitle().toString().compareTo(a.getTitle());
		    	
		    }
		});
	}
	
	private static void printAll(ArrayList list){
		
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	
	
}

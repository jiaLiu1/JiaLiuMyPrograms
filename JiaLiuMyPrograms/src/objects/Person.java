package objects;

import java.util.ArrayList;


public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	public static int MAX_ALLOWED_BOOKS = 3;
	private ArrayList<Book> checkedOutBooks;
	private Balance balance;
	private boolean male;
	
	//constructor
	//no return type: it "returns"(constructs) a Person
	public Person(String firstName, String lastName, boolean male){
		this.firstName = firstName; //assigns firstName to the fN parameter
		middleName = "";//default middle name
		this.lastName = lastName;//this is used to specify the FIELD,
		this.male=male;
		checkedOutBooks = new ArrayList<Book>();
		balance = new Balance();
		//whereas lastName (by itself) is the local parameter
	}
	
	//constructor for middle-named people
	public Person(String firstName, String middleName, String lastName, boolean male){
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
		this.male=male;
		checkedOutBooks = new ArrayList<Book>();
		balance = new Balance();
	}
	
	public Balance getBalance() {
		return balance;
	}
	
	public boolean isMale() {
		return male;
	}

	public ArrayList<Book> getCheckedOutBooks() {
		return checkedOutBooks;
	}
	
	public String toString(){
		return firstName+" "+middleName+" "+lastName;
	}

	public String getFirstName() {
		return firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public String getLastName() {
		return lastName;
	}
	
	public void checkOutBook(Book Book){
		Book.setCheckedOut(true);
		Book.setCheckOutDate(System.currentTimeMillis()/1000);
		Book.setDueDate(System.currentTimeMillis()+30000);
		checkedOutBooks.add(Book);
	}
	
	public void returnBook(Book Book){
		Book.setCheckedOut(false);
		Book.updateCondition((System.currentTimeMillis())/1000);
		balance.subtractLateFees((int) ((System.currentTimeMillis() - Book.getDueDate())/1000));
		Book.setCheckOutDate(0);
		Book.setDueDate(0);
		checkedOutBooks.remove(Book);
	}
	
	public void renewBook(Book Book){
		Book.setDueDate(System.currentTimeMillis()+30000);
	}
	
	public String getGenderPosessivePronoun(){
		if(male) return "his";
		return "her";
	}
	
	public String getLibraryDescription(){
		return " is thinking of borrowing a book. Their balance amount is: " + balance.getAmount();
	}
}

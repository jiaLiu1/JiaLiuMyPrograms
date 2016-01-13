package objects;
import java.awt.Color;

public class Book {
	//Height 150 - 250
	//Thickness numberOfPages/10
	private String title;
	private int numberOfPages;
	private int height;
	private int thickness;
	private Person author;//custom class in this package
	private Color jacketColor;//class from java.awts
	private boolean wasLitOnFire;
	private boolean checkedOut;
	private long checkOutDate;
	private long dueDate;
	private String description;
	private int accumulatedUse;
	
	static public String[] conditions = {
		"This appears to be a brand new book! How lucky!",
		"This book is very gently used.",
		"This book is used moderatly.",
		"This book is used frequently.",
		"This book is extremly used.",
		"This book is pretty worn.",
		"Just buy a new book. Jeez!"};

	
	public Book(String title, int numOfPages, Person author){
		this.title=title;
		this.numberOfPages=numOfPages;
		this.author=author;
		this.thickness = numOfPages/10;
		height = (int)(Math.random() * 100 + 150);
		jacketColor = Color.gray;
		wasLitOnFire=false;
		checkedOut = false;
		checkOutDate = 0;
		dueDate = 0;
		description = conditions[0];
		accumulatedUse = 0;
	}
	
	public long getSecondsRemaining(){
		return ((dueDate - System.currentTimeMillis())/1000);
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public long getDueDate() {
		return dueDate;
	}

	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	public int getHeight() {
		return height;
	}

	public int getThickness() {
		return thickness;
	}

	public void setJacketColor(Color jacketColor) {
		this.jacketColor = jacketColor;
	}

	public Color getJacketColor() {
		return jacketColor;
	}

	public String toString(){
		if(wasLitOnFire){
			return "\""+ title + "\", by an author you cannot make out. "+ numberOfPages+ " pages" + " has a height of " + height;
		}
		else
			return "\""+ title + "\", by " + author + ". "+ numberOfPages+ " pages" + " has a height of " + height;
	} 

	public String getTitle(){
		return title;
	}

	public int getNumberOfPages(){
		return numberOfPages;
	}

	public Person getAuthor() {
		return author;
	}

	public void setOnFire(){
		jacketColor=Color.black;
		title= "The title of this book too charred to make out.";
		wasLitOnFire=true;

	}

	public int getAccumulatedUse() {
		return accumulatedUse;
	}

	public String getDescription() {
		return description;
	}
	
	public void updateCondition(long timeOfReturn){
		accumulatedUse = (int) (accumulatedUse + (timeOfReturn - checkOutDate));
		if(accumulatedUse > 10) description=conditions[1];
		if(accumulatedUse > 20) description=conditions[2];
		if(accumulatedUse > 30) description=conditions[3];
		if(accumulatedUse > 40) description=conditions[4];
		if(accumulatedUse > 50) description=conditions[5];
		if(accumulatedUse > 70) description=conditions[6];
	}
}


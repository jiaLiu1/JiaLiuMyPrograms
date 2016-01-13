package objects;

import java.util.ArrayList;

//
///**
// * "<Book>" or "<?>" is a generic type. 
// *  It tells the constructor WHAT is in the ArrayList. 
// *  We use generics to save ourselves the trouble of type casting.
// * "new ArrayList<?>()" constructor does not need to specify
// *  length. (Default is 10, but it doesn't matter, it adjusts
// *  as you add objects to it)
// *  not that ArrayList IS indexed (item 0 is always at index 0, item 1 is always at index 1
// *  and so on) You can iterate through it.
// *  You cannot make an ArrayList of primitives (no int, boolean. etc)
// *  IF you wish to make an ArrayList of ints, you use the wrapper class
// *  int is Integer, double is Double, etc.
// */
////add things to an ArrayList (remember, for arrays, we did:
////array[0] = book1;//specify index
//shelf.add(book1);
////does not specify index, book1 is automatically index 0
//shelf.add(book2);
//shelf.add(book3);
////you can construct at the same time:
//shelf.add(new Book("Tales of Duncan and Egg: Hedge Knight", 160, author3));
//
////to get something form ArrayList (recall to get something from array:
////System.out.println(array[0])
//System.out.println("The first book on the shelf is "+ shelf.get(0));//Lose points if you do this wrong!!
////iterate through an ArrayList, using for-each:
//System.out.println("\nUsing a standard for-each loop:");
//for(Book b:shelf){
//	System.out.println(b);
//}
//
////adding Objects at specified indices
//Book book5 = new Book("The Minority Report", 589, author4);
//shelf.add(0, book5);
////shelf.remove(4);
////shelf.remove(book1);
////task: remove all books with the word "The" in the title
////for(int i = 0; i < shelf.size(); i++){
////	//while(shelf.get(i).toString().indexOf("The") >= 0){
////	while(shelf.get(i).toString().toLowerCase().contains("the")){
////	//while(1<shelf.size && shelf.get(i).getTitle().indexOf("The")>-1)shelf.remove(i);
////		shelf.remove(i);
////	}
////}		
//
////to get the length of ArrayList
////recall using arrays:
////array.length
//System.out.println("The length (size) of the shelf is " + shelf.size() + " books"); //Lost points if you do this wrong!!
////iterate through an ArrayList, using standard loop:
//System.out.println("\nUsing a standard for loop:");
//for(int i = 0; i<shelf.size(); i++){
//	System.out.println(shelf.get(i));
//}
////Identifying whether or not an Object is in the list
////getting the index of an Object in an ArrayList
//if(shelf.contains(book2)){
//	System.out.println(book2.getTitle() + " is book #" + shelf.indexOf(book2) + " on the shelf.");
//}
//
//ArrayList<Book> creepyBooks = new ArrayList<Book>();
//for(Book b:shelf){
//	if(b.getAuthor().toString().equals("Philip K Dick")){
//		creepyBooks.add(b);
//		b.setOnFire();
//	}
//}
//
//System.out.println("\nThe books in the creepy collection includes Philip K Dick");
//printAll(creepyBooks);
//
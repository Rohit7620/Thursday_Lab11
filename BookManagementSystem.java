package BooksManage;
import java.util.*;

//Book class to represent a book with title and author
class Book 
{
	   
	 private String title;
	 private String author;
	 private float price;
	
	 public Book(String title, String author , float price) 
		 {
		     this.title = title;
		     this.author = author;
		     this.price = price;
		 }
	
	 public String getTitle() 
		 {
		     return title;
		 }
	
	 public String getAuthor()
		 {
		     return author;
		 }
	 public void setAuthor(String author)
		 {
		     this.author = author;
		 }
	 public float getPrice()
		 {
		     return price;
		 }
	 public void setprice(float price)
	 {
	     this.price = price;
	 }
	
	 
	
	 @Override
	 public String toString() 
		 {
		     return "Book{" +"title='" + title + '\'' +", author='" + author + '\'' +", price='" + price + '\'' +'}';
		 }
}

public class BookManagementSystem
{
	 private Map<String, Book> books;  // Collection to store books
	 Scanner scan = new Scanner(System.in);          // Scanner for user input
	
	 // Constructor initializes the collection and scanner
	 public BookManagementSystem() 
	 {
	     this.books = new HashMap<>();
	     this.scan = new Scanner(System.in);
	 }
	
	 // Method to add a new book based on user input
	 public void addBook() 
	 {
	     System.out.println("Enter book title:");
	     String title = scan.nextLine();
	
	     System.out.println("Enter author name:");
	     String author = scan.nextLine();
	     
	     System.out.println("Enter Book Price:");
	     float price = scan.nextFloat();
	
	     Book book = new Book(title, author , price);
	     books.put(title, book);
	     System.out.println("Book added: " + book);
	 }
	
	 // Method to update a book's author based on user input
	 public void updateBook() 
	 {
	     System.out.println("Enter book title to update:");
	     String title = scan.nextLine();
	     
	
	     if (books.containsKey(title)) 
	     {
	         System.out.println("Enter new author name:");
	         String newAuthor = scan.nextLine();
	         
	         System.out.println("Enter new price:");
	         float newprice = scan.nextFloat();
	
	         Book book = books.get(title);
	         book.setAuthor(newAuthor);
	         book.setprice(newprice);
	         System.out.println("Book updated: " + book);
	        
	     } 
	     else 
	     {
	         System.out.println("Book not found with title: " + title);
	     }
	 }
	
	 // Method to delete a book based on user input
	 public void deleteBook() 
	 {
	     System.out.println("Enter book title to delete:");
	     String title = scan.nextLine();
	
	     if (books.containsKey(title)) 
	     {
	         Book book = books.remove(title);
	         System.out.println("Book deleted: " + book);
	     } 
	     else 
	     {
	         System.out.println("Book not found with title: " + title);
	     }
	 }
	
	 // Method to display all books in the collection
	 public void displayBooks() 
	 {
	     System.out.println("Books in the collection:");
	     	for (Book book : books.values()) 
		     {
		         System.out.println(book);
		     }
	 }
	
	 public static void main(String[] args) 
	 {
	     BookManagementSystem bookSystem = new BookManagementSystem();
	     Scanner scanner = new Scanner(System.in);
	
	     int choice;
	     do 
	     {
	         // Display menu to the user
	         System.out.println("\nBook Management System");
	         System.out.println("1. Add Book");
	         System.out.println("2. Update Book");
	         System.out.println("3. Delete Book");
	         System.out.println("4. Display Books");
	         System.out.println("5. Exit");
	         System.out.println("Enter your choice:");
	
	         choice = scanner.nextInt();
	         scanner.nextLine(); // Consume the newline
	
	         switch (choice) 
	         {
	             case 1:
	                 bookSystem.addBook();
	                 break;
	             case 2:
	                 bookSystem.updateBook();
	                 break;
	             case 3:
	                 bookSystem.deleteBook();
	                 break;
	             case 4:
	                 bookSystem.displayBooks();
	                 break;
	             case 5:
	                 System.out.println("Exiting the application. Goodbye!");
	                 break;
	             default:
	                 System.out.println("Invalid choice. Please enter a valid option.");
	         }
	
	     } while (choice != 5);
	
	     scanner.close();
	 }
}

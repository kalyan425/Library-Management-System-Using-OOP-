package library_management_system;


import java.util.*;

abstract class Item { // Abstraction
    String title;
    String author;
    boolean isIssued;

    Item(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    abstract void displayInfo(); // Abstract method
}

class Book extends Item { // Inheritance
    int bookId;

    Book(int bookId, String title, String author) {
        super(title, author);
        this.bookId = bookId;
    }

    @Override
    void displayInfo() { // Polymorphism
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author +
                ", Issued: " + (isIssued ? "Yes" : "No"));
    }
}

class User {
    String name;
    int userId;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.title);
    }

    void issueBook(int bookId) {
        for (Book b : books) {
            if (b.bookId == bookId && !b.isIssued) {
                b.isIssued = true;
                System.out.println("Book issued: " + b.title);
                return;
            }
        }
        System.out.println("Book not available!");
    }

    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.bookId == bookId && b.isIssued) {
                b.isIssued = false;
                System.out.println("Book returned: " + b.title);
                return;
            }
        }
        System.out.println("Invalid return attempt!");
    }

    void showAllBooks() {
        for (Book b : books) b.displayInfo();
    }
}
public class LibrarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Library library = new Library();

	        Book b1 = new Book(101, "Java Basics", "James Gosling");
	        Book b2 = new Book(102, "Python Guide", "Guido van Rossum");

	        library.addBook(b1);
	        library.addBook(b2);

	        library.showAllBooks();
	        library.issueBook(101);
	        library.returnBook(101);

	}

}

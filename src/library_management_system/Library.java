package library_management_system;

import java.util.ArrayList;

public class Library {

	private ArrayList<Book> books;

	public Library() {
		books = new ArrayList<Book>();
	}

	public void addBooks(Book book) {
		books.add(book);
		System.out.println("Book added to library.");
	}

	public void checkOutBook(Book book, LibraryMember member) {
		Book bk = null;
		for (int i = 0; i < books.size(); i++) {
			if (book.equals(books.get(i)) && books.get(i).isAvailable()) {
				bk = books.get(i);
				books.get(i).setAvailable(false);
				break;
			}
		}
		if (bk == null) {
			System.out.println("Book is not available.");
		} else {
			System.out.println("Book checked out by " + member.getName() + ".");
		}
	}

	public void returnBook(Book book) {
		Book bk = null;
		for (int i = 0; i < books.size(); i++) {
			if (book.equals(books.get(i)) && !books.get(i).isAvailable()) {
				bk = books.get(i);
				books.get(i).setAvailable(true);
				break;
			}
		}
		if (bk == null) {
			System.out.println("Book already returned.");
		} else {
			System.out.println("Returned book successfuly.");
		}
	}

	public Book getBook(String input) {
		Book book = null;
		for (int i = 0; i < books.size(); i++) {
			if (input.equals(books.get(i).getAuthor()) || input.equals(books.get(i).getISBN())
					|| input.equals(books.get(i).getTitle())) {
				book = books.get(i);
				continue;
			}
		}
		if (book == null) {
			throw new NullPointerException("Book not found.");
		}
		return book;
	}

	public void displayAvailableBooks() {
		if (books.isEmpty()) {
			System.out.println("Library is empty");
		} else {
			for (Book book : books) {
				if (book.isAvailable()) {
					System.out.println(book.toString() + ", Available");
				}
			}
		}
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

}

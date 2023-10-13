package library_management_system;

public class Book {

	private String title;
	private String author;
	private String ISBN;
	private boolean isAvailable;

	public Book(String title, String author, String ISBN, boolean isAvailable) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.isAvailable = isAvailable;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "[Title: " + title + ", author: " + author + ", ISBN: " + ISBN + "]";
	}

}

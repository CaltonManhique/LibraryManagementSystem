package library_management_system;

import java.io.IOException;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

public class LibraryFactory {

	private String fileName = "library.csv";

	private Scanner scanner = new Scanner(System.in);
	private Library library = new Library();
	private FileReaderAndWriter fir = new FileReaderAndWriter();

	public void runApp() {
		try {
			library.setBooks(fir.fileReader(fileName));
		} catch (IOException | CsvValidationException e) {

		}

		int option = 0;
		do {
			System.out.println("1. Add book" + "\n" + "2. Checkout book" + "\n" + "3. Return book" + "\n"
					+ "4. Display available books" + "\n" + "5. Save and Exit" + "\n");
			option = scanner.nextInt();
			scanner.nextLine(); // To clear the Buffer
			switch (option) {
			case 1 -> {
				System.out.println("Enter a book title:");
				String title = scanner.nextLine();
				System.out.println("Enter a book author:");
				String author = scanner.nextLine();
				System.out.println("Enter a book ISBN:");
				String isbn = scanner.nextLine();
				Book book = new Book(title, author, isbn, true);
				library.addBooks(book);
				try {
					fir.fileWriter(book, fileName);
					library.setBooks(fir.fileReader(fileName));
				} catch (IOException | CsvValidationException e) {
					e.printStackTrace();
				}
			}
			case 2 -> {
				System.out.println("Enter title, author or ISBN to checkout");
				String searchWord = scanner.nextLine();
				try {
					library.checkOutBook(library.getBook(searchWord), new LibraryMember("Gunter", "gunter@library.de"));
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}
			}
			case 3 -> {
				System.out.println("Enter title, author or ISBN to checkout");
				String searchWord = scanner.nextLine();
				try {
					library.returnBook(library.getBook(searchWord));
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}
			}
			case 4 -> library.displayAvailableBooks();
			case 5 -> {
				try {
					fir.updateFile(library.getBooks(), fileName);
				} catch (IOException e) {
				}
				option = 0;
				System.out.println("***** Library closed *****");
			}
			default -> System.out.println("Invalid option number!!");
			}

		} while (option != 0);

		scanner.close();
	}
}

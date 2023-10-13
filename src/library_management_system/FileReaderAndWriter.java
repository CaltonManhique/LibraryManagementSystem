package library_management_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

public class FileReaderAndWriter {

	private static String pathName = "Directory/";

	// Not very efficient because writes byte per byte
	public void saveBookIntoFile(Book book, String fileName) throws IOException {
		FileOutputStream file = new FileOutputStream(pathName + fileName, true);

		String[] bk = { book.getTitle(), book.getAuthor(), book.getISBN(), String.valueOf(book.isAvailable()) };

		for (String str : bk) {
			byte[] b = (str + ", ").getBytes();
			file.write(b);
		}
		file.write('\n');
		file.close();
	}

	// Not very efficient because reads byte per byte
	public ArrayList<Book> readBookFromFile() throws IOException {

		ArrayList<Book> arr = new ArrayList<Book>();

		FileInputStream file = new FileInputStream("Directory/library.csv");

		int n = 0;
		while ((n = file.read()) != -1) {
			System.out.print((char) n);
		}

		file.close();

		return arr;
	}

	public void fileWriter(Book book, String fileName) throws IOException {
		File file = new File(fileName);

		FileWriter outputFile = new FileWriter(pathName + file, true);

		CSVWriter writer = new CSVWriter(outputFile);

		String[] data = { book.getTitle(), book.getAuthor(), book.getISBN(), String.valueOf(book.isAvailable()) };
		writer.writeNext(data);

		writer.close();
	}

	public ArrayList<Book> fileReader(String fileName) throws IOException, CsvValidationException {
		ArrayList<Book> arr = new ArrayList<Book>();

		FileReader inputFile = new FileReader(pathName + fileName);

		CSVReader reader = new CSVReader(inputFile);
		String[] nextLine;

		while ((nextLine = reader.readNext()) != null) {
			Book book = new Book(nextLine[0], nextLine[1], nextLine[2], Boolean.parseBoolean(nextLine[3]));
			arr.add(book);
		}

		reader.close();

		for (Book b : arr)
			System.out.println(b);
		return arr;
	}

	// Updates the file overwritng all data in the file
	public void updateFile(ArrayList<Book> books, String fileName) throws IOException {
		ArrayList<String[]> arr = new ArrayList<String[]>();
		File file = new File(fileName);

		FileWriter outputFile = new FileWriter(pathName + file);

		CSVWriter writer = new CSVWriter(outputFile);

		for (Book book : books) {
			String[] data = { book.getTitle(), book.getAuthor(), book.getISBN(), String.valueOf(book.isAvailable()) };
			arr.add(data);
		}
		writer.writeAll(arr);

		writer.close();
	}
}

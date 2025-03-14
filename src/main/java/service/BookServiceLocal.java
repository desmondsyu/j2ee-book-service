package service;

import java.util.List;

import jakarta.ejb.Stateless;
import model.Book;

public interface BookServiceLocal {
	void addBook(Book book);
	
	List<Book> listBooks();
}

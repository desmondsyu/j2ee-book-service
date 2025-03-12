package service;

import java.util.List;

import model.Book;

public interface BookServiceLocal {
	void addBook(Book book);
	
	List<Book> listBooks();
}

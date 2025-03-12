package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.ejb.Stateless;
import model.Book;
import service.BookServiceLocal;

@Stateless
public class BookServiceBean implements BookServiceLocal {
	private Map<String, Book> books = new ConcurrentHashMap<String, Book>();

	public void addBook(Book book) {
		books.put(book.getIsbn(), book);
	}

	public List<Book> listBooks() {
		return new ArrayList<>(books.values());
	}
}

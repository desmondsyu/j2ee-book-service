package controller;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import model.Book;
import service.BookServiceLocal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Named
@RequestScoped
public class BookManager {

    @Inject
    private BookServiceLocal cdiBookService;

    private BookServiceLocal jndiBookService;

    @PostConstruct
    public void init() {
        try {
            Context ctx = new InitialContext();
            jndiBookService = (BookServiceLocal) ctx.lookup("java:module/BookServiceBean!service.BookServiceLocal");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public void addBookUsingCDI(Book book) {
        cdiBookService.addBook(book);
    }

    public void addBookUsingJNDI(Book book) {
        jndiBookService.addBook(book);
    }

    public List<Book> getBooks() {
        return cdiBookService.listBooks();
    }
}

package servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Book;

import java.io.IOException;
import java.util.List;

import controller.BookManager;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private BookManager bookManager;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("list")) {
            List<Book> books = bookManager.getBooks();
            request.setAttribute("books", books);
            request.getRequestDispatcher("/WEB-INF/views/listBooks.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("add")) {
            request.getRequestDispatcher("/WEB-INF/views/addBook.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        String method = request.getParameter("method");

        Book book = new Book(isbn, title, author, price);

        if (method.equalsIgnoreCase("cdi")) {
            bookManager.addBookUsingCDI(book);
        }
		else if(method.equalsIgnoreCase("jndi")) {
			bookManager.addBookUsingJNDI(book);
		}

        response.sendRedirect(request.getContextPath() + "/BookServlet?action=list");
    }

}

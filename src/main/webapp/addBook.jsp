<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add book</title>
    </head>
    <body>
        <form>
            <input type="hidden" name="method" value="cdi" />
            <input type="text" name="isbn" placeholder="ISBN" required/>
            <input type="text" name="title" placeholder="Title" required/>
            <input type="text" name="author" placeholder="Author" required/>
            <input type="number" name="price" placeholder="Price" required/>
            <button type="submit">Add Book Using CDI</button>
        </form>
        <a href="book?action=list">View Book List</a>
    </body>
</html>
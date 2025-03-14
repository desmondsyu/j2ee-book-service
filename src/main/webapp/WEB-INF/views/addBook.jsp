<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/BookServlet">
    <h1>CDI Create</h1>
    <input type="hidden" name="method" value="cdi"/>
    <input type="text" name="isbn" placeholder="ISBN" required/>
    <input type="text" name="title" placeholder="Title" required/>
    <input type="text" name="author" placeholder="Author" required/>
    <input type="number" name="price" placeholder="Price" required/>
    <button type="submit">Add Book Using CDI</button>
</form>
<form method="post" action="${pageContext.request.contextPath}/BookServlet">
    <h1>JNDI Create</h1>
    <input type="hidden" name="method" value="jndi"/>
    <input type="text" name="isbn" placeholder="ISBN" required/>
    <input type="text" name="title" placeholder="Title" required/>
    <input type="text" name="author" placeholder="Author" required/>
    <input type="number" name="price" placeholder="Price" required/>
    <button type="submit">Add Book Using JNDI</button>
</form>
<a href="${pageContext.request.contextPath}/BookServlet?action=list">View Book List</a>
</body>
</html>
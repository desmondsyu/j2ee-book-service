<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
</head>
<body>
<h2>Book list</h2>
<c:forEach var="book" items="${books}">
    <p>${book.title} by ${book.author} - $${book.price}</p>
</c:forEach>
<a href="${pageContext.request.contextPath}/BookServlet?action=add">Add New Book</a>
</body>
</html>
<%@include file="taglib.jsp"%>
<html>
<c:import url="head.jsp"/>
<body>
<c:import url="topbar.jsp"/>

<div class="container-fluid">
    <h2>Your Bookshelf:</h2>
    <form action="searchBook" method="get" class="form-inline" id="searchForm">
        <input type="text" id="searchBookTitle" name="searchBookTitle" placeholder="Search a book title...">
        <button type="submit" name="submit" value="search">Search</button>
        <a href="addBook.jsp" >Add Book</a>
    </form>
    <table>
        <thead>
        <th>Title:</th>
        <th>Summary:</th>
        <th>Series:</th>
        <th></th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.summary}</td>
                <td>${book.series}</td>
                <td>
                    <form action="bookDetails" name="bookDetails" method="GET">
                        <input type="hidden" id="bookId" name="bookId" value="${book.id}">
                        <button type="submit" name="submit" value="bookDetails">Show Details</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
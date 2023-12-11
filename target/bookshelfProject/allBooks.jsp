<%@include file="taglib.jsp"%>
<html>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>Bookshelf - Your own personal library!</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">


    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/allBooks.css" rel="stylesheet">
</head>

<body>
<c:import url="topbar.jsp"/>

<div id="personalBookshelf"><br><br>
    <div id="secondaryNav">
        <form action="searchBook" method="get" class="form-inline" class="searchForm">
            <input type="text" id="searchBookTitle" name="searchBookTitle" placeholder="Search a book title...">
            <button type="submit" name="submit" value="search" >Search</button>
        </form>
        <div id="addBookButton">
            <a href="addBook.jsp" >Add Book</a>
        </div>
    </div>

    <table class="displayTable">
        <thead>
        <th>Title:</th>
        <th>Summary:</th>
        <th>Series:</th>
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
                        <button type="submit" name="submit" value="bookDetails" id="detailsButton">Show Details</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
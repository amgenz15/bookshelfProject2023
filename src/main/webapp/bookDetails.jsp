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
    <link href="css/bookDetails.css" rel="stylesheet">
</head>

<body>
<c:import url="topbar.jsp"/>
<div id="bookDetails">
    <div>
        <div>
            <div>
                <h2>${book.title}</h2>
            </div>
            <div>
                <h4>Book Information:</h4>
                <p>Genre: ${book.genre}</p>
                <p>Series: ${book.series}</p>
            </div>
            <div>
                <h4>Summary:</h4>
                <p>${book.summary}</p>
            </div>
        </div>
    </div>
    <div>
        <h4>Author:</h4>
        <p>${book.author.firstName} ${book.author.middleName} ${book.author.lastName}</p>
        <p>${book.author.about}</p>
    </div>

    <div>
        <form action="deleteBook" name="deleteBook" method="GET">
            <input type="hidden" id="bookId" name="bookId" value="${book.id}">
            <button type="submit" name="submit" value="deleteBook" id="delete">Delete</button>
        </form>
        <form action="editBook" name="editBook" method="GET">
            <input type="hidden" id="book" name="book" value="${book.id}">
            <button type="submit" name="submit" value="editBook">Edit Book</button>
        </form>
    </div>
</div>
</body>
</html>
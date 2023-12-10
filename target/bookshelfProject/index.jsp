<%@include file="taglib.jsp"%>
<html>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>Bookshelf - Your own personal library!</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
</head>

<body>
<c:import url="topbar.jsp"/>
<div id="aboutInfo">
    <h2>Welcome to Bookshelf</h2>
    <p>Welcome to Bookshelf where you will create your own library custom to you! To get started click on My Bookshelf. </p><br><br>
    <a href="displayBooks" id="displayBookButton">Browse All Books</a><br><br><br>
    <p>In this website you will be able to customize your Bookshelf by adding, updating, deleting and editing books on your Bookshelf. </p>

    <h2>Have too many books you want to read?</h2>
    <p>No problem we have also created a search function, so you can quickly search a book by the title and read more about it when you click
        on book details. </p>

    <h2>What if there is a series of book I want to read but I don't remember the order to read them in?</h2>
    <p>To keep this simple for our users we allow them to track the order of books using the series #. For example the first book in the series
        will have a 1, then the second book will have a 2 and so on. If a book is not a part of a series there will be a 0. </p>

    <h2>What if I want to know more about a book?</h2>
    <p>No worries! You can see each book summary right on your Bookshelf. To get information on the author you will need to click on the
        'book details' button and there you will see the authors name and their about information. </p>
</div>
</body>
</html>

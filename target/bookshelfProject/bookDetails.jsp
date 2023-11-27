<%@include file="taglib.jsp"%>
<html>
<body role="document">
<div>
    <div>
        <div>
            <h3>${book.title}</h3>
        </div>
        <div>
            <h5>Book Information:</h5>
            <p>Genre: ${book.genre}</p>
            <p>Series: ${book.series}</p>
        </div>
        <div>
            <h5>Summary</h5>
            <p>${book.summary}</p>
        </div>

    </div>
</div>
<div>
    <h5>Author</h5>
    <p>${book.author.firstName} ${book.author.middleName} ${book.author.lastName}</p>
    <p>${book.author.about}</p>
</div>

<div>
    <form action="deleteBook" name="deleteBook" method="GET">
        <input type="hidden" id="bookId" name="bookId" value="${book.id}">
        <button type="submit" name="submit" value="deleteBook">Delete</button>
    </form>
</div>
</body>
</html>
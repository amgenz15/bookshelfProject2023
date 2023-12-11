<%@include file="taglib.jsp"%>
<html>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>Bookshelf - Your own personal library!</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
</head>

<body>
<c:import url="topbar.jsp"/>
<div id="addBookContainer">
<div>
    <h1 class="display-5">Add a book to your bookshelf!</h1>
</div>
    <form action="editBook" method="post" class="form-inline" id="addForm">
        <input type="hidden" id="bookId" name="bookId" value="${bookId}">

        <label for="bookTitle" class="text-dark">Book Title:</label>
        <input type="text" id="bookTitle" class="form-control bg-light border-0 px-4" name="bookTitle" value="${title}">

        <label for="summary">Summary:</label>
        <textarea id="summary" name="summary" rows="10" cols="190">${summary}</textarea>

        <label for="series" class="text-dark">Series (Book place in the series, if not in series just submit a 0):</label>
        <input type="number" id="series" class="form-control bg-light border-0 px-4" name="series" value="${series}">

        <label for="genre" class="text-dark">Genre:</label>
        <input type="text" id="genre" class="form-control bg-light border-0 px-4" name="genre" value="${genre}">

        <label for="authorFirstName" class="text-dark">Author's First Name:</label>
        <input type="text" id="authorFirstName" class="form-control bg-light border-0 px-4" name="authorFirstName" value="${authorFirstName}">

        <label for="authorMiddleName" class="text-dark">Author's Middle Name:</label>
        <input type="text" id="authorMiddleName" class="form-control bg-light border-0 px-4" name="authorMiddleName" value="${authorMiddleName}">

        <label for="authorLastName" class="text-dark">Author's Last Name:</label>
        <input type="text" id="authorLastName" class="form-control bg-light border-0 px-4" name="authorLastName" value="${authorLastName}">

        <label for="authorAbout">Author's About Information:</label>
        <textarea id="authorAbout" name="authorAbout" rows="10" cols="190">${authorAbout}</textarea>

        <button class="btn btn-secondary w-100 py-3" type="submit" name="submit" value="editBook">Update Book</button>
    </form>
</div>
</div>

</body>
</html>
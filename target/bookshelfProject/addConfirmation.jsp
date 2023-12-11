<%@include file="taglib.jsp"%>
<html>

<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>Bookshelf - Your own personal library!</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/confirmation.css" rel="stylesheet">
</head>

<body>
<c:import url="topbar.jsp"/>
<div class="congratulations">
    <h1>Yay! You have added a book! </h1>

    <a href="displayBooks" class="allBooks">Return to see all books</a>
</div>
</body>
</html>
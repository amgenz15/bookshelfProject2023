<%@include file="taglib.jsp"%>
<html>
<body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <table>
        <thead>
        <th>Title:</th>
        <th>Summary:</th>
        <th>Series:</th>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.title}</td>
                <td>${book.summary}</td>
                <td>${book.series}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
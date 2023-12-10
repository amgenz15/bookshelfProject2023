<%@include file="taglib.jsp"%>
<html>

<c:import url="head.jsp"/>
<body>
<c:import url="topbar.jsp"/>
<div class="container-fluid py-5">
    <div class="container">
        <div class="mx-auto text-center mb-5" style="max-width: 500px;">
            <h1 class="display-5">Add a book to your bookshelf!</h1>
        </div>
        <div class="row g-0">
            <div class="col-lg-12 mx-auto text-center mb-5">
                <div class="bg-primary  p-5 mx-auto text-center mb-5">
                    <form action="addBook" method="post" class="form-inline" id="addForm">
                        <div class="row g-3">
                            <div class="col-6">
                                <label for="bookTitle" class="text-dark">Book Title:</label>
                                <input type="text" id="bookTitle" class="form-control bg-light border-0 px-4" name="bookTitle" placeholder="Book Title" style="height: 55px;">
                            </div>
                            <div class="col-3">
                                <label for="summary" class="text-dark">Summary:</label>
                                <input type="text" id="summary" class="form-control bg-light border-0 px-4" name="summary" placeholder="Book Summary" style="height: 55px;">
                            </div>
                            <div class="col-3">
                                <label for="series" class="text-dark">Series (Book place in the series, if not in series just submit a 0):</label>
                                <input type="number" id="series" class="form-control bg-light border-0 px-4" name="series" placeholder="0" style="height: 55px;">
                            </div>
                            <div class="col-3">
                                <label for="genre" class="text-dark">Genre:</label>
                                <input type="text" id="genre" class="form-control bg-light border-0 px-4" name="genre" placeholder="Genre" style="height: 55px;">
                            </div>
                            <div class="col-3">
                                <label for="authorFirstName" class="text-dark">Author's First Name:</label>
                                <input type="text" id="authorFirstName" class="form-control bg-light border-0 px-4" name="authorFirstName" placeholder="First Name" style="height: 55px;">
                            </div>
                            <div class="col-6">
                                <label for="authorMiddleName" class="text-dark">Author's Middle Name:</label>
                                <input type="text" id="authorMiddleName" class="form-control bg-light border-0 px-4" name="authorMiddleName" placeholder="Middle Name" style="height: 55px;">
                            </div>
                            <div class="col-3">
                                <label for="authorLastName" class="text-dark">Author's Last Name:</label>
                                <input type="text" id="authorLastName" class="form-control bg-light border-0 px-4" name="authorLastName" placeholder="Last Name" style="height: 55px;">
                            </div>
                            <div class="col-3">
                                <label for="authorAbout" class="text-dark">Author's About:</label>
                                <input type="text" id="authorAbout" class="form-control bg-light border-0 px-4" name="authorAbout" placeholder="Author's About Information" style="height: 55px;">
                            </div>

                            <div class="col-3 mx-auto text-center mb-5" >
                                <button class="btn btn-secondary w-100 py-3" type="submit" name="submit" value="addBook">Add Book</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
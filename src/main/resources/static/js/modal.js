function openModal(bookId = null) {
    if (bookId) {
    //Edit function
    fetch('/books/' + bookId)
        .then(response => {
            if(!response.ok) {
                throw new Error('Failed to fetch book details');
            }
            return response.json();
        })
        .then(book => {
            document.getElementById("title").value = book.title;
            document.getElementById("author").value = book.author;
            document.getElementById("pages").value = book.pages;
            document.getElementById("publicationYear").value = book.publicationYear;
            document.getElementById("coverUrl").value = book.coverUrl;
            document.getElementById("genre").value = book.genre;
            document.getElementById("isOwned").checked = book.isOwned;

            document.getElementById("modalTitle").innerText = "Edit Book details";
            document.getElementById("modalButton").innerText = "Save Changes";

            $('#myModal').modal('show');
        })
        .catch(error => {
            console.error('Error: ', error);
        });
    } else {
        document.getElementById("title").value = "";
        document.getElementById("author").value = "";
        document.getElementById("pages").value = "";
        document.getElementById("coverUrl").value = "";
        document.getElementById("publicationYear").value = "";
        document.getElementById("genre").value = "";
        document.getElementById("isOwned").checked = "";

        $('#myModal').modal('show');
    }
}

function closeModal() {
    document.getElementById("myModal").style.display = "none";
}

function submitForm() {
    var title = document.getElementById("title").value;
    var author = document.getElementById("author").value;
    var pages = document.getElementById("pages").value;
    var coverUrl = document.getElementById("coverUrl").value;
    var publicationYear = document.getElementById("publicationYear").value;
    var genre = document.getElementById("genre").value
    var isOwned = document.getElementById("isOwned").checked;

    var formData = {
        title: title,
        author: author,
        pages: pages,
        coverUrl: coverUrl,
        publicationYear: publicationYear,
        genre: genre,
        isOwned: isOwned
    };

    //Which endpoint?
    var endpoint = bookId ? '/books/' + bookId : '/books';

    fetch(endpoint, {
        method: bookId ? 'PUT' : 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to ' + (bookId ? 'edit' : 'add') + ' book');
        }
        closeModal();
        window.location.href = window.location.href;
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
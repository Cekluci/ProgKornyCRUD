var bookId;

function editBook(id) {
    bookId = id;
    openModal(bookId);
}

function deleteBook(bookId) {
    if (confirm("Are you sure you want to delete this book?")) {
        fetch('/books/' + bookId, {
            method: 'DELETE'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to delete book.');
            }
            location.reload();
        })
        .catch(error => {
            console.error('Error: ', error);
        });
    }
}


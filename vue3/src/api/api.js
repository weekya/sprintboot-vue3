const userUrl = "user"
const bookUrl = "book"
const borrowUrl = "borrow"
const urls = class{
    static method(){
        const register = `${userUrl}/Register`
        const login = `${userUrl}/Login`
        const allBook = `${bookUrl}`
        const findBookByTitle = `${bookUrl}/findByTitle`
        const findBookByAuthor = `${bookUrl}/findByAuthor`
        const findBookByIsbn = `${bookUrl}/findByIsbn`
        const findBookByPublisher = `${bookUrl}/findByPublisher`
        const insertBook = `${bookUrl}/insert`
        const updateBook = `${bookUrl}/update`
        const deleteBook = `${bookUrl}/delete`
        const allBorrow = `${borrowUrl}/allBorrow`
        const insertBorrow = `${borrowUrl}/insert`
        const deleteBorrow = `${borrowUrl}/delete`
        return {
            register,
            login,
            allBook,
            findBookByPublisher,
            findBookByIsbn,
            findBookByAuthor,
            findBookByTitle,
            insertBook,
            updateBook,
            deleteBook,
            allBorrow,
            insertBorrow,
            deleteBorrow
        }
    }
}

export default urls
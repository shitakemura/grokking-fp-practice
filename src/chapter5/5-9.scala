// 5.9

case class Book(title: String, authors: List[String])
case class Movie(title: String)

def bookAdaptations(author: String): List[Movie] =
    if (author == "Tolkien")
        List(Movie("An Unexpected Journey"), Movie("The Desolation of Smaug"))
    else List.empty

val books = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien")))

val movies = books.flatMap(_.authors).flatMap(bookAdaptations)

// 5.10
val response = books.flatMap(book =>
        book.authors.flatMap(author =>
            bookAdaptations(author).map(movie => 
                ???
            )    
        )
    )

val resA = List(1, 2, 3).flatMap(a => List(a * 2)).flatMap(b => List(b, b + 10))

// 5.11

def recommendationFeed(books: List[Book]) = {
    books.flatMap(book =>
        book.authors.flatMap(author =>
            bookAdaptations(author).map(movie =>
                s"You may like ${movie.title}, " +
                s"because you liked $author's ${book.title}"    
            )    
        )    
    )
}

val resFeed = recommendationFeed(books)
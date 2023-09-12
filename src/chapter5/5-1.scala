// 5.1

case class Book(title: String, authors: List[String])

val books = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien")),
)

val res = books.map(_.title).filter(_.contains("Scala")).size

// 5.2

case class Movie(title: String)

def bookAdaptations(author: String): List[Movie] = {
    if (author == "Tolkien")
        List(Movie("An Unexpected Journey"), Movie("The Desolation of Smaug"))
    else List.empty
}

def recommendationFeed(books: List[Book]) = ???

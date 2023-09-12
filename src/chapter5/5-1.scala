// 5.1

case class Book(title: String, authors: List[String])

val books = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien")),
    Book("Modern Java in Action", List("Urma", "Fusco", "Mycroft"))
)

val res = books.map(_.title).filter(_.contains("Scala")).size
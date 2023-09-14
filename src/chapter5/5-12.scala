// 5.12

case class Point(x: Int, y: Int)

val res12 = List(1).flatMap(x =>
    List(-2, 7).map(y =>
        Point(x, y)   
    )    
)

// 5.13

// for内包表記

val res13 = for {
    book <- books
    author <- book.authors
    movie <- bookAdaptations(author)
} yield s"You may like ${movie.title}, " + s"because you liked $author's ${book.title}"

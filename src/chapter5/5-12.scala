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

// 5.15

val xs = List(1)
val ys = List(-2, 7)

val res15a = xs.flatMap(x =>
    ys.map(y =>
        Point(x, y)    
    )    
)

case class Point3d(x: Int, y: Int, z: Int)

val zs = List(3, 4)

val res15b = for {
    x <- xs
    y <- ys
    z <- zs
} yield Point3d(x, y, z)

val res15c = xs.flatMap(x =>
    ys.flatMap(y =>
        zs.map(z =>
            Point3d(x, y, z)
        )    
    )    
)
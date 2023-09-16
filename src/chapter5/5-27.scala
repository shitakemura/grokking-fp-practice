// 5.27

val res27_1 = for {
    greeting <- Set("Hello", "Hi there")
    name <- Set("Alice", "Bob")
} yield s"$greeting, $name!"

val res27_2 = for {
    a <- Set(1, 2)
    b <- Set(2, 1)
} yield a * b

// 5.28

val res28_1 = for {
    a <- List(1, 2)
    b <- Set(2, 1)
} yield a * b

val res28_2 = for {
    a <- Set(2, 1)
    b <- List(2, 1)
} yield a * b

// 5. 29

val res29_1 = for {
    x <- List(1, 2, 3)
    y <- Set(1)
} yield x * y

val res29_2 = for {
    x <- Set(1, 2, 3)
    y <- List(1)
} yield x * y

val res29_3 = for {
    x <- List(1, 2, 3)
    y <- Set(1)
    z <- Set(0)
} yield x * y * z



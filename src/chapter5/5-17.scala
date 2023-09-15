// 5.17

// 文: プログラムの状態を変更しなければ意味を持たない言語構造
// 式: グローバルな状態を操作せず、常に何かを返し、何回実行しても常に同じ結果を返す
// 関数型プログラミングは式を使うプログラミング。関数型プログラマは文を使わない

val xs = List(1, 2, 3, 4, 5)
val result = for {
    x <- xs
} yield x * x

val res19 = for {
    a <- List[Int](1, 2)
    b <- List[Int](10, 100)
    c <- List[Double](0.5, 0.7)
    d <- List[Int](3)
} yield (a * b * c + d).toString + "km"

// 5.20

case class Point(x: Int, y: Int)

val points = List(Point(5, 2), Point(1, 1))
val radiuses = List(2, 1)

def isInside(point: Point, radius: Int): Boolean = {
    radius * radius >= point.x * point.x + point.y * point.y
}

val res21_1 = for {
    r <- radiuses
    point <- points
} yield s"$point is within a radius of $r: " + isInside(point, r).toString

val res21_2 = for {
    r <- radiuses
    point <- points.filter(p => isInside(p, r))
} yield s"$point is within a radius of $r"

// 5.22

val points = List(Point(5, 2), Point(1, 1))
val radiuses = List(2, 1)

val res22_1 = for {
    r <- radiuses
    point <- points.filter(p => isInside(p, r))
} yield s"$point is within a radius of $r"

val res22_2 = for {
    r <- radiuses
    point <- points
    if isInside(point, r)
} yield s"$point is within a radius of $r"

def insideFilter(point: Point, r: Int): List[Point] = {
    if (isInside(point, r)) List(point) else List.empty
}

val res22_3 = for {
    r <- radiuses
    point <- points
    inPoint <- insideFilter(point, r)
} yield s"$inPoint in within a radius of $r"
// 5.23

case class Point(x: Int, y: Int)

val points = List(Point(5, 2), Point(1, 1))
val riskyRadiuses = List(-10, 0, 2)

def isInside(point: Point, radius: Int): Boolean = {
    radius * radius >= point.x * point.x + point.y * point.y
}

val res23_0 = for {
    r <- riskyRadiuses
    point <- points.filter(p => isInside(p, r))
} yield s"$point is within a radius of $r"


val res23_1 = for {
    r <- riskyRadiuses.filter(r => r > 0)
    point <- points.filter(p => isInside(p, r))
} yield s"$point is within a radius of $r"

val res23_2 = for {
    r <- riskyRadiuses
    if r > 0
    point <- points.filter(p => isInside(p, r))
} yield s"$point is within a radius of $r"

def insideFilter(point: Point, radius: Int): List[Point] = {
    if (isInside(point, radius)) List(point) else List.empty
}

def validateRadius(radius: Int): List[Int] = {
    if (radius > 0) List(radius) else List.empty
}

val res23_3 = for {
    r <- riskyRadiuses
    validRadius <- validateRadius(r)
    point <- points
    inPoint <- insideFilter(point, validRadius)
} yield s"$inPoint is within a radius of $validRadius"

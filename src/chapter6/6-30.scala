// 6.30

val rawShows = List("The Wire (2002-2008)", "Chernobyl (2019)", "Chernobyl")

def parseShows(rawShows: List[String]): List[TvShow] = {
    rawShows.map(parseShow).map(_.toList).flatten
}

val res6_30 = parseShows(rawShows)
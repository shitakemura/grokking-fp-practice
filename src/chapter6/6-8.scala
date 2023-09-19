// 6.8


def parseShows(rawShows: List[String]): List[TvShow] = {
    rawShows.map(parseShow)
}

def parseShow(rawShow: String): TvShow = {
    val bracketOpen = rawShow.indexOf('(')
    val bracketClose = rawShow.indexOf(')')
    val dash = rawShow.indexOf('-')

    val name = rawShow.substring(0, bracketOpen).trim
    val yearStart = Integer.parseInt(rawShow.substring(bracketOpen + 1, dash))
    val yearEnd = Integer.parseInt(rawShow.substring(dash + 1, bracketClose))

    TvShow(name, yearStart, yearEnd)
}

val res6_9 = parseShow("Breaking Bad (2008-2013)")

val rawShows: List[String] = List("Breaking Bad (2008-2013)", "The Wire (2002-208)", "Mad Men (2007-2015)")

val res6_9_2 = parseShows(rawShows)
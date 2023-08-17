// 6.3

case class TvShow(title: String, start: Int, end: Int)

def sortShows(shows: List[TvShow]): List[TvShow] = {
    shows
        .sortBy(tvShow => tvShow.end - tvShow.start)
        .reverse
}

val shows = List(TvShow("Breaking Bad", 2008, 2013), 
                 TvShow("The Wire", 2002, 2008), 
                 TvShow("Mad Men", 2007, 2015))

sortShows(shows)

val rawShows: List[String] = List("Breaking Bad (2008-2013)", 
                                  "The Wire (2002-2008)",
                                  "Mad Men (2007-2015)")

def sortRawShows(rawShows: List[String]): List[TvShow] = {
    val tvShows = parseShows(rawShows)
    sortShows(tvShows)
}
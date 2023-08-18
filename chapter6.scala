// // 6.3

// case class TvShow(title: String, start: Int, end: Int)

// def sortShows(shows: List[TvShow]): List[TvShow] = {
//     shows
//         .sortBy(tvShow => tvShow.end - tvShow.start)
//         .reverse
// }

// val shows = List(TvShow("Breaking Bad", 2008, 2013), 
//                  TvShow("The Wire", 2002, 2008), 
//                  TvShow("Mad Men", 2007, 2015))

// sortShows(shows)

// val rawShows: List[String] = List("Breaking Bad (2008-2013)", 
//                                   "The Wire (2002-2008)",
//                                   "Mad Men (2007-2015)")

// def sortRawShows(rawShows: List[String]): List[TvShow] = {
//     val tvShows = parseShows(rawShows)
//     sortShows(tvShows)
// }

// def parseShows(rawShows: List[String]): List[TvShow] = {
//     rawShows.map(parseShow)
// }

// def parseShow(rawShow: String): TvShow = {
//     val bracketOpen = rawShow.indexOf('(')
//     val bracketClose = rawShow.indexOf(')')
//     val dash = rawShow.indexOf('-')

//     val name = rawShow.substring(0, bracketOpen).trim
//     val yearStart = Integer.parseInt(rawShow.substring(bracketOpen + 1, dash))
//     val yearEnd = Integer.parseInt(rawShow.substring(dash + 1, bracketClose))

//     TvShow(name, yearStart, yearEnd)
// }

// parseShow("Breaking Bad (2008-1013)")

// parseShows(rawShows)

// val invalidRawShow = "Breaking Bad, 2008-2013"
// parseShow(invalidRawShow)

// // 6.12
// def parseShow(rawShow: String): Option[TvShow] = {
//     for {
//         name <- extractName(rawShow)
//         yearStart <- extractYearStart(rawShow)
//         yearEnd <- extractYearEnd(rawShow)
//     } yield TvShow(name, yearStart, yearEnd)
// }

// def extractYearStart(rawShow: String): Option[Int] = {
//     val bracketOpen = rawShow.indexOf('(')
//     val dash = rawShow.indexOf('-')
//     val yearStrOpt = if (bracketOpen != -1 && dash > bracketOpen + 1) {
//         Some(rawShow.substring(bracketOpen + 1, dash))
//     } else {
//         None
//     }
//     yearStrOpt.map(yearStr => yearStr.toInt)
// }

def extractYearStart(rawShow: String): Option[Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')
    for {
        yearStr <- if (bracketOpen != -1 && dash > bracketOpen + 1) 
            Some(rawShow.substring(bracketOpen + 1, dash))
        else
            None
        year <- yearStr.toIntOption
    } yield year
}

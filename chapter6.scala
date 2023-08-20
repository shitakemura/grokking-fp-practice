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

extractYearStart("Breaking Bad (2008-2013)")
extractYearStart("Mad Men (-2015)")
extractYearStart("(2002- N/A) The Wire")

def extractName(rawShow: String): Option[String] = {
    val bracketOpen = rawShow.indexOf('(')
    for {
        name <- if (bracketOpen > 0)
            Some(rawShow.substring(0, bracketOpen).trim)
        else
            None
    } yield name
}

def extractYearEnd(rawShow: String): Option[Int] = {
    val dash = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
        yearStr <- if (dash != -1 && dash < bracketClose)
            Some(rawShow.substring(dash + 1, bracketClose))
        else
            None
        year <- yearStr.toIntOption
    } yield year
}

// 6.26
case class TvShow(title: String, start: Int, end: Int)

def extractSingleYear(rawShow: String): Option[Int] = {
    val dash = rawShow.indexOf('-')
    val bracketOpen = rawShow.indexOf('(')
    val bracketClose = rawShow.indexOf(')')
    for {
        yearStr <- if (dash == -1 && bracketOpen != -1 && bracketClose > bracketOpen + 1)
            Some(rawShow.substring(bracketOpen + 1, bracketClose))
            else None
        year <- yearStr.toIntOption
    } yield year
}

def parseShow(rawShow: String): Option[TvShow] = {
    for {
        name <- extractName(rawShow)
        yearStart <- extractYearStart(rawShow).orElse(extractSingleYear(rawShow))
        yearEnd <- extractYearEnd(rawShow).orElse(extractSingleYear(rawShow))
    } yield TvShow(name, yearStart, yearEnd)
}

parseShow("Chernobyl (2019)")
parseShow("Breaking Bad (2008-2013)")
parseShow("Mad Men (-2015)")

// 6.28

val seven: Option[Int] = Some(7)
val eight: Option[Int] = Some(8)
val none: Option[Int] = None

seven.orElse(eight)
none.orElse(eight)
seven.orElse(none)
none.orElse(none)

val chernobyl = "Chelnobyl (2019)"
extractYearStart(chernobyl)
extractSingleYear(chernobyl)
extractYearStart(chernobyl).orElse(extractSingleYear(chernobyl))
extractYearStart(chernobyl).orElse(extractSingleYear("not-a-year"))

def extractSingleYearOrYearEnd(rawShow: String): Option[Int] = {
    extractSingleYear(rawShow).orElse(extractYearEnd(rawShow))
}

def extractAnyYear(rawShow: String): Option[Int] = {
    extractYearStart(rawShow).orElse(extractYearEnd(rawShow)).orElse(extractSingleYear(rawShow))
}

def extractSingleYearIfNameExists(rawShow: String): Option[Int] = {
    for {
        name <- extractName(rawShow)
        year <- extractSingleYear(rawShow)
    } yield year
}

// def extractSingleYearIfNameExists(rawShow: String): Option[Int] = {
//     extractName(rawShow).flatMap(_ => extractSingleYear(rawShow))
// }

def extractAnyYearIfNameExists(rawShow: String): Option[Int] = {
    extractName(rawShow).flatMap(_ => extractAnyYear(rawShow))
}

// 6.33
Some(7).toList
None.toList

def parseShows(rawShows: List[String]): List[TvShow] = {
    // rawShows
    //     .map(parseShow)
    //     .map(_.toList)
    //     .flatten
    rawShows
        .map(parseShow)
        .flatMap(_.toList)
}

// 6.35

val rawShows = List("Breaking Bad (2008-1013)", "The Wire 2002 2008", "Mad Men (2007-2015)")
parseShows(rawShows)

// 6.36

def addOrResign(parsedShows: Option[List[TvShow]], newParsedShows: Option[TvShow]): Option[List[TvShow]] = {
    for {
        shows <- parsedShows
        parsedShow <- newParsedShow
    } yield shows.appended(parsedShow)
}
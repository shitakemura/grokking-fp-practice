// 6.19

def parseShow(rawShow: String): Option[TvShow] = {
    for {
        name <- extractName(rawShow)
        yearStart <- extractYearStart(rawShow)
        yearEnd <- extractYearEnd(rawShow)
    } yield TvShow(name, yearStart, yearEnd)
}

def extractYearStart(rawShow: String): Option[Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')
    for {
        yearStr <- if (bracketOpen != -1 && dash > bracketOpen + 1) 
                       Some(rawShow.substring(bracketOpen + 1, dash))
                   else None
        year <- yearStr.toIntOption
    } yield year
}

def extractName(rawShow: String): Option[String] = {
    val bracketOpen = rawShow.indexOf('(')
    if (bracketOpen > 0)
        Some(rawShow.substring(0, bracketOpen).trim)
    else None
}

def extractYearEnd(rawShow: String): Option[Int] = {
    val dash = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
        yearStr <- if (dash != -1 && bracketClose > dash + 1)
                       Some(rawShow.substring(dash + 1, bracketClose))
                   else None
        year <- yearStr.toIntOption
    } yield year
}

// 6.20
// for内包表記はflatMapのsyntax sugarにすぎない

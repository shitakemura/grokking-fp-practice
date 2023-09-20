// 6.26

// 関数合成
def parseShow(rawShow: String): Option[TvShow] = {
    for {
        name <- extractName(rawShow)
        yearStart <- extractYearStart(rawShow).orElse(extractSingleYear(rawShow))
        yearEnd <- extractYearEnd(rawShow).orElse(extractSingleYear(rawShow))
    } yield TvShow(name, yearStart, yearEnd)
}

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

val res6_26_1 = parseShow("Chernobyl (2019)")
val res6_26_2 = parseShow("Breaking Bad (2008-2013)")
val res6_26_3 = parseShow("Mad Men (-2015)")
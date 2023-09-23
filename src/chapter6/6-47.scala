// 6.47

def extractNameWithEither(rawShow: String): Either[String, String] = {
    val bracketOpen = rawShow.indexOf('(')
    if (bracketOpen > 0)
        Right(rawShow.substring(0, bracketOpen).trim)
    else
        Left(s"Can't extract name from $rawShow")
}

def extractYearEndWithEither(rawShow: String): Either[String, Int] = {
    val dash = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
        yearStr <-
            if (dash != -1 && bracketClose > dash + 1)
                Right(rawShow.substring(dash + 1, bracketClose))
            else
                Left(s"Can't extract year end from $rawShow")
        year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
    } yield year
}

def extractSingleYearWithEither(rawShow: String): Either[String, Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')
    val bracketClose = rawShow.indexOf(')')
    for {
        yearStr <-
            if (bracketOpen != -1 && dash == -1 && bracketClose > bracketOpen + 1)
                Right(rawShow.substring(bracketOpen + 1, bracketClose))
            else
                Left(s"Can't extract single year from $rawShow")
        year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
    } yield year
}

// 6.48

def parseShowWithEither(rawShow: String): Either[String, TvShow] = {
    for {
        name <- extractNameWithEither(rawShow)
        yearStart <- extractYearStartWithEither(rawShow).orElse(extractSingleYearWithEither(rawShow))
        yearEnd <- extractYearEndWithEither(rawShow).orElse(extractSingleYearWithEither(rawShow))
    } yield TvShow(name, yearStart, yearEnd)
}

val res6_48_1 = parseShowWithEither("The Wire (-)")
val res6_48_2 = parseShowWithEither("The Wire (oops)")
val res6_48_3 = parseShowWithEither("(2002-2008)")
val res6_48_4 = parseShowWithEither("The Wire (2002-2008)")
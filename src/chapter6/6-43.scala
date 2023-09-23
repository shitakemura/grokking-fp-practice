// 6.43

// Optionと同じように機能し、なおかつエラーに関する具体的な情報を伝達するもの

// Either
// Either[A, B] -> Left[A] / Right[B]

// Left(正常終了) / Right(異常終了)

def extractNameWithOption(rawShow: String): Option[String] = {
    val bracketOpen = rawShow.indexOf('(')
    if (bracketOpen > 0)
        Some(rawShow.substring(0, bracketOpen).trim)
    else
        None
}

def extractNameWithEither(rawShow: String): Either[String, String] = {
    val bracketOpen = rawShow.indexOf('(')
    if (bracketOpen > 0)
        Right(rawShow.substring(0, bracketOpen).trim)
    else
        Left(s"Can't extract name from $rawShow")
}

// 6.44

// Some[[TvShow]] or Noneを返す
def parseShowsWithOption(rawShows: List[String]): Option[List[TvShow]] = ???

// Right[List[TvShow]] or Left[String]を返す
def parseShowsWithEither(rasShows: List[String]): Either[String, List[TvShow]] = ???

// 6.46

def extractYearStart(rawShow: String): Either[String, Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')
    val yearStrEither = if (bracketOpen != -1 && dash > bracketOpen + 1)
        Right(rawShow.substring(bracketOpen + 1, dash))
    else
        Left(s"Can't extract start year from $rawShow")
    yearStrEither
        .map(yearStr => 
                yearStr
                    .toIntOption
                    .toRight(s"Can't parse $yearStr")
            ).flatten
}

def extractYearStartWithFor(rawShow: String): Either[String, Int] = {
    val bracketOpen = rawShow.indexOf('(')
    val dash = rawShow.indexOf('-')
    for {
        yearStr <- if (bracketOpen != -1 && dash > bracketOpen + 1)
                      Right(rawShow.substring(bracketOpen + 1, dash))
                   else Left(s"Can't extract start year from $rawShow")
        year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
    } yield year
}

val res6_46_1 = extractYearStartWithFor("The Wire (2002-2008)")
val res6_46_2 = extractYearStartWithFor("The Wire (-2008)")
val res6_46_3 = extractYearStartWithFor("The Wire (oops-2008)")
val res6_46_4 = extractYearStartWithFor("The Wire (2002-)")

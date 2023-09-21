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

// 6.27

// 合成できない検査例外と合成できるOption

// 関数と値はうまく合成できる
// 命令型のコードはうまく合成できない

// 6.28

val seven: Option[Int] = Some(7)
val eight: Option[Int] = Some(8)
val none: Option[Int] = None

val res6_28_1 = seven.orElse(eight)
val res6_28_2 = none.orElse(eight)
val res6_28_3 = seven.orElse(none)
val res6_28_4 = none.orElse(none)

// 6.29

def extractSingleYearOrYearEnd(rawShow: String): Option[Int] = {
    extractSingleYear(rawShow).orElse(extractYearEnd(rawShow))
}

def extractAnyYear(rawShow: String): Option[Int] = {
    extractYearStart(rawShow).orElse(extractYearEnd(rawShow)).orElse(extractSingleYear(rawShow))
}

def extractSingleYearIfNameExists(rawShow: String): Option[Int] = {
    extractName(rawShow).flatMap(name => extractSingleYear(rawShow))
}

def extractAnyYearIfNameExists(rawShow: String): Option[Int] = {
    extractName(rawShow).flatMap(name => extractAnyYear(rawShow))
}

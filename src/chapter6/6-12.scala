// 6.12

def extractName(rawShow: String): Option[String] = ???
def extractYearStart(rawShow: String): Option[Int] = ???
def extractYearEnd(rawShow: String): Option[Int] = ???

def parseShow(rawShow: String): Option[TvShow] = {
    for {
        name <- extractName(rawShow)
        yearStart <- extractYearStart(rawShow)
        yearEnd <- extractYearEnd(rawShow)
    } yield TvShow(name, yearStart, yearEnd)
}

// 6.15
// Optionを使うときには、エラーを表す値としてNoneを使う
// 関数がOptionを返すとクライアントがエラーの可能性に対処せざるを得なくなる

// 6.16
// 合成可能性: 独立した別々の値を組み合わせて別の値を計算できる仕組み

// 6.17

// def extraYearStart(rawShow: String): Option[Int] = {
//     val bracketOpen = rawShow.indexOf('(')
//     val dash = rawShow.indexOf('-')
//     val yearStartOpt = if (bracketOpen != -1 && dash > bracketOpen + 1)
//         Some(rawShow.substring(bracketOpen + 1, dash))
//     else None
    
//     yearStartOpt.map(yearStr => yearStr.toIntOption).flatten
// }

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

val res6_18_1 = extractYearStart("Breaking Bad (2008-2013)")
val res6_18_2 = extractYearStart("Mad Men (-1015)")
val res6_18_3 = extractYearStart("(2002 - N/A) The Wire")
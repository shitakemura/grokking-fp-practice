// 6.30

val rawShows = List("The Wire (2002-2008)", "Chernobyl (2019)", "Chernobyl")

def parseShows(rawShows: List[String]): List[TvShow] = {
    rawShows.map(parseShow).map(_.toList).flatten
}

val res6_30 = parseShows(rawShows)

// 6.36

// オールオアナッシング型のエラー処理ロジック

def addOrResign(parsedShows: Option[List[TvShow]], newParsedShow: Option[TvShow]): Option[List[TvShow]] = {
    for {
        shows <- parsedShows
        parsedShow <- newParsedShow
    } yield shows.appended(parsedShow)
}

// 6.38

// 2種類のエラー処理戦略

// ベストエフォート型のエラー処理

def parseShows(rawShows: List[String]): List[TvShow] = {
    rawShows
        .map(parseShow)
        .map(_.toList)
        .flatten
}

// オールオアナッシング型のエラー処理

def parseShows(rawShows: List[String]): Option[List[TvShow]] = {
    val initialResult = Some(List.empty)

    rawShows
        .map(parseShow)
        .foldLeft(initialResult)(addOrResign)
}


val res6_40 = parseShows(rawShows)
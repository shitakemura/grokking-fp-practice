// 6.1

// 6.2

// ステップ1: 高階関数のおさらい
// ステップ2: Optionを使ってエラーを通知する
// ステップ3: 関数型エラー処理と検査例外
// ステップ4: 多くのエラーを一度に処理する
// ステップ5: Eitherを使って記述的エラーを通知する

// 6.3

case class TvShow(name: String, start: Int, end: Int)

def sortShows(shows: List[TvShow]): List[TvShow] = ???

// 6.4

def sortShows(shows: List[TvShow]): List[TvShow] = {
    shows
        .sortBy(tvShow => tvShow.end - tvShow.start)
        .reverse
}

val shows = List(TvShow("Breaking Bad", 2008, 2013),
                 TvShow("The Wire", 2002, 2008),
                 TvShow("Mad Men", 2007, 2015),
            )

val res6_4 = sortShows(shows)

// 6.6

def parseShows(rawShows: List[String]): List[TvShow] = ???

def sortRawShows(rawShows: List[String]): List[TvShow] = {
    val tvShows = parseShows(rawShows)
    sortShows(tvShows)
}

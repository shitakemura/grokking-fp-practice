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

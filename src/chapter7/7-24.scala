// 7.24
// 7.25

// 直和型 + 直積型 = 代数的データ型(ADT)

enum MusicGenre {
    case HeavyMetal
    case Pop
    case HardRock
}
import MusicGenre._

object model {
    opaque type Location = String
    object Location {
        def apply(value: String): Location = value
        extension(a: Location) def name: String = a
    }
}
import model._

enum YearsActive {
    case StillActive(since: Int)
    case ActiveBetween(start: Int, end: Int)
}

import YearsActive._

case class Artist(name: String, genre: MusicGenre, origin: Location, yearsActive: YearsActive)


val artists = List(
    Artist("Metallica", HeavyMetal, Location("U.S."), StillActive(1981)),
    Artist("Led Zeppelin", HardRock, Location("England"), ActiveBetween(1968, 1980))
)
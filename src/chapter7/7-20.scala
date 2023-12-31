// 7.20

object model {
    opaque type Location = String
    object Location {
        def apply(value: String): Location = value
        extension(a: Location) def name: String = a
    }
}

import model._

case class PeriodInYears(start: Int, end: Option[Int])

case class Artist(name: String, genre: String, origin: Location, yearsActive: PeriodInYears)

val artists = List(
    Artist("Metallica", "Heavy Metal", Location("U.S"), PeriodInYears(1981, None)),
    Artist("Led Zeppelin", "Hard Rock", Location("England"), PeriodInYears(1968, Some(1980))),
    Artist("Bee Gees", "Pop", Location("England"), PeriodInYears(1958, Some(2003)))
)

def searchArtists(
    artists: List[Artist],
    genres: List[String],
    locations: List[String],
    searchByActiveYears: Boolean,
    activeAfter: Int,
    activeBefore: Int
): List[Artist] = {
    artists.filter(artist =>
        (genres.isEmpty || genres.contains(artist.genre)) &&
        (locations.isEmpty || locations.contains(artist.origin.name)) &&
        (!searchByActiveYears || (
            (artist.yearsActive.end.forall(_ >= activeAfter)) &&
            (artist.yearsActive.start <= activeBefore)))
        )
}

// 7.21

// 直和型

enum MusicGenre {
    case HeavyMetal
    case Pop
    case HardRock
}

import MusicGenre._
val genre: MusicGenre = Pop
val x: MusicGenre = HeavyMetal

case class Artist(name: String, genre: MusicGenre, origin: Location, yearsActive: PeriodInYears)

val artists = List(
    Artist("Metallica", HeavyMetal, Location("U.S."), PeriodInYears(1981, None))
)

// 7.23

enum YearsActive {
    case StillActive(since: Int)
    case ActiveBetween(start: Int, end: Int)
}


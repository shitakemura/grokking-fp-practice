// 7.35

object model {
    opaque type Location = String
    object Location {
        def apply(value: String): Location = value
        extension(a: Location) def name: String = a
    }

    enum MusicGenre {
        case HeavyMetal
        case Pop
        case HardRock
    }

    enum YearsActive {
        case StillActive(since: Int)
        case ActiveBetween(start: Int, end: Int)
    }

    case class Artist(name: String, 
        genre: MusicGenre, 
        origin: Location, 
        yearsActive: YearsActive
    )
}

import model._, model.Location._, model.MusicGenre._, model.YearsActive._

def wasArtistActive(artist: Artist, yearStart: Int, yearEnd: Int): Boolean = {
    artist.yearsActive match {
        case YearsActive.StillActive(since) => since <= yearEnd
        case YearsActive.ActiveBetween(start, end) => start <= yearEnd && end >= yearStart
    }
}

enum SearchCondition {
    case SearchByGenre(genres: List[MusicGenre])
    case SearchByOrigin(locations: List[Location])
    case SearchByActiveYears(start: Int, end: Int)
}

import SearchCondition._

val artists = List(
    Artist("Metallica", HeavyMetal, Location("U.S."), StillActive(1981)),
    Artist("Led Zeppelin", HardRock, Location("England"), ActiveBetween(1968, 1980)),
    Artist("Bee Gees", Pop, Location("England"), ActiveBetween(1958, 1003))
)

def searchArtists(artists: List[Artist], requiredConditions: List[SearchCondition]): List[Artist] = {
    artists.filter(artist =>
        requiredConditions.forall(condition =>
            condition match
                case SearchByGenre(genres) => genres.contains(artist.genre)
                case SearchByOrigin(locations) => locations.contains(artist.origin)
                case SearchByActiveYears(start, end) => wasArtistActive(artist, start, end)
        )    
    )
}

val s1 = searchArtists(artists, List(
    SearchByGenre(List(Pop)),
    SearchByOrigin(List(Location("England"))),
    SearchByActiveYears(1950, 2020)
))

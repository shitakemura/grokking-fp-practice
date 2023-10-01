// 7.34

object model {
    opaque type Location = String
    object Location {
        def apply(value: String): Location = value
        extension(a: Location) def name: String = a
    }

    enum SearchCondition {
        case SearchByGenre(genres: List[MusicGenre])
        case SearchByOrigin(locations: List[Location])
        case SearchByActiveYears(start: Int, end : Int)
    }
}

import model._


def searchArtists(artists: List[Artist], requiredConditions: List[SearchCondition]): List[Artist] = {
    artists.filter(artist => 
        requiredConditions.forall(condition => 
            condition match {
                case SearchByGenre(genres) => genres.contains(artist.genre)
                case SearchByOrigin(locations) => locations.contains(artist.origin)
                case SearchByActiveYears(start, end) => wasArtistActive(artist, start, end)
            }    
        )    
    )
}

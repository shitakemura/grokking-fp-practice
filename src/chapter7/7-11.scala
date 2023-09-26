// 7.11

object model {
    opaque type Genre = String
    object Genre {
        def apply(value: String): Genre = value
        extension(a: Genre) def name: String = a
    }

    opaque type Location = String
    object Location {
        def apply(value: String): Location = value
        extension(a: Location) def name: String = a
    }

    opaque type YearsActiveStart = Int
    object YearsActiveStart {
        def apply(value: Int): YearsActiveStart = value
        extension(a: YearsActiveStart) def value: Int = a
    }

    opaque type YearsActiveEnd = Int
    object YearsActiveEnd {
        def apply(value: Int): YearsActiveEnd = value
        extension(a: YearsActiveEnd) def value: Int = a
    }
}

import model._

case class Artist(
    name: String,
    genre: Genre,
    origin: Location,
    yearsActiveStart: YearsActiveStart,
    isActive: Boolean,
    yearsActiveEnd: YearsActiveEnd,
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
        (genres.isEmpty || genres.contains(artist.genre.name)) &&
        (locations.isEmpty || locations.contains(artist.origin.name)) &&
        (!searchByActiveYears || (artist.isActive ||
            artist.yearsActiveEnd.value >= activeAfter) &&
            (artist.yearsActiveStart.value <= activeBefore)))
}
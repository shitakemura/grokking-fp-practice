object model {
    opaque type Location = String
    object Location {
        def apply(value: String): Location = value
        extension(a: Location) def name: String = a
    }
}

import model._

case class Artist(
    name: String,
    genre: String,
    origin: Location,
    yearsActiveStart: Int,
    yearsActiveEnd: Option[Int]
)

val artist1 = Artist("Metallica", "Heavy Metal", Location("U.S."), 1981, None)
val artist2 = Artist("Led Zeppelin", "Hard Rock", Location("England"), 1968, Some(1980))

// 7.16

// forall
// option[A].forall(f: A => Boolean): Boolean
// OptionがNoneであるか、Optionの値に関数fを適用したときにtrueが返された場合は、trueを返す。

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
            (artist.yearsActiveEnd.forall(_ >= activeAfter)) &&
            (artist.yearsActiveStart <= activeBefore)))
        )
}
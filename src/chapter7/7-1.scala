// 7.1

// 7.2

case class Artist(
    name: String, 
    genre: String, 
    origin: String, 
    yearsActiveStart: Int, 
    isActive: Boolean,
    yearsActiveEnd: Int
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
        (locations.isEmpty || locations.contains(artist.origin)) &&
        (!searchByActiveYears || (artist.isActive ||
            artist.yearsActiveEnd >= activeAfter) &&
            (artist.yearsActiveStart <= activeBefore)))
}

// 7.4

val artists = List(
    Artist("Metallica", "Heavy Metal", "U.S", 1981, true, 0),
    Artist("Led Zeppelin", "Hard Rock", "England", 1968, false, 1980),
    Artist("Bee Gees", "Pop", "England", 1958, false, 2003),
)

val res7_4_1 = searchArtists(artists, List("Pop"), List("England"), true, 1950, 2022)
val res7_4_2 = searchArtists(artists, List.empty, List("England"), true, 1950, 2022)
val res7_4_3 = searchArtists(artists, List.empty, List.empty, true, 1950, 1979)


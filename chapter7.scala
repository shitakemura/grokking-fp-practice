// 7.1
// case class Artist(name: String, genre: String, origin: String)

// 7.3
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
        (genres.isEmpty || genres.contains(artist.genre)) 
        && (locations.isEmpty || locations.contains(artist.origin))
        && (!searchByActiveYears || 
            (artist.isActive || 
                artist.yearsActiveEnd >= activeAfter) 
                && (artist.yearsActiveStart <= activeBefore))
    )
}

val artists = List(
    Artist("Metallica", "Heavy Metal", "U.S.", 1981, true, 0),
    Artist("Led Zeppelin", "Hard Rock", "England", 1968, false, 1980),
    Artist("Bee Gees", "Pop", "England", 1958, false, 2003)
)

searchArtists(artists, List("Pop"), List("England"), true, 1950, 2022)
searchArtists(artists, List.empty, List("England"), true, 1950, 2022)
searchArtists(artists, List.empty, List.empty, true, 1950, 1979)
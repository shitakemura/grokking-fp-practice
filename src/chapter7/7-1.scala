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
    genre: List[String],
    locations: List[String],
    searchByActiveYears: Boolean,
    activeAfter: Int,
    activeBefore: Int
): List[Artist] = ???

// 7.4

val artists = List(
    Artist("Metallica", "Heavy Metal", "U.S", 1981, true, 0),
    Artist("Led Zeppelin", "Hard Rock", "England", 1968, false, 1980),
    Artist("Bee Gees", "Pop", "England", 1958, false, 2003),
)
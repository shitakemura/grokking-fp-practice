// // 7.24 直和型 + 直積型 = 代数的データ型(ADT)
// enum MusicGenre {
//     case HeavyMetal
//     case Pop
//     case HardRock
// }
// import MusicGenre._

// object model {
//     opaque type Location = String
//     object Location {
//         def apply(value: String): Location = value
//         extension(a: Location) def name: String = a
//     }
// }
// import model._

// enum YearsActive {
//     case StillActive(since: Int)
//     case ActiveBetween(start: Int, end: Int)
// }

// case class Artist(name: String, genre: MusicGenre, origin: Location, yearsActive: YearsActive)

// // 7.28

// def searchArtists(artists: List[Artist], genres: List[MusicGenre], locations: List[Location],
//     searchByActiveYears: Boolean, activeAfter: Int, activeBefore: Int): List[Artist] = {
//         artists.filter(artist =>
//             (genres.isEmpty || genres.contains(artist.genre)) &&
//             (locations.isEmpty || locations.contains(artist.origin)) &&
//             (!searchByActiveYears || wasArtistActive(artist, activeAfter, activeBefore))
//         )
//     }

// def wasArtistActive(artist: Artist, yearStart: Int, yearEnd: Int): Boolean = {
//     artist.yearsActive match {
//         case YearsActive.StillActive(since) => since <= yearEnd
//         case YearsActive.ActiveBetween(start, end) => start <= yearEnd && end >= yearStart
//     }
// }

// // 7.29
// def activeLength(artist: Artist, currentYear: Int): Int = {
//     artist.yearsActive match {
//         case YearsActive.StillActive(since) => currentYear - since
//         case YearsActive.ActiveBetween(start, end) => end - start
//     }
// }

// val my = activeLength(Artist("Metallica", HeavyMetal, Location("U.S."), 
//     YearsActive.StillActive(1981)), 2022)

// val ly = activeLength(Artist("Led Zeppelin", HardRock, Location("England"), 
//     YearsActive.ActiveBetween(1958, 2003)), 2022)
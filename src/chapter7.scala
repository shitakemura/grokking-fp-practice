// // 7.1
// // case class Artist(name: String, genre: String, origin: String)

// // 7.3
// // case class Artist(
// //     name: String,
// //     genre: String,
// //     origin: String,
// //     yearsActiveStart: Int,
// //     isActive: Boolean,
// //     yearsActiveEnd: Int
// // )

// // def searchArtists(
// //     artists: List[Artist],
// //     genres: List[String],
// //     locations: List[String],
// //     searchByActiveYears: Boolean,
// //     activeAfter: Int,
// //     activeBefore: Int
// // ): List[Artist] = {
// //     artists.filter(artist =>
// //         (genres.isEmpty || genres.contains(artist.genre)) 
// //         && (locations.isEmpty || locations.contains(artist.origin))
// //         && (!searchByActiveYears || 
// //             (artist.isActive || 
// //                 artist.yearsActiveEnd >= activeAfter) 
// //                 && (artist.yearsActiveStart <= activeBefore))
// //     )
// // }

// // val artists = List(
// //     Artist("Metallica", "Heavy Metal", "U.S.", 1981, true, 0),
// //     Artist("Led Zeppelin", "Hard Rock", "England", 1968, false, 1980),
// //     Artist("Bee Gees", "Pop", "England", 1958, false, 2003)
// // )

// // searchArtists(artists, List("Pop"), List("England"), true, 1950, 2022)
// // searchArtists(artists, List.empty, List("England"), true, 1950, 2022)
// // searchArtists(artists, List.empty, List.empty, true, 1950, 1979)

// // 7.9

// // object model {
// //     opaque type Location = String

// //     object Location {
// //         def apply(value: String): Location = value
// //         extension(a: Location) def name: String = a
// //     }
// // }

// // import model._
// // val us: Location = Location("U.S")

// // 7.10
// // case class Artist(name: String, genre: String, origin: Location,
// //     yearsActiveStart: Int, isActive: Boolean, yearsActiveEnd: Int)

// // Artist("Metallica", "Heavy Metal", Location("U.S."), 1981, true, 0)
// // Artist(Location("U.S."), "Metallica", "Heavy Metal", 1981, true, 0)
// // Artist(Location("U.S."), "Heavy Metal", "Metallica", 1981, true, 0)

// // def searchArtists(artists: List[Artist], genres: List[String], locations: List[String],
// //     searchByActiveYears: Boolean, activeAfter: Int, activeBefore: Int): List[Artist] = {
// //         artists.filter(artist =>
// //             (genres.isEmpty || genres.contains(artist.genre)) && 
// //             (locations.isEmpty || locations.contains(artist.origin.name)) &&
// //             (!searchByActiveYears || (artist.isActive ||
// //                 artist.yearsActiveEnd >= activeAfter &&
// //                 (artist.yearsActiveStart <= activeBefore))))
// //     }

// // val artists = List(
// //     Artist("Metallica", "Heavy Metal", Location("U.S."), 1981, true, 0),
// //     Artist("Led Zeppelin", "Hard Rock", Location("England"), 1968, false, 1980),
// //     Artist("Bee Gees", "Pop", Location("England"), 1958, false, 2003)
// // )

// // searchArtists(artists, List("Pop"), List("England"), true, 1950, 2022)
// // searchArtists(artists, List.empty, List("England"), true, 1950, 2022)
// // searchArtists(artists, List.empty, List.empty, true, 1950, 1979)

// // 7.11


// // object model {
// //     opaque type Location = String
// //     object Location {
// //         def apply(value: String): Location = value
// //         extension(a: Location) def name: String = a
// //     }

// //     opaque type Genre = String
// //     object Genre {
// //         def apply(value: String): Genre = value
// //         extension(a: Genre) def name: String = a
// //     }

// //     opaque type YearsActiveStart = Int
// //     object YearsActiveStart {
// //         def apply(value: Int): YearsActiveStart = value
// //         extension(a: YearsActiveStart) def value: Int = a
// //     }

// //     opaque type YearsActiveEnd = Int
// //     object YearsActiveEnd {
// //         def apply(value: Int): YearsActiveEnd = value
// //         extension(a: YearsActiveEnd) def value: Int = a
// //     }
// // }

// // import model._
// // case class Artist(
// //     name: String,
// //     genre: Genre,
// //     origin: Location,
// //     yearsActiveStart: YearsActiveStart,
// //     isActive: Boolean,
// //     yearsActiveEnd: YearsActiveEnd
// // )

// // def searchArtists(artists: List[Artist], genres: List[String], locations: List[String],
// //     searchByActiveYears: Boolean, activeAfter: Int, activeBefore: Int): List[Artist] = {
// //         artists.filter(artist =>
// //             (genres.isEmpty || genres.contains((artist.genre.name)) &&
// //             (locations.isEmpty || locations.contains(artist.origin.name)) &&
// //             (!searchByActiveYears || (artist.isActive ||
// //                 artist.yearsActiveEnd.value >= activeAfter) &&
// //                 (artist.yearsActiveStart.value <= activeBefore))
// //             ))
// //     }

// // 7.13

// object model {
//     opaque type Location = String
//     object Location {
//         def apply(value: String): Location = value
//         extension(a: Location) def name: String = a
//     }
// }

// import model._

// // case class Artist(name: String, genre: String, origin: Location,
// //     yearsActiveStart: Int, yearsActiveEnd: Option[Int])

// val a = Artist("Metallica", "Heavy Metal", Location("U.S."), 1981, None)
// val b = Artist("Led Zeppelin", "Hard Rock", Location("England"), 1968, Some(1980))

// // 7.14
// // def searchArtists(artists: List[Artist], genres: List[String], locations: List[String],
// //     searchByActiveYears: Boolean, activeAfter: Int, activeBefore: Int) = {
// //         artists.filter(artist =>
// //         (genres.isEmpty || genres.contains(artist.genre)) &&
// //         (locations.isEmpty || locations.contains(artist.origin.name)) &&
// //         (!searchByActiveYears || (
// //             (artist.yearsActiveEnd.forall(activeEnd => activeEnd >= activeAfter)) &&
// //             (artist.yearsActiveStart <= activeBefore)
// //         ))    
// //         )
// //     }

// // 7.18
// case class User(name: String, city: Option[String], favoriteArtists: List[String])

// val users = List(
//     User("Alice", Some("Melbourne"), List("Bee Gees")),
//     User("Bob", Some("Lagos"), List("Bee Gees")),
//     User("Eve", Some("Tokyo"), List.empty),
//     User("Mallory", None, List("Metallica", "Bee Gees")),
//     User("Trent", Some("Buenos Aires"), List("Led Zeppelin"))
// )

// // def f1() = users.filter(user => user.city.forall(_.contains("Melbourne")))
// // def f2() = users.filter(user => user.city.exists(_.contains("Lagos")))
// // def f3() = users.filter(user => user.favoriteArtists.exists(_.contains( "Bee Gees")))
// // def f4() = users.filter(user => user.city.exists(_.startsWith("T")))
// // def f5() = users.filter(user => user.favoriteArtists.forall(_.length > 8))
// // def f6() = users.filter(user => user.favoriteArtists.exists(_.startsWith("M")))

// def f1(users: List[User]): List[User] = {
//     users.filter(_.city.forall(_ == "Melbourne"))
// }
// def f2(users: List[User]): List[User] = {
//     users.filter(_.city.contains("Lagos"))
// }
// def f3(users: List[User]): List[User] = {
//     users.filter(_.favoriteArtists.contains("Bee Gees"))
// }
// def f4(users: List[User]): List[User] = {
//     users.filter(_.city.exists(_.startsWith("T")))
// }
// def f5(users: List[User]): List[User] = {
//     users.filter(_.favoriteArtists.forall(_.length > 8))
// }
// def f6(users: List[User]): List[User] = {
//     users.filter(_.favoriteArtists.exists(_.startsWith("M")))
// }

// // 7.20
// case class PeriodInYears(start: Int, end: Option[Int])

// // case class Artist(name: String, genre: String, origin: Location, yearsActive: PeriodInYears)

// // val artists = List(
// //     Artist("Metallica", "Heavy Metal", Location("U.S."), PeriodInYears(1981, None)),
// //     Artist("Led Zeppelin", "Hard Rock", Location("England"), PeriodInYears(1968, Some(1980))),
// //     Artist("Bee Gees", "Pop", Location("England"), PeriodInYears(1958, Some(2003)))
// // )

// // def searchArtists(artists: List[Artist], genres: List[String], locations: List[String],
// //     searchByActiveYears: Boolean, activeAfter: Int, activeBefore: Int) = {
// //         artists.filter(artist =>
// //             (genres.isEmpty || genres.contains(artist.genre)) &&
// //             (locations.isEmpty || locations.contains(artist.origin.name)) &&
// //             (!searchByActiveYears || (
// //                 (artist.yearsActive.end.forall(activeEnd => activeEnd >= activeAfter)) &&
// //                 (artist.yearsActive.start <= activeBefore)
// //                 )
// //             ))
// //     }

// // 7.21
// enum MusicGenre {
//     case HeavyMetal
//     case Pop
//     case HardRock
// }

// import MusicGenre._

// val genre: MusicGenre = Pop
// val x: MusicGenre = HeavyMetal

// case class Artist(name: String, genre: MusicGenre, origin: Location, yearsInActive: PeriodInYears)

// val artists = List(
//     Artist("Metallica", HeavyMetal, Location("U.S."), PeriodInYears(1981, None)),
//     Artist("Led Zeppelin", HardRock, Location("England"), PeriodInYears(1968, Some(1980))),
//     Artist("Bee Gees", Pop, Location("England"), PeriodInYears(1958, Some(1003)))
// )

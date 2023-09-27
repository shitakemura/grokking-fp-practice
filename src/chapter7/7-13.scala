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

// 7.18

case class User(name: String, city: Option[String], favoriteArtists: List[String])

val users = List(
    User("Alice", Some("Melbourne"), List("Bee Gees")),
    User("Bob", Some("Lagos"), List("Bee Gees")),
    User("Eve", Some("Tokyo"), List.empty),
    User("Mallory", None, List("Metallica", "Bee Gees")),
    User("Trent", Some("Buenos Aires"), List("Led Zeppelin")),    
)

// forall
def f1(users: List[User]): List[User] = {
    users.filter(_.city.forall(_ == "Melbourne"))
}

val res_f1 = f1(users).map(_.name)

// contains
def f2(users: List[User]): List[User] = {
    users.filter(_.city.contains("Lagos"))
}

val res_f2 = f2(users).map(_.name)

// contains
def f3(users: List[User]): List[User] = {
    users.filter(_.favoriteArtists.contains("Bee Gees"))
}

val res_f3 = f3(users).map(_.name)

// exists, startsWith
def f4(users: List[User]): List[User] = {
    users.filter(_.city.exists(_.startsWith("T")))
}

val res_f4 = f4(users).map(_.name)

// forall
def f5(users: List[User]): List[User] = {
    users.filter(_.favoriteArtists.forall(_.length >= 8))
}

val res_f5 = f5(users).map(_.name)

// exists, startWith
def f6(users: List[User]): List[User] = {
    users.filter(_.favoriteArtists.exists(_.startsWith("M")))
}

val res_f6 = f6(users).map(_.name)

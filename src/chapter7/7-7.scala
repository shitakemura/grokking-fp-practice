// 7.7

// プリミティブ型に基づくモデルの問題
// 1. パラメータの順序にプログラマが注意する必要がある
// 2. パラメータを組み合わせることのさらなる意味をプログラマが知る必要がある
// 3. プログラマが一部のパラメータの値を有限集合にする必要がある
// 4. パラメータの型に対する意味をプログラマがさらに考え出し、理解し、伝える必要がある
// 5. 一部のパラメータは組み合わせて使った場合にのみ意味を持つことをプログラマが覚えておく必要がある

// 7.9

// newtype
// ゼロコストラッパーと呼ばれる

object model {
    opaque type Location = String
    object Location {
        def apply(value: String): Location = value
        extension(a: Location) def name: String = a
    }
}

import model._
val us: Location = Location("U.S.")
// val wontCompile: Location = "U.S."

// 7.10

case class Artist(
    name: String, 
    genre: String, 
    origin: Location,
    yearsActiveStart: Int,
    isActive: Boolean,
    yearsActiveEnd: Int
)

val a0 = Artist("Metallica", "Heavy Metal", Location("U.S."), 1981, true, 0)
// val a1 = Artist("Metallica", Location("U.S."), "Heavy Metal", 1981, true, 0)
// val a2 = Artist(Location("U.S."), "Heavy Metal", "Metallica", 1981, true, 0)

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
        (!searchByActiveYears || (artist.isActive ||
            artist.yearsActiveEnd >= activeAfter) &&
            (artist.yearsActiveStart <= activeBefore)))
}
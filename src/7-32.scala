// 7.32

// enum MusicGenre {
//     case Funk
//     case House
//     case HardRock
// }
// import MusicGenre._

// case class Artist(name: String)

// case class User(name: String)

// case class Song(name: String, artist: Artist)

// enum PlaylistKind {
//     case ByUser(user: User)
//     case ByArtist(artist: Artist)
//     case ByMusicGenre(genres: List[MusicGenre])
// }

// case class Playlist(name: String, kind: PlaylistKind, songs: List[Song])

// val fooFighters = Artist("Foo Fighters")

// val fp = Playlist("This is Foo Fighters", 
//     PlaylistKind.ByArtist(fooFighters), 
//     List(Song("BreakOut", fooFighters))
// )

// val daftPunk = Artist("Daft Punk")
// val chemicalBrothers = Artist("Chemical Brothers")

// val dfp = Playlist("Deep Focus",
//     PlaylistKind.ByMusicGenre(List(MusicGenre.Funk, MusicGenre.House)),
//     List(Song("One More Time", chemicalBrothers), Song("Hey Boy Hey Girl", chemicalBrothers))
// )

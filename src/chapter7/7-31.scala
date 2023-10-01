// 7.31

// 関数型プログラミングでは、振る舞いとデータが非常に明確に区別されている。
// 振る舞いは関数であり、データはイミュータブルな値である。

// 7.33

object model {
    opaque type User = String
    object User {
        def apply(name: String): User = name
    }

    opaque type Artist = String
    object Artist {
        def apply(name: String): Artist = name
    }

    case class Song(artist: Artist, title: String)

    enum MusicGenre {
        case House
        case Funk
        case HipHop
    }

    enum PlaylistKind {
        case CuratedByUser(user: User)
        case BasedOnArtist(artist: Artist)
        case BasedOnGenres(genres: Set[MusicGenre])
    }

    case class Playlist(name: String, kind: PlaylistKind, songs: List[Song])
}

import model._, model.MusicGenre._, model.PlaylistKind._

val fooFighters = Artist("Foo Fighters")
val playlist1 = Playlist(
    "This is Foo Fighters", 
    BasedOnArtist(fooFighters),
    List(
        Song(fooFighters, "Break Out"), 
        Song(fooFighters, "Learn To Fly")
    )   
)

val playlist2 = Playlist(
    "Deep Focus",
    BasedOnGenres(Set(House, Funk)),
    List(
        Song(Artist("Daft Punk"), "One More Time"),
        Song(Artist("The Chemical Brothers"), "Hey Boy Hey Girl")
    )
)

val playlist3 = Playlist(
    "My Playlist",
    CuratedByUser(User("Michal Plachta")),
    List(
        Song(fooFighters, "My Hero"),
        Song(Artist("Iron Maiden"), "The Tropper")
    )
)

def gatherSongs(playlists: List[Playlist], artist: Artist, genre: MusicGenre): List[Song] = {
    playlists.foldLeft(List.empty[Song])((songs, playlist) =>
        val matchingSongs = playlist.kind.match {
            case CuratedByUser(user) => playlist.songs.filter(_.artist == artist)
            case BasedOnArtist(playArtist) => if (playArtist == artist) playlist.songs else List.empty
            case BasedOnGenres(genres) => if (genres.contains(genre)) playlist.songs else List.empty 
        }
        songs.appendedAll(matchingSongs)
    )
}
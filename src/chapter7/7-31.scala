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
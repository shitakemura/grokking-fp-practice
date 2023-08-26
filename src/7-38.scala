// import scala.compiletime.ops.string
// // 7.38

// object model {
//     opaque type Location = String
//     object Location {
//         def apply(value: String): Location = value
//         extension(a: Location) def name: String = a
//     }

//     enum MusicGenre {
//         case HeavyMetal
//         case Pop
//         case HardRock
//     }

//     case class PeriodInYears(start: Int, end: Int)

//     enum YearsActive {
//         case StillActive(since: Int, previousPeriod: List[PeriodInYears])
//         case ActiveInPast(periods: List[PeriodInYears])
//     }

//     case class Artist(name: String, genre: MusicGenre, origin: Location, yearsActive: YearsActive)

//     enum SearchCondition {
//         case SearchByGenre(genres: List[MusicGenre])
//         case SearchByOrigin(locations: List[Location])
//         case SearchByActiveYears(period: PeriodInYears)
//         case SearchByActiveLength(howLong: Int, until: Int)
//     }
// }

// import model._, model.SearchCondition._, model.YearsActive._

// def periodOverlapsWithPeriods(checkedPeriod: PeriodInYears, periods: List[PeriodInYears]): Boolean = {
//     periods.exists(p =>
//         p.start <= checkedPeriod.end && p.end >= checkedPeriod.start    
//     )
// }

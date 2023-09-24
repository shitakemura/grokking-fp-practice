// 6.51

// Option

val optionYear: Option[Int] = Some(996)
val optionNoneYear: Option[Int] = None

// map
val optionMap = optionYear.map((_ * 2))
val optionNoneMap = optionNoneYear.map(_ * 2)

// flatten
val optionFlatten = Some(optionYear).flatten
val optionNoneFlatten = Some(optionNoneYear).flatten

// flatMap
val optionFlatMap = optionYear.flatMap(y => Some(y * 2))
val optionNoneFlatMap = optionNoneYear.flatMap(y => Some(y * 2))
val optionFlatMapToNone = optionYear.flatMap(y => None)
val optionNoneFlatMapToNone = optionNoneYear.flatMap(y => None)

// orElse
val optionOrElse = optionYear.orElse(Some(2020))
val optionNoneOrElse = optionNoneYear.orElse(Some(2020))
val optionOrElseNone = optionYear.orElse(None)
val optionNoneOrElseNone = optionNoneYear.orElse(None)

// toRight
val optionToRight = optionYear.toRight("no year given")
val optionNoneToRight = optionNoneYear.toRight("no year given")

// Either

val eitherYear: Either[String, Int] = Right(996)
val eitherNoYear: Either[String, Int] = Left("no year")

// map
val eitherYearMap = eitherYear.map(_ * 2)
val eitherNoYearMap = eitherNoYear.map(_ * 2)

// flatten
val eitherYearFlatten = Right(eitherYear).flatten
val eitherNoYearFlatten = Right(eitherNoYear).flatten

// flatMap
val eitherYearFlatMap = eitherYear.flatMap(y => Right(y * 2))
val eitherNoYearFlatMap = eitherNoYear.flatMap(y => Right(y * 2))
val eitherYearFlatMapToLeft = eitherYear.flatMap(y => Left("can't progress"))
val eitherNoYearFlatMapToLeft = eitherNoYear.flatMap(y => Left("can't progress"))

// orElse
val eitherYearOrElse = eitherYear.orElse(Right(2020))
val eitherNoYerOrElse = eitherNoYear.orElse(Right(2020))
val eitherYearOrElseLeft = eitherYear.orElse(Left("can't recover"))
val eitherNoYearOrElseLeft = eitherNoYear.orElse(Left("can't recover"))

// toOption
val eitherYearToOption = eitherYear.toOption
val eitherNoYearToOption = eitherNoYear.toOption
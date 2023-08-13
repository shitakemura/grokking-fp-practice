// 4.47
// def score(word: String): Int = word.replaceAll("a", "").length

// def bonus(word: String): Int = if (word.contains("c")) 5 else 0

// def penalty(word: String): Int = if (word.contains("s")) 7 else 0

// def highScoringWords(wordScore: String => Int): Int => List[String] => List[String] = {
//     higherThan => words => words.filter(word => wordScore(word) > higherThan)
// }

// def highScoringWords2(wordScore: String => Int)(higherThan: Int)(words: List[String]): List[String] = {
//     words.filter(word => wordScore(word) > higherThan)
// }

// val wordsWithScoreHigherThan: Int => List[String] => List[String] = highScoringWords(w => score(w) + bonus(w) - penalty(w))

// val words = List("ada", "haskell", "scala", "java", "rust")
// wordsWithScoreHigherThan(1)(words)

// val words2 = List("football", "f1", "hockey", "baseball")
// wordsWithScoreHigherThan(0)(words2)
// wordsWithScoreHigherThan(5)(words2)

// highScoringWords(w => score(w) + bonus(w) - penalty(w))(1)(words)

// 4.50

// def largerThan(n: Int): Int => Boolean = i => i > n
// List(5, 1, 2, 4, 0).filter(largerThan(4))

// def divisibleBy(n: Int): Int => Boolean = i => i % n == 0
// List(5, 1, 2, 4, 15).filter(divisibleBy(5))

// def lessThan(n: Int): String => Boolean = word => word.length < n
// List("scala", "ada").filter(lessThan(4))

// def numberOfS(word: String): Int = word.length - word.replaceAll("s", "").length
// def containsS(moreThan: Int): String => Boolean = word => numberOfS(word) >= moreThan
// List("rust", "ada").filter(containsS(2))

// def cumulativeScore(wordScore: String => Int, words: List[String]): Int = {
//     words.foldLeft(0) ((total, word) => total + wordScore(word))
// }

// cumulativeScore(w => score(w) + bonus(w) - penalty(w), List("rust", "java"))

// 4.51
// List(5, 1, 2, 4, 100).foldLeft(0) ((total, num) => total + num)

// List("scala", "rust", "ada").foldLeft(0) ((total, word) => total + word.length)

// List("scala", "haskell", "rust", "ada").foldLeft(0) ((total, word) => total + word.length - word.replaceAll("s", "").length)

// List(5, 1, 2, 4, 15).foldLeft(Int.MinValue) ((max, num) => if (num > max) num else max)

// 4.57

// case class ProgrammingLanguage(name: String, year: Int)

// val javalang = ProgrammingLanguage("Java", 1995)
// val scalalang = ProgrammingLanguage("scala", 2004)
// val languages = List(javalang, scalalang)

// languages.map(lang => lang.name)
// languages.filter(lang => lang.year > 2000)

// languages.map(_.name)
// languages.filter(_.year > 2000)
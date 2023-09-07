// 4.38

def score(word: String): Int = word.replaceAll("a", "").length

def bonus(word: String): Int = if (word.contains("c")) 5 else 0

def penalty(word: String): Int = if (word.contains("s")) 7 else 0

def highScoringWords(wordScore: String => Int, words: List[String]): Int => List[String] = {
    higherThan => words.filter(word => wordScore(word) > higherThan)
}

val words = List("ada", "haskell", "scala", "java", "rust")
val wordsWithScoreHigherThan: Int => List[String] = {
    highScoringWords(w => score(w) + bonus(w) - penalty(w), words)
}
val res1 = wordsWithScoreHigherThan(1)
val res0 = wordsWithScoreHigherThan(0)
val res5 = wordsWithScoreHigherThan(5)

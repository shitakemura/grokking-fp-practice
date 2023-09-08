// 4.45

def score(word: String): Int = word.replaceAll("a", "").length
def bonus(word: String): Int = if (word.contains("c")) 5 else 0
def penalty(word: String): Int = if (word.contains("s")) 7 else 0
def highScoringWords(wordScore: String => Int): Int => List[String] => List[String] = {
    higherThan => words => words.filter(word => wordScore(word) > higherThan)
}


val wordsWithScoreHigherThan: Int => List[String] => List[String] = {
    highScoringWords(word => score(word) + bonus(word) - penalty(word))
}

val words = List("ada", "haskell", "scala", "java", "rust")
val words2 = List("football", "f1", "hockey", "basketball")

val res = wordsWithScoreHigherThan(1)(words)
val res2 = wordsWithScoreHigherThan(0)(words2)
val res3 = wordsWithScoreHigherThan(5)(words2)
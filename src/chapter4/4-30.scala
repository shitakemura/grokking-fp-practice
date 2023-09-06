// 4.30

def score(word: String): Int = {
    word.replaceAll("a", "").length
}

def bonus(word: String): Int = {
    if (word.contains("c")) 5 else 0
}

def penalty(word: String): Int = {
    if (word.contains("s")) 7 else 0
}

def highScoringWords(wordScore: String => Int, words: List[String]): List[String] = {
    words.filter(word => wordScore(word) > 1)
}

val words = List("ada", "haskell", "scala", "java", "rust")
val res = highScoringWords(w => score(w) + bonus(w) - penalty(w), words)
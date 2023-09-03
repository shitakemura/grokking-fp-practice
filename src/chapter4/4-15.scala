// 4.15

def score(word: String): Int = word.replaceAll("a", "").length

def rankedWords(wordScore: String => Int, words: List[String]): List[String] = {
    def negativeScore(word: String): Int = -score(word)
    words.sortBy(negativeScore)
}

val words = List("rust", "java")
val r = rankedWords(score, words)

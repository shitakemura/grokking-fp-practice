// 4.20

// 関数毎に１つのビジネス要件を実装することに焦点を合わせる（複数のことを行わない）

def score(word: String): Int = word.replaceAll("a", "").length

def bonus(word: String): Int = if (word.contains("c")) 5 else 0

val words = List("ada", "scala", "java", "rust", "haskell")

def rankedWords(wordScore: String => Int, words: List[String]): List[String] = {
    words.sortBy(wordScore).reverse
}

val res = rankedWords(w => score(w) + bonus(w), words)

// 4.22

def penalty(word: String): Int = if (word.contains("s")) 7 else 0

val resWithPenalty = rankedWords(w => score(w) + bonus(w) - penalty(w), words)
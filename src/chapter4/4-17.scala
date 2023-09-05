// 4.17

def len(s: String): Int = s.length
val r1 = List("scala", "rust", "ada").sortBy(len)

def numOfS(s: String): Int = s.length - s.replaceAll("s", "").length
val r2 = List("rust", "ada").sortBy(numOfS)

def negative(i: Int): Int = -i
val r3 = List(5, 1, 2, 4, 3).sortBy(negative)

def negativeNumOfS(s: String): Int = negative(numOfS(s))
val r4 = List("ada", "rust").sortBy(negativeNumOfS)

// 4.18

def score(word: String): Int = word.replaceAll("a", "").length
val words = List("ada", "scala", "java", "rust", "haskell")

def rankedWords(wordScore: String => Int, words: List[String]): List[String] = {
    words.sortBy(wordScore).reverse
}

val res = rankedWords(score, words)

def scoreWithBonus(word: String): Int = {
    val base = score(word)
    if (word.contains("c")) base + 5 else base
}

val resBonus = rankedWords(scoreWithBonus, words)
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

// 4.33

def len(word: String): Int = word.length
val res1 = List("scala", "rust", "ada").filter(word => len(word) < 5)

def numOfS(word: String): Int = word.length - word.replaceAll("s", "").length
val res2 = List("rust", "ada").filter(w => numOfS(w) >= 3)

def odd(num: Int): Boolean = num % 2 == 1
val res3 = List(5, 1, 2, 4, 0).filter(odd)

def largerThanFour(num: Int): Boolean = num > 4
val res4 = List(5, 1, 4, 2, 0).filter(largerThanFour)
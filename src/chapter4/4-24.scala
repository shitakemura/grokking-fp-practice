// 4.24

def score(word: String): Int = word.replaceAll("a", "").length

def wordScores(wordScore: String => Int, words: List[String]): List[Int] = {
    words.map(wordScore)
}

val res = wordScores(score, List("rust", "java"))

// 4.28

def len(word: String): Int = word.length
val res1 = List("scala", "rust", "ada").map(len)

def numOfS(word: String): Int = word.length - word.replaceAll("s", "").length
val res2 = List("rust", "ada").map(numOfS)

def negative(num: Int): Int = -num
val res3 = List(5, 1, 2, 4, 0).map(negative)

def double(num: Int): Int = num * 2
val res4 = List(5, 1, 2, 4, 0).map(double)
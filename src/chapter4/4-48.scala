// 4.48

def highScoringWords(wordScore: String => Int) (higherThan: Int)(words: List[String]): List[String] = {
    words.filter(word => wordScore(word) > higherThan)
}

// カリー化(currying)

// def f(a: A, b: B, c: C): D

// def f(a: A): B => C => D

// def f(a: A)(b: B)(c: C): D

// 4.50

def largerThan(n: Int)(i: Int): Boolean = i > n
val res1 = List(5, 1, 2, 4, 0).filter(i => largerThan(4)(i))
val res2 = List(5, 1, 2, 4, 0).filter(largerThan(4))

def divisibleBy(n: Int)(i: Int): Boolean = i % n == 0
val res3 = List(5, 1, 2, 4, 15).filter(i => divisibleBy(5)(i))
val res4 = List(5, 1, 2, 4, 15).filter(divisibleBy(5))

def shorterThan(n: Int)(word: String): Boolean = word.length < 4
val res5 = List("scala", "ada").filter(shorterThan(4))

def numberOfS(word: String): Int = word.length - word.replaceAll("s", "").length
def containsS(moreThan: Int)(word: String): Boolean = numberOfS(word) > moreThan
val res6 = List("rust", "ada").filter(containsS(2))
val res7 = List("rust", "ada").filter(word => containsS(0)(word))
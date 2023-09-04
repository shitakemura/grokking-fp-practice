// 4.17

def len(s: String): Int = s.length
val r1 = List("scala", "rust", "ada").sortBy(len)

def numOfS(s: String): Int = s.length - s.replaceAll("s", "").length
val r2 = List("rust", "ada").sortBy(numOfS)

def negative(i: Int): Int = -i
val r3 = List(5, 1, 2, 4, 3).sortBy(negative)

def negativeNumOfS(s: String): Int = negative(numOfS(s))
val r4 = List("ada", "rust").sortBy(negativeNumOfS)
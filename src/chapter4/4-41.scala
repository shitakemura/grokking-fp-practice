// 4.41

val res = List(5, 1, 2, 4, 0).filter(i => i > 4)

def largerThan(num: Int): Int => Boolean = value => value > num

val res1 = List(5, 1, 2, 4, 0).filter(largerThan(4))
val res2 = List(5, 1, 2, 4, 0).filter(largerThan(1))

def dividedBy(num: Int): Int => Boolean = {
    value => value % num == 0
}

val res3 = List(5, 1, 2, 4, 15).filter(dividedBy(5))
val res4 = List(5, 1, 2, 4, 15).filter(dividedBy(2))

def shorterThan(num: Int): String => Boolean = {
    word => word.length < num 
}

val res5 = List("scala", "ada").filter(shorterThan(4))
val res6 = List("scala", "ada").filter(shorterThan(7))

def containsS(num: Int): String => Boolean = {
    word => word.length - word.replaceAll("s", "").length >= num
}

val res7 = List("rust", "ada").filter(containsS(3))
val res8 = List("rust", "ada").filter(containsS(1))
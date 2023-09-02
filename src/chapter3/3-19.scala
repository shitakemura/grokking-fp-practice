// 3.19

def firstTwo(list: List[String]): List[String] = {
    list.slice(0, 2)
}

val r1 = firstTwo(List("a", "b", "c"))

def lastTwo(list: List[String]): List[String] = {
    list.slice(list.size - 2, list.size)
}

val r2 = lastTwo(List("a", "b", "c"))

def movedFirstTwoToTheEnd(list: List[String]): List[String] = {
    val firstTwo = list.slice(0, 2)
    val other = list.slice(2, list.size)
    other.appendedAll(firstTwo)
}

val r3 = movedFirstTwoToTheEnd(List("a", "b", "c"))

def insertBeforeLast(list: List[String], element: String): List[String] = {
    val withoutLast = list.slice(0, list.size - 1)
    val last = list.slice(list.size - 1, list.size)
    withoutLast.appended(element).appendedAll(last)
}

val f4 = insertBeforeLast(List("a", "b"), "c")

// 関数型プログラミングとはイミュータブルな値を操作する純粋関数を使うプログラミングである
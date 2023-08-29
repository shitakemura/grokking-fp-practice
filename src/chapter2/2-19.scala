object TipCalculator {
    def getTipPercentage(names: List[String]): Int = {
        if (names.size > 5) {
            20
        } else if (names.size > 0) {
            10
        } else {
            0
        }
    }
}

val threeNames = List("Alice", "Bob", "Charlie")
val res1 = TipCalculator.getTipPercentage(threeNames)

val sixNames = List("Alice", "Bob", "Charlie", "Daniel", "Emily", "Frank")
val res2 = TipCalculator.getTipPercentage(sixNames)

val noName = List.empty
val res3 = TipCalculator.getTipPercentage(noName)
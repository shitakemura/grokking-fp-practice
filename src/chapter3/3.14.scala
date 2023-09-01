// 3.14
val ab = List("a", "b")
val cd = List("c", "d")
val abcd = ab.appendedAll(cd)

val abcd2 = List("a", "b", "c", "d")
val bc = abcd2.slice(1, 3)

// 3.15
def abbreviate(name: String): String = {
    val initial = name.substring(0, 1)
    val separator = name.indexOf(' ')
    val lastName = name.substring(separator + 1)
    initial + ". " + lastName
}

val a1 = abbreviate("Alonzo Church")
val a2 = abbreviate("A. Church")
val a3 = abbreviate("A Church")
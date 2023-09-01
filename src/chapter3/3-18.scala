// 3.18
val abcd = List("a", "b", "c", "d")
val bc = abcd.slice(1, 3)

val ab = List("a", "b")
val c = "c"
val abc = ab.appended(c)

val cd = List("c", "d")
val abcd2 = ab.appendedAll(cd)

def replan(plan: List[String], newCity: String, beforeCity: String): List[String] = {
    val beforeCityIndex = plan.indexOf(beforeCity)
    val citiesBefore = plan.slice(0, beforeCityIndex)
    val citiesAfter = plan.slice(beforeCityIndex, plan.size)
    citiesBefore.appended(newCity).appendedAll(citiesAfter)
}

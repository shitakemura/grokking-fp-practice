// 直積型
// 直積型はイミュータブル

case class ProgrammingLanguage(name: String, year: Int)

val javalang = ProgrammingLanguage("java", 1995)
val scalalang = ProgrammingLanguage("scala", 2004)

val res1 = javalang.name
val res2 = javalang.year
val res3 = scalalang.name
val res4 = scalalang.year

val languages = List(javalang, scalalang)
val resA = languages.map(lang => lang.name)
val resB = languages.filter(lang => lang.year > 2000)

val resC = languages.map(_.name)
val resD = languages.filter(_.year > 2000)

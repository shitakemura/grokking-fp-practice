// 関数型プログラミング: イミュータブルな値を操作する純粋関数を使うプログラミング

// 参照透過性: 同じ引数を渡した場合、同じ値を返す

// イミュータブルな値: 一度作成された値は決して変更できないことを保証する手法

// 3.12
def replan(plan: List[String], newCity: String, beforeCity: String): List[String] = {
    val beforeCityIndex = plan.indexOf(beforeCity)
    val citiesBefore = plan.slice(0, beforeCityIndex)
    val citiesAfter = plan.slice(beforeCityIndex, plan.size)
    citiesBefore.appended(newCity)
}

// 3.13
val appleBook = List("Apple", "Book")
val appleBookMango = appleBook.appended("Mango")
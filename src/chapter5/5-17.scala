// 5.17

// 文: プログラムの状態を変更しなければ意味を持たない言語構造
// 式: グローバルな状態を操作せず、常に何かを返し、何回実行しても常に同じ結果を返す
// 関数型プログラミングは式を使うプログラミング。関数型プログラマは文を使わない

val xs = List(1, 2, 3, 4, 5)
val result = for {
    x <- xs
} yield x * x

val res19 = for {
    a <- List[Int](1, 2)
    b <- List[Int](10, 100)
    c <- List[Double](0.5, 0.7)
    d <- List[Int](3)
} yield (a * b * c + d).toString + "km"


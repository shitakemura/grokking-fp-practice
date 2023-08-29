// 2.15

// 純粋関数
// - 戻り値は常に１つだけ
// - 引数だけを使う
// - 既存の値を変更しない

// 参照透過性
// - 関数がその引数だけを使って値を計算し、既存の値を変更しない場合、その関数は参照透過性を持つ

// 2.18

object ShoppingCart {
    def getDiscountPercentage(items: List[String]): Int = {
        if (items.contains("Book")) {
            5
        } else {
            0
        }
    }
}

val justApple = List("Apple")
val res1 = ShoppingCart.getDiscountPercentage(justApple)

val appleAndBook = List("Apple", "Book")
val res2 = ShoppingCart.getDiscountPercentage(appleAndBook)

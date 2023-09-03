// 純粋関数の関数はその引数にのみ基づいて戻り値を計算する
// 関数のシグネチャを見るだけで、関数内で行われることを推測できる必要がある

// 4.13

def inc(x: Int): Int = x + 1
val r1 = inc(2)

def score(word: String): Int = {
    word.replace("a", "").length
}
val r2 = score("java")

val words = List("rust", "java")
val r3 = words.sortBy(score)

val r4 = List("rust", "java").sortBy(score)


// 4.51

// 高階関数(higher-order function): 別の関数を受け取ったり返したりする関数

// 4.52

def score(word: String): Int = word.replaceAll("a", "").length

def bonus(word: String): Int = if (word.contains("c")) 5 else 0

def penalty(word: String): Int = if (word.contains("s")) 7 else 0

def cumulativeScore(wordScore: String => Int, words: List[String]): Int = {
    words.foldLeft(0)((total, word) => total + wordScore(word))
}

val res = cumulativeScore(w => score(w) + bonus(w) - penalty(w), List("rust", "java"))
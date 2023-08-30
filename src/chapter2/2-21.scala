// 2.21

def increment(x: Int): Int = {
    x + 1
}

// increment(6) == 7
// increment(0) == 1
// increment(-6) == -5
// increment(Integer.MAX_VALUE - 1) == Integer.MAX_VALUE 

def add(a: Int, b: Int): Int = {
    a + b
}

// add(2, 5) == 7
// add(-2, 5) == 3

def wordScore(word: String): Int = {
    word.replaceAll("a", "").length
}

// wordScore("Scala") == 3
// wordScore("function") == 8
// wordScore("") == 0

def getTipPercentage(names: List[String]): Int = {
    if (names.size > 5) 20
    else if (names.size > 0) 10
    else 0
}

// getTipPercentage(List("Alice", "Bob")) == 10
// getTipPercentage(List("Alice", "Bob", "Charlie", "Danny", "Emily", "Wojtek")) == 20
// getTipPercentage(List.empty) == 0

def getFirstCharacter(s: String): Char = {
    if (s.length > 0) s.charAt(0)
    else ' '
}

// getFirstCharacter("Ola") == 'O'
// getFirstCharacter("") == ' '
// getFirstCharacter(" Ha! ") == ' '
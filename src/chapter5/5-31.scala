// 5.31

case class Event(name: String, start: Int, end: Int)

// nullはシグネチャに嘘をつかせる
def parse(name: String, start: Int, end: Int): Event = {
    if (name.size > 0 && end < 3000 && start <= end) Event(name, start, end) else null
}

val res31_1 = parse("Apollo Program", 1961, 1972)
val res31_2 = parse("", 1939, 1945)

// 5.32

// Option型: Option[A] - Some[A] or None

def parse(name: String, start: Int, end: Int): Option[Event] = {
    if (name.size > 0 && end < 3000 && start <= end)
        Some(Event(name, start, end))
    else
        None
}
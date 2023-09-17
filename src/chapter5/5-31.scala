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

// 5.33

case class Event(name: String, start: Int, end: Int)

def validateName(name: String): Option[String] = {
    if (name.size > 0) Some(name) else None
}

def validateEnd(end: Int): Option[Int] = {
    if (end < 3000) Some(end) else None
}

def validateStart(start: Int, end: Int): Option[Int] = {
    if (start <= end) Some(start) else None
}

def parse(name: String, start: Int, end: Int): Option[Event] = {
    for {
        validName <- validateName(name)
        validEnd <- validateEnd(end)
        validStart <- validateStart(start, end)
    } yield Event(validName, validStart, validEnd)
}

val res33_1 = parse("Apollo Program", 1961, 1972)
val res33_2 = parse("", 1939, 1945)

// 5.34

def validateLength(start: Int, end: Int, minLength: Int): Option[Int] = {
    val length = end - start
    if (length >= minLength) Some(length) else None
}

def parseLongEvent(name: String, start: Int, end: Int, minLength: Int): Option[Event] = {
    for {
        validName <- validateName(name)
        validEnd <- validateEnd(end)
        validStart <- validateStart(start, end)
        validLength <- validateLength(start, end, minLength)
    } yield Event(validName, validStart, validEnd)
}

val res34_1 = parseLongEvent("Apollo Program", 1961, 1972, 10)

val res34_2 = parseLongEvent("World War 2", 1939, 1945, 10)

val res34_3 = parseLongEvent("", 1939, 1945, 10)

val res34_4 = parseLongEvent("Apollo Program", 1972, 1961, 10)
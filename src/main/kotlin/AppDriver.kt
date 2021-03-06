import Color.*
import java.io.BufferedReader
import java.io.StringReader
import java.text.NumberFormat
import java.util.*

class Greeter(private val name: String = "World") {
    fun greet() {
        println("Hello, $name!")
    }
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c in '0'..'9'

// Using checks as when branches
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "wtf is that."
}

fun readNumber (reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }

    println(number)
}

fun main(args: Array<String>) {
    Greeter().greet()
    println(ColorDetail.BLUE.rgb())
    println(Color.BLUE)
    println(getRainbowMnemonic(Color.BLUE))
    println(getWarmth(Color.ORANGE))
    println(mixOptimized(BLUE, YELLOW))
    println(mix(BLUE, YELLOW))

    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    println(isLetter('q'))
    println(isNotDigit('x'))
    println(recognize('8'))

    // Strings are compared alphabetically when in a range
    println("Kotlin" in "Java".."Scala")
    // Can also be used to check set membership
    println("Kotlin" in setOf("Java", "Scala"))

    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }

    val reader = BufferedReader(StringReader("Not a number"))
    readNumber(reader)
}

fun getRainbowMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

// Combining options
fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

//When the package is imported via (.*), you can just use the enum names
fun simplifiedGetWarmth(color: Color) = when(color) {
    RED, ORANGE, YELLOW -> "warm"
    GREEN -> "neutral"
    BLUE, INDIGO, VIOLET -> "cold"
}

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(RED, YELLOW) -> ORANGE
    setOf(YELLOW, BLUE) -> GREEN
    setOf(BLUE, VIOLET) -> INDIGO
    else -> throw Exception("Dirty Color")
}

// Ugly, but more performant
fun mixOptimized(c1: Color, c2: Color) = when {
    (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
    (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
    (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
    else -> throw Exception("Dirty Color")
}
@file:JvmName("StringFunctions")

package strings

const val UNIX_LINE_SEPERATOR = "\n"

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

// Extending String class with a function to get the last character
val String.lastChar: Char
    get() = get(length - 1)

// Stringbuilder version needs to be a var, since the contents can be modified
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }
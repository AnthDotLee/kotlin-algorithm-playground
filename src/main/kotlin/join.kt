@file:JvmName("StringFunctions")

package strings

const val UNIX_LINE_SEPERATOR = "\n"

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

// Extending String class with a function to get the last character
fun String.lastChar(): Char = this.get(this.length - 1)
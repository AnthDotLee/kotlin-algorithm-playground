class Collections {

    fun main(args: Array<String>) {
        val set = hashSetOf(1, 7, 53)

        val list = arrayListOf(1, 7, 53)
        val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

        // Kotlin just uses Java libraries
        println(set.javaClass)
        println(list.javaClass)
        println(map.javaClass)

        // Some additional functions Kotlin supplies on top off the Java ones
        val strings = listOf("first", "second", "third")
        println(strings.last())

        val numbers = setOf(1, 14, 2)
        println(numbers.max())

        val list2 = listOf(1, 2, 3)
        println(list2) // Invokes toString()
    }

    // Building a version of the Kotlin string utility manually
    fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
    ): String {

        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }

}
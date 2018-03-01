package y2017

fun main(args: Array<String>) {
    val passphrases = input4.split("\n").map { it.split(" ") }

    val result1 = passphrases.filter { it.toSet().size == it.size }.count()
    println("Part 1: $result1")

    val sortedPassphrases = passphrases.map { it.map { it.sort() } }

    val result2 = sortedPassphrases.filter { it.toSet().size == it.size }.count()
    println("Part 2: $result2")
}

fun String.sort(): String {
    val carr = this.toCharArray(); carr.sort(); return String(carr)
}
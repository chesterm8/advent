package y2017

fun main(args: Array<String>) {
    val banks = input6.split("\t").map { it.toInt() }
    val seenConfigs = mutableSetOf<List<Int>>()
    var counter = 0
    var currentConfig = listOf<Int>()
    while (currentConfig !in seenConfigs) {
        var (index, value) = banks.withIndex().maxBy { it.value }!!

        counter++
    }

    println("Result 1: $counter")
}
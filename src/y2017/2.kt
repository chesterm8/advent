package y2017

fun main(args: Array<String>) {
    val map: List<List<Int>> = input2
            .split("\n")
            .map { it.split("\t") }
            .map { it.map { it.toInt() } }
    val result1 = map.map { it.max()!! - it.min()!! }.sum()
    println("Result 1: $result1")
}
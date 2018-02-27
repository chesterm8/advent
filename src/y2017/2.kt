package y2017

fun main(args: Array<String>) {
    val map: List<List<Int>> = input2
            .split("\n")
            .map { it.split("\t") }
            .map { it.map { it.toInt() } }
    val result1 = map.map { it.max()!! - it.min()!! }.sum()
    println("Result 1: $result1")

    val result2 = map.map { list ->
        list.map { v1 -> list.map { v2 -> Pair(v1, v2) } }
                .flatten()
                .filter { it.first != it.second }
                .first { it.first % it.second == 0 }
                .run { this.first / this.second }
    }.sum()
    println("Result 2: $result2")
}
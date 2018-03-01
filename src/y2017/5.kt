package y2017

fun main(args: Array<String>) {
    val instructions = input5.split("\n").map { it.toInt() }

    val count1 = getCount(instructions.toMutableList(), ::part1Function)
    println("Part 1: $count1")

    val count2 = getCount(instructions.toMutableList(), ::part2Function)
    println("Part 1: $count2")
}

private fun getCount(instructions: MutableList<Int>, function: (Int) -> Int): Int {
    var count = 0
    var pointer = 0
    while (pointer in instructions.indices) {
        instructions[pointer] = instructions[pointer].let {
            pointer += it
            count++
            function(it)
        }
    }
    return count
}

private fun part1Function(it: Int) = it + 1
private fun part2Function(it: Int) = if (it >= 3) it - 1 else it + 1
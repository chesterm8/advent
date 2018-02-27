package y2017

fun Char.charToInt() = this.toString().toInt()

fun main(args: Array<String>) {
    var previous = input1.get(input1.lastIndex)
    val result1 = input1.filter {
        val accept = it == previous
        previous = it
        accept
    }.sumBy { it.charToInt() }
    println("Part 1: $result1")

    val stepSize = input1.length / 2
    val result2 = input1.filterIndexed { index, char ->
        val oppositeIndex = (index + stepSize) % input1.length
        char == input1.get(oppositeIndex)
    }.sumBy { it.charToInt() }
    println("Part 2: $result2")
}
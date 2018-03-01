package y2017

import kotlin.math.*

fun main(args: Array<String>) {
    val base = ceil(sqrt(input3.toDouble())).toInt() //Level of the loop we are on
    val stepsToThisLoop = base / 2
    val total = (base + 1).toDouble().pow(2) //Highest number in this loop
    val offset = total - input3 //Distance of current number from max in this loop
    val stepsToCorner = offset % base //Number of steps required to get from our number to corner
    val stepsToCentre = abs(((base + 1) / 2) - stepsToCorner) //Number of steps to get from our number to centre
    val result1 = floor(stepsToThisLoop + stepsToCentre).toInt()

    println("Result 1: $result1")

    println("Result 2: " + calcPart2(base))
}

private fun calcPart2(base: Int): Int {
    val loop = MutableList(base, { MutableList(base, { 0 }) })
    var x = base / 2
    var y = base / 2
    loop[x][y] = 1
    var squareSize = 2
    while (loop[x][y] < input3) {

        x++
        //Go up
        var guard = y + squareSize
        while (y < guard) {
            loop[x][y] = sumSurroundingCells(loop, x, y)
            y++
            if (loop[x][y] > input3) {
                return loop[x][y]
            }
        }
        y--

        //Go left
        guard = x - squareSize
        while (x > guard) {
            x--
            loop[x][y] = sumSurroundingCells(loop, x, y)
            if (loop[x][y] > input3) {
                return loop[x][y]
            }
        }

        //Go down
        guard = y - squareSize
        while (y > guard) {
            y--
            loop[x][y] = sumSurroundingCells(loop, x, y)
            if (loop[x][y] > input3) {
                return loop[x][y]
            }
        }

        //Go right
        guard = x + squareSize
        while (x < guard) {
            x++
            loop[x][y] = sumSurroundingCells(loop, x, y)
            if (loop[x][y] > input3) {
                return loop[x][y]
            }
        }
        squareSize += 2
    }

    return -1
}

fun sumSurroundingCells(loop: MutableList<MutableList<Int>>, x: Int, y: Int): Int {
    return loop[x + 1][y] + loop[x + 1][y + 1] + loop[x][y + 1] + loop[x - 1][y + 1] + loop[x - 1][y] + loop[x - 1][y - 1] + loop[x][y - 1] + loop[x + 1][y - 1]
}

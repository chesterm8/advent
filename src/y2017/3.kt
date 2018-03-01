package y2017

import kotlin.math.*

fun main(args: Array<String>) {
    val base = ceil(sqrt(input3.toDouble())) //Level of the loop we are on
    val stepsToThisLoop = base / 2
    val total = (base + 1).pow(2) //Highest number in this loop
    val offset = total - input3 //Distance of current number from max in this loop
    val stepsToCorner = offset % base //Number of steps required to get from our number to corner
    val stepsToCentre = abs(((base + 1) / 2) - stepsToCorner) //Number of steps to get from our number to centre
    val result1 = floor(stepsToThisLoop + stepsToCentre).toInt()

    println("Result 1: $result1")
}
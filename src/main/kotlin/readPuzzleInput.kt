import java.io.File

fun readPuzzleInput(number: Int): List<String> = readPuzzleInput("day_$number.txt")
private fun readPuzzleInput(filename: String): List<String> = File(ClassLoader.getSystemResource(filename).file).readLines()
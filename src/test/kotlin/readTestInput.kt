import java.io.File

fun readTestInput(number: Int, variation: Int = 0): List<String> = readTestInput("test_${number}_$variation.txt")
private fun readTestInput(filename: String): List<String> = File(ClassLoader.getSystemResource(filename).file).readLines()
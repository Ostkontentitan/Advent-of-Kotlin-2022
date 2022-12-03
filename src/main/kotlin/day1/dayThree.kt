package day1

import readPuzzleInput

fun dayThree(input: List<String> = readPuzzleInput(3)): Pair<Int, Int> {
    val partOneSum = input.fold(0) { acc, line ->
        val middle = line.length / 2
        val compA = line.slice(0 until middle).toSet()
        val compB = line.slice(middle..line.lastIndex).toSet()
        val commonChar = compA.intersect(compB).first()
        val charValue = commonChar.toItemCode()
        acc + charValue
    }

    val partTwoSum = input.map { it.toSet() }.windowed(3, 3).sumOf {
        it.fold(emptySet<Char>()) { acc, rucksack ->
            if (acc.isEmpty()) rucksack else acc.intersect(rucksack)
        }.first().toItemCode()
    }

    return partOneSum to partTwoSum
}

private fun Char.toItemCode(): Int = when {
    isLowerCase() -> code - LOWERCASE_OFFSET
    isUpperCase() -> code - UPPERCASE_OFFSET
    else -> throw IllegalArgumentException()
}

private const val LOWERCASE_OFFSET = 96
private const val UPPERCASE_OFFSET = 38
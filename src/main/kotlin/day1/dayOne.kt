package day1

import readPuzzleInput

fun dayOne(input: List<String> = readPuzzleInput(1)): Pair<Int, Int> {
    val elves = input.fold((mutableListOf(0))) { elves, snack ->
        if (snack.isEmpty()) {
            elves.add(0)
        } else {
            elves[elves.lastIndex] = elves.last() + Integer.parseInt(snack)
        }
        elves
    }

    val sorted = elves.sorted()

    return sorted.last() to sorted.takeLast(3).sum()
}
package day1

import readPuzzleInput

fun dayFour(input: List<String> = readPuzzleInput(4)): Pair<Int, Int> {
    val sectionPairs: List<SectionPair> = input.map { line ->
        val sections = line.split(",")
        val (sectionA, sectionB) = sections.map { rangeString ->
            val (from, to) = rangeString.split("-").map { Integer.parseInt(it) }
            (from..to).toSet()
        }

        sectionA to sectionB
    }

    val fullyOverlapping = sectionPairs.count { (a, b) ->
        a.containsAll(b) || b.containsAll(a)
    }

    val overlapping = sectionPairs.count { (a, b) ->
        a.intersect(b).isNotEmpty()
    }

    return fullyOverlapping to overlapping
}

private typealias SectionPair = Pair<Set<Int>, Set<Int>>
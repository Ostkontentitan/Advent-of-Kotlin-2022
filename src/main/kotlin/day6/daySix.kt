package day6

import readPuzzleInput

fun daySix(input: List<String> = readPuzzleInput(6)): Pair<Int, Int> {
    return input.first().endIndexOfUniqueSequenceWithSize(4) to input.first().endIndexOfUniqueSequenceWithSize(14)
}

fun String.endIndexOfUniqueSequenceWithSize(uniqueSize: Int): Int {
    var windowStart = 0
    var windowEnd = 1

    while(windowEnd - windowStart < uniqueSize) {
        val nextChar = this[windowEnd]
        val index = this.subSequence(windowStart, windowEnd).indexOf(nextChar)

        if(index != -1) {
            windowStart += index + 1
        } else {
            windowEnd += 1
        }
    }

    return windowEnd
}
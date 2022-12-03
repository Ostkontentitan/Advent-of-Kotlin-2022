package day1

import readPuzzleInput

fun dayTwo(input: List<String> = readPuzzleInput(2)): Pair<Int, Int> {
    val totalScore = input.sumOf {
        val otherRPS = it[0].toRPS()
        val myRPS = it[2].toRPS()
        myRPS.scoreAgainst(otherRPS)
    }

    val totalScoreTwo = input.sumOf {
        val otherRPS = it[0].toRPS()
        val result = it[2].xyzToResult()
        val myRPS = rpsForResultAgainst(result, otherRPS)
        myRPS.scoreAgainst(otherRPS)
    }

    return totalScore to totalScoreTwo
}

private fun rpsForResultAgainst(result: DesiredResult, otherRPS: RPS): RPS = when (result) {
    DesiredResult.DRAW -> otherRPS
    DesiredResult.LOOSE -> otherRPS.beats()
    else -> otherRPS.loosesAgainst()
}

private enum class RPS(val score: Int) {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);
}

private enum class DesiredResult {
    LOOSE, DRAW, WIN
}

private fun RPS.beats(): RPS = when (this) {
    RPS.ROCK -> RPS.SCISSORS
    RPS.PAPER -> RPS.ROCK
    RPS.SCISSORS -> RPS.PAPER
}

private fun RPS.loosesAgainst(): RPS = when (this) {
    RPS.ROCK -> RPS.PAPER
    RPS.PAPER -> RPS.SCISSORS
    RPS.SCISSORS -> RPS.ROCK
}

private fun RPS.scoreAgainst(other: RPS): Int {
    val resultScore = when (other) {
        this -> DRAW_SCORE
        this.beats() -> WIN_SCORE
        else -> LOOSE_SCORE
    }

    return resultScore + this.score
}

private fun Char.toRPS(): RPS = when (this) {
    'A' -> RPS.ROCK
    'B' -> RPS.PAPER
    'C' -> RPS.SCISSORS
    'X' -> RPS.ROCK
    'Y' -> RPS.PAPER
    'Z' -> RPS.SCISSORS
    else -> throw IllegalArgumentException()
}

private fun Char.xyzToResult(): DesiredResult = when (this) {
    'X' -> DesiredResult.LOOSE
    'Y' -> DesiredResult.DRAW
    'Z' -> DesiredResult.WIN
    else -> throw IllegalArgumentException()
}

private const val LOOSE_SCORE = 0
private const val DRAW_SCORE = 3
private const val WIN_SCORE = 6
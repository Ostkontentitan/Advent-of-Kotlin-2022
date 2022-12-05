package day1

import readPuzzleInput

fun dayFive(input: List<String> = readPuzzleInput(5)): Pair<String, String> {
    val stacksInput = input.subList(0, input.indexOfFirst { it.isEmpty() })
    val commandsInput = input.subList(input.indexOfFirst { it.isEmpty() } + 1, input.size)

    val stacksA = buildStartingStack(stacksInput)
    moveCrates(stacksA, commandsInput, CrateMoverVersion.V9000)

    val stacksB = buildStartingStack(stacksInput)
    moveCrates(stacksB, commandsInput, CrateMoverVersion.V9001)

    return stacksA.topCratesString() to stacksB.topCratesString()
}

private fun List<ArrayDeque<Char>>.topCratesString() = this.joinToString("") { (it.lastOrNull() ?: "").toString() }

private fun buildStartingStack(stacksInput: List<String>): List<ArrayDeque<Char>> {
    val charIndices: List<Int> = (1..9).map { stacksInput.last().indexOf(it.toString()) }.filterNot { it == -1 }
    val stacks = charIndices.map { ArrayDeque<Char>() }

    (stacksInput.lastIndex -1 downTo 0).forEach { stackLevel ->
        charIndices.forEachIndexed { index, charPosition ->
            val char = stacksInput[stackLevel].getOrNull(charPosition)
            if(char != null && char != ' ') stacks[index].addLast(stacksInput[stackLevel][charPosition])
        }
    }
    return stacks
}

fun moveCrates(stacks: List<ArrayDeque<Char>>, commandsInput: List<String>, version: CrateMoverVersion) {
    val commands = commandsInput.map { command ->
        val (amount, from, to) = COMMAND_REGEX.matchEntire(command)!!.groupValues.drop(1).map { Integer.parseInt(it) }
        MoveCommand(amount, from - 1, to - 1)
    }

    commands.forEach { command ->
        if(version == CrateMoverVersion.V9000) {
            repeat(command.amount) {
                val char = stacks[command.from].removeLast()
                stacks[command.to].addLast(char)
            }
        } else {
            val chars = stacks[command.from].takeLast(command.amount)
            chars.forEach {
                stacks[command.to].addLast(it)
                stacks[command.from].removeLast()
            }
        }
    }
}

enum class CrateMoverVersion {
    V9000, V9001
}

data class MoveCommand(val amount: Int, val from: Int, val to: Int)

private val COMMAND_REGEX = """move (\d+) from (\d+) to (\d+)""".toRegex()
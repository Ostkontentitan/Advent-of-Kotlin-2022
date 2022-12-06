package day6

import readPuzzleInput

fun daySix(input: List<String> = readPuzzleInput(6)): Pair<Int, Int> {
    val digiCom = DigiCom(DigiCom.Mode.PACKAGE_MARKER)
    input.first().forEach { next ->
        digiCom.recieveChar(next)
    }

    val digiCom2 = DigiCom(DigiCom.Mode.MESSAGE_MARKER)
    input.first().forEach { next ->
        digiCom2.recieveChar(next)
    }

    return digiCom.startOffset to digiCom2.startOffset
}

class DigiCom(startMode: Mode) {

    private val buffer: MutableList<Char> = mutableListOf()

    private var count: Int = 0
    private var mode = startMode

    var startOffset = -1
        private set

    fun recieveChar(char: Char) {
        count += 1
        buffer.add(char)
        when(mode) {
            Mode.PACKAGE_MARKER -> checkStartMarker(4)
            Mode.MESSAGE_MARKER -> checkStartMarker(14)
            Mode.DONE -> Unit
        }
    }

    private fun checkStartMarker(size: Int) {
        if (buffer.size < size) return

        if(buffer.takeLast(size).toSet().size == size) {
            startOffset = count
            mode = Mode.DONE
        }
    }

    enum class Mode {
        MESSAGE_MARKER, PACKAGE_MARKER, DONE
    }
}
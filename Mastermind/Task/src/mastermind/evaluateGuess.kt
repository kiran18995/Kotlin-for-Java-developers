package mastermind

import kotlin.math.min

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    val series = "ABCDEF"
    val firstChar = 'A'
    val secretCharCount = IntArray(series.length)
    val guessCharCount = IntArray(series.length)
    (secret.indices).forEach { i ->
        val secretChar = secret[i]
        val guessChar = guess[i]
        ++secretCharCount[secretChar.toInt() - firstChar.toInt()]
        ++guessCharCount[guessChar.toInt() - firstChar.toInt()]
        if (secretChar == guessChar) ++rightPosition
    }
    val wordCount = (secretCharCount.indices).sumBy { min(secretCharCount[it], guessCharCount[it]) }
    return Evaluation(rightPosition, wordCount - rightPosition)
}

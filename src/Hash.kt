import kotlin.math.abs

fun getCharacterCode(value: Int): Int {
    var cValue = value + 128
    while (!(((cValue >= 48) && (cValue <= 57)) ||
                ((cValue >= 65) && (cValue <= 90)) ||
                ((cValue >= 97) && (cValue <= 122)))
    ) {
        cValue += if (cValue < 48) 24 else -47
    }
    return cValue
}


fun getSumOfNumber(number: Int): Int {
    val str = number.toString()
    var sum = 0
    for (i in str) {
        sum += i.toInt()
    }
    return sum
}


fun getMultiplyOfNumber(number: Int): Int {
    val str = number.toString()
    var res = 0
    for (i in str) {
        res *= i.toInt()
    }
    return res
}

fun getAverageOfNumber(number: Int): Int {
    val str = number.toString()
    var res = 0
    for (i in str) {
        res += i.toInt()
    }
    return res / str.length
}


fun getHashFirst(string: String): String {
    var hash = ""
    var localString = string
    val hashLength = 16

    var offset = 0
    while (hashLength > localString.length) {
        localString += (getCharacterCode(localString[offset].toInt() + offset)).toChar()
        offset++
    }

    while (hashLength < localString.length) {
        val newCharacter = getCharacterCode((localString[0].toInt() * localString[1].toInt()) +
                localString[0].toInt() / localString[1].toInt()).toChar()
        localString = localString.removeRange(0, 2)
        localString += newCharacter
    }

    for (character in localString) {
        val charCode = getCharacterCode(character.toInt())
        hash += getCharacterCode(getMultiplyOfNumber(charCode) + getAverageOfNumber(charCode)).toChar()
    }

    return hash
}

fun getHashSecond(string: String): String {
    var hash = ""
    for (character in string) {
        val code = getCharacterCode(character.toInt())
        if (code % 2 == 0)
            hash += getSumOfNumber(code * code)
        else
            hash += (getCharacterCode(getMultiplyOfNumber(code)).toChar().toString() +
                    getCharacterCode(getAverageOfNumber(code)).toChar())
    }
    return hash
}
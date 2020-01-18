class Test(private val num: Int = 5000) {

    private val strings = mutableSetOf<String>()

    init {
        generateStrings(num)
    }

    fun generateStrings(num: Int) {
        while (strings.size < num)
            strings.add(generateRandomString())
    }


    fun compareHashes(method: Int = 1) {
        var count = 0
        val values = mutableListOf<String>()
        values.addAll(strings)

        for (i in 0 until values.size - 1) {
            for (j in (i + 1) until values.size) {
                val firstHash = if (method == 1) getHashFirst(values[i]) else getHashSecond(values[i])
                val secondHash = if (method == 1) getHashFirst(values[j]) else getHashSecond(values[j])
                if (firstHash == secondHash) {
                    println("Collision : ${values[i]} = $firstHash , ${values[j]} = $secondHash")
                    count++
                }
            }
        }
        println("$count repetition found in ${values.size} records")

    }


}
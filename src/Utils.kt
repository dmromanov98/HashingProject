import kotlin.random.Random

fun generateRandomString()=
    (0..Random.nextInt(10,15)).
        map { (('A'..'Z')+('a'..'z')+('0'..'9')).random() }.
        joinToString(separator = "")
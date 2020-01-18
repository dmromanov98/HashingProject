fun main() {
    val password = "It's my password"
    val firsHashPassword = getHashFirst(password)
    val passwordTwo = "It's my password"
    val secondHashPassword = getHashFirst(passwordTwo)
    println("Hash first = $firsHashPassword, Hash second = $secondHashPassword")
    if (firsHashPassword == secondHashPassword) {
        println("Passwords are the same")
    } else {
        println("Passwords are different")
    }


    val test = Test(5000)
    test.compareHashes(1)
}

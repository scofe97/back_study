import java.time.LocalDate
import java.time.LocalDateTime

fun main() {
    println("Hello World!")
    val check = checkCondition(4)
    val check2 = ::checkCondition
    val check3 = check2(41)
    val anotherCheck = { n: Int -> n > 100}

    println(check)
    println(anotherCheck(2))
    println(anotherCheck.invoke(4))

    callsAnother({ n: Int -> println("출력 $n")  })

    ShyObject.create("The Thing")
}

fun checkCondition(n: Int) = n == 42

fun callsAnother(funky: (Int) -> Unit) {
    funky(42);
}

open class Person(
    val birthdate: LocalDate,
    val name: String

) {
    open fun isBirthDay(): Boolean {
        val today = LocalDateTime.now().toLocalDate()
        return today == birthdate
    }

    private fun today(): LocalDate {
        return LocalDateTime.now().toLocalDate();
    }
}

class Child(birthdate: LocalDate, name: String) : Person(birthdate, name) {

    override fun isBirthDay(): Boolean {
        val itsToday = super.isBirthDay()

        if (itsToday) {
            println("YIPPY")
        }

        return itsToday
    }
}

interface Greetable {
    fun greet(): String
}

open class Person2 constructor(
    val birthdate: LocalDate,
    var name: String
) : Greetable{
    override fun greet(): String {
        return "Hello There"
    }
}

class ShyObject private constructor(val name: String) {
    companion object {
        fun create(name: String): ShyObject {
            return ShyObject(name);
        }
    }
}
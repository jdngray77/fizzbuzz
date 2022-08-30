import java.util.function.Predicate

object fizzbuzz {

    fun Int.isMultipleOf(base : Int) = this % base == 0

    val fizzbuzzRules = hashMapOf(
        Predicate<Int> { it.isMultipleOf(3) } to "fizz",
        Predicate<Int> { it.isMultipleOf(5) } to "buzz",
        Predicate<Int> { it.isMultipleOf(10) } to "flip",
        Predicate<Int> { it.isMultipleOf(0) } to "flop"
    )


    /**
     * Evaluates a single number against [fizzbuzzRules],
     * and returns the value it maps to.
     *
     * @param index
     */
    fun evalSingle(index: Int) =
        fizzbuzzRules.entries.joinToString("", transform = {
            if (it.key.test(index))
                it.value
            else
                ""
        }).ifBlank { index.toString() }

    /**
     * Evaluates a range of numbers, and collects their outputs
     * into a single list.
     */
    fun evalRange(range: IntRange) =
        range.map { evalSingle(it) }

}

fun main() {
    println("Enter a start the end number of a range to evaluate.")
    fizzbuzz.evalRange(Integer.valueOf(readln()) .. Integer.valueOf(readln())).map {
        println(it)
    }
}
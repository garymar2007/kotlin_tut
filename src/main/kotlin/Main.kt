package org.gary

const val PI = 3.14 // This is similar to static final double PI = 3.14 in Java
val pi = getPiValue()
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }

    //safe call operator
    var a: String? = "Kotlin"
    a = null
    println(a?.length)

    // using string template for concatenation
    val who = "Gary"
    val language = "Kotlin"
    val message = "$who loves $language"
    println(message)


}

fun getConstPiValue(): Double = PI

fun getPiValue(): Double = 3.14
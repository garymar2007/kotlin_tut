package org.gary

import kotlin.math.max
import kotlin.math.min
import kotlin.math.round
import kotlin.math.sqrt

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

    // multiple lines string
    val email = """
        Hi %s,
        You are learning %s
    """.trimIndent()
    println(email.format(who, language))

    // compare strings
    val str1 = "Kotlin"
    val str2 = "Kotlin"
    println(str1 == str2)

    val str3 = java.lang.String("Kotlin")
    println(str1.equals(str3))  //  "==" cannot be used here because str3 is a java String object.

    val str4 = String("Kotlin".toCharArray())
    println(str1 == str4)  //  "==" can be used here because str4 is a Kotlin String.
    println(str4 === str1) //  "===" is used to compare memory reference of the objects.

    // using Math libs
    println(kotlin.math.PI) //3.141592653589793
    println(max(1, 2)) //2
    println(min(1,2))   //1
    println(round(sqrt(26.0)))

    // + operator overloading
    val x = 10
    val y = 20
    println(x + y) //30
    println("10" + "20") //1020

    // conversion
    val num = "10"
    println(10 + num.toInt()) //20  NB: println(10 + num) won't compile due to different types
    println(10.toString() + num) //1010  NB: it is better to use String template, ie println("${10}${num}")
    val d = 3.0
    println(d.toInt()) //3
    println(d.toLong()) //3
    println(d.toFloat()) //3.0
    println(d.toString()) //"3.0"
    println(d.toString() is String) //true

    // conditional statements
    val isAdult = false
    val isMale = true
    if (isAdult && isMale) {
        println("You are an adult Male")
    } else if (isAdult && !isMale) {
        println("You are an adult Female")
    } else if (isMale){
        println("You are a male but not an adult")
    } else {
        println("You are a female but not an adult")
    }

    //Ternary operator
    // In Java, var result = n1 > n2 ? n1 : n2;
    // In kotlin
    val n1 = 31
    val n2 = 20
    val result = if (n1 > n2) n1 else n2

    //1:20:27

}

fun getConstPiValue(): Double = PI

fun getPiValue(): Double = 3.14
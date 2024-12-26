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
    val n1 = 20
    val n2 = 20
    val result =
        if (n1 > n2) n1
        else if (n1 == n2) "equal"
        else n2
    print(result) //31

    // when statement
    // In java, swith statement is used, but in Kotlin, we use when statement
    val age = 20
    when (age) {
        0 -> println("You are a baby")
        in 1..17 -> println("You are a minor")
        in 18..59 -> println("You are an adult")
        else -> println("You are a senior citizen")
    }
    val gender = "Q"
    when (gender) {
        "M" -> println("MALE")
        "F" -> println("FEMALE")
        "L" -> println("LESBIAN")
        "G" -> println("GAY")
        "B" -> println("BISEXUAL")
        "T" -> println("TRANSGENDER")
        "Q" -> println("QUEER")
        else -> println("Unknown")
    }

    // When booleans are null
    val isMale1: Boolean? = null
    if (isMale1 != null) {
        println("not null and true")
    }
    else {
        println("null")
    }
    when (isMale1) {
        true -> println("Male")
        false -> println("Female")
        else -> println("Unknown")
    }

    // Arrays
    val numbers = intArrayOf(1, 2, 3, 4, 5)
    println(numbers[0]) //1
    val strArray = arrayOf("Kotlin", "Java", "Python")
    println(strArray[0]) //Kotlin
    val mixedArray = arrayOf(1, "Kotlin", 3.0) // NB: the size of this array could not be resizable due to val, but its contents can be changed.
    println(mixedArray[2]) //3.0
    mixedArray[0] = 10
    println(mixedArray.contentToString()) // [10, Kotlin, 3.0]
    //println(mixedArray[3]) // throw a runtime exception: ArrayIndexOutOfBoundsException
    if ("Kotlin" in mixedArray) {
        println("Kotlin is in the mixedArray")
    } else {
        println("Kotlin is not in the mixedArray")
    }
    val arrayOfNulls = arrayOfNulls<String>(5)
    println(arrayOfNulls.contentToString()) //[null, null, null, null, null]
    arrayOfNulls[4] = "Kotlin"
    println(arrayOfNulls.contentToString()) //[null, null, null, null, Kotlin]
    arrayOfNulls.fill("*")
    println(arrayOfNulls.contentToString()) //[*, *, *, *, *]
    println(arrayOfNulls.flatMap {
        it?.let {
            listOf(it.length, it)
        } ?: emptyList()
    }) // [1, *, 1, *, 1, *, 1, *, 1, *]

    // List
    val list: List<String> = listOf("Kotlin", "Java", "Python") //NB: you cannot add or remove elements from this list
    println(list[0]) //Kotlin
    println(list.contains("Java")) //true
    println(list.containsAll(listOf("Java", "Python"))) //true
    val mutableList = mutableListOf("Kotlin", "Java", "Python")   // NB: you can add or remove elements from this list
    mutableList.add("C++")
    println(mutableList) //[Kotlin, Java, Python, C++]
    mutableList.addAll(listOf("C#", "Ruby"))
    println(mutableList) //[Kotlin, Java, Python, C++, C#, Ruby]
    println(mutableList.indexOf("Java")) //1
    val isRemovalSuccessful = mutableList.remove("Java")
    println(isRemovalSuccessful) //true
    println(mutableList) //[Kotlin, Python, C++, C#, Ruby]
    val emptyList = mutableListOf<Any>()
    println(emptyList.isEmpty()) //true

    // Destructure
    val (name1, age1) = Pair("Gary", 20)
    println("$name1 is $age1 years old") //Gary is 20 years old
    val names = listOf("Gary", "John", "Jane", "Carol") // or arrayOf("Gary", "John", "Jane", "Carol")
    val (name2, name3, name4) = names
    println("$name2, $name3 and $name4 are friends") //Gary, John and Jane are friends
    val (first, second, _, fourth) = names
    println("$first, $second and $fourth are relatives") //Gary, John and Carol are friends
    val (one, _, _, four) = names
    println("$one and $four are couple") //Gary and Carol are friends

    // loops
    val numbers1 = intArrayOf(1, 2, 3, 4, 5)
    val names1 = listOf("Gary", "John", "Jane", "Carol")
    for (number in numbers1) {
        print(number)
        print(" ")
    }
    println()
    for (name in names1) {
        name.replaceFirstChar { it.uppercase() }
        println(name)
    }
    val chars = charArrayOf('A', 'B', 'C', 'D', 'E')
    for (index in chars.indices) {
        println("$index - ${chars[index]}")
    }
    for (index in chars.indices.reversed()) {
        println("$index - ${chars[index]}")
    }
    for (i in 1..5) {
        print(i)
        print(" ")
    }
    for (i in 5 downTo 1 step 2) { //5, 3, 1 step is to skip every second element
        print(i)
        print(" ")
    }

    // loop in String
    val brand = "amazon"
    for (l in brand) {
        println(l)
    }

    // foreach
    val strs = arrayOf("Kotlin", "Java", "Python")
    strs.forEach {
        println(it)
    }

    //while/do-while loop
    var number = 1
    while (number <= 5) {
        print(number)
        print(" ")
        number++
    }
    do {
        print(number)
        print(" ")
        number--
    } while (number >= 0)

    //3:07:49

}

fun getConstPiValue(): Double = PI

fun getPiValue(): Double = 3.14
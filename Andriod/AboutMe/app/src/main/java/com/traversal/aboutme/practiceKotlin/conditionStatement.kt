package com.traversal.aboutme.practiceKotlin

fun main() {
    val a = 10
    val b = 20
    if(a > b){
        println(" A is greatest number")
    }else{
        println("B is greatest number")
    }

    //In Kotlin if else also return the value as ternary operator
    val c = if(a > b) a else b
    println("Value of C = $c")

    //We can also use it as blocks
    val max = if(a > b){
        println("A is Largest Number")
        a
    }else{
        println("B is Largest Number")
        b
    }
    println("Value of Max = $max")
}
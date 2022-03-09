package com.traversal.aboutme.practiceKotlin

fun main(){
    val firstResult = test(10,2)
    println("First Result => $firstResult")
    val secondResult = test(10, 0)
    println("Second Result => $secondResult")
}

fun test(a: Int, b: Int) : Any{
    return try {
        a/b
    } catch (e: Exception){
        "Divided by zero not allowed $e"
    }
}
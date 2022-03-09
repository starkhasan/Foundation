package com.traversal.aboutme.practiceKotlin

fun main(){
    val firstNumber = 20
    val secondNumber = 30
    val result = sum(firstNumber, secondNumber)
    println("Result = $result")
}

fun sum(a: Int, b: Int): Int{
    return a+b
}
package com.traversal.aboutme.practiceKotlin

fun main(){
    try {
        val num = 10 / 0
        println(num)
    } catch (e: ArithmeticException){
        println("Arithmetic Exception Throw")
    }
}
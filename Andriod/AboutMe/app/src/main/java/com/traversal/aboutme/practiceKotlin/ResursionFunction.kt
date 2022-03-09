package com.traversal.aboutme.practiceKotlin

fun fact(num: Int): Int{
    return if(num <= 1)
        1
    else
        num * fact(num-1)
}
fun main(){
    var number = 5
    number = fact(number)
    println("Factorial Number => $number")
}
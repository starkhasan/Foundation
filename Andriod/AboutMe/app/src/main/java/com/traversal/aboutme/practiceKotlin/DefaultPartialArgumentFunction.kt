package com.traversal.aboutme.practiceKotlin

fun main(){
    val name = "Ramesh Kumar"
    val standard = "B.Tech"
    val rollNo = 1500110002
    studentDetailsDefaultArgument(name)
}
fun studentDetailsDefaultArgument(name: String = "Ali", standard: String = "B.Tech", roll_no: Long = 1500110002){
    println("Student Name => $name")
    println("Student Standard => $standard")
    println("Student Roll => $roll_no")
}
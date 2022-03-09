package com.traversal.aboutme.practiceKotlin

fun main(){
    val name = "Ali Hasan"
    val standard = "B.Tech"
    val rollNo = 1500110002
    studentDetails()
}
fun studentDetails(name: String = "Ali", standard: String = "B.Tech", roll_no: Long = 1500110002){
    println("Student Name => $name")
    println("Student Standard => $standard")
    println("Student Roll => $roll_no")
}
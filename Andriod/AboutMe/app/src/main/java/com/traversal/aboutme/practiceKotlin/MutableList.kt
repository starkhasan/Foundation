package com.traversal.aboutme.practiceKotlin

fun main(){
    val mutableList = mutableListOf<Int>(1,2,3,4,5,6)
    mutableList.forEach{ item -> println(item)}

    //MutableList can be updated and deleted
    println("Modifying Mutable List")
    mutableList.add(10)
    mutableList[0] = 34
    mutableList.removeAt(5)
    mutableList.forEach { item -> println(item) }
}
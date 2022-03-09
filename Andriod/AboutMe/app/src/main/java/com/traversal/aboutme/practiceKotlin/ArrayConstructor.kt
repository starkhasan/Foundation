package com.traversal.aboutme.practiceKotlin

fun main(){
    val newArray = Array(10){item -> item+1}
    for(item in newArray){
        print("$item ")
    }
}
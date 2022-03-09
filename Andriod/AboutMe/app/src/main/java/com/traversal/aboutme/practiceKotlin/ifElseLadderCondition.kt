package com.traversal.aboutme.practiceKotlin

fun main(){
    val a = 10
    val b = 20
    val c = 30
    if(a > b && a > c){
        print("A is greatest")
    }else if(b > c){
        print("B is greatest")
    }else{
        print("C is greatest")
    }
}
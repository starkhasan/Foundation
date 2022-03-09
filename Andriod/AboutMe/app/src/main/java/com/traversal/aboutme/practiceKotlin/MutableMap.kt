package com.traversal.aboutme.practiceKotlin

import android.os.Build

fun main(){
    var mutableMap = mutableMapOf(1 to "Mahipal",2 to "Nikhil",3 to "Rahul")
    // we can modify the element
    mutableMap.put(1,"Praveen")
    // add one more element in the list
    //Here we can also use assignment
    mutableMap[4] = "Abhi"

    for(item in mutableMap.values){
        println(item)
    }

    //we can also use the forEach loop
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        print("Using ForEach loop")
        mutableMap.forEach { key, value -> println("Key => $key Value => $value") }
    }else{
        println("Using For Loop ")
        for(item in mutableMap.values){
            println(item)
        }
    }
}
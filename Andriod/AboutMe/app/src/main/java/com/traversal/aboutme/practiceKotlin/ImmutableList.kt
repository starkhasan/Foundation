package com.traversal.aboutme.practiceKotlin

/*
    Immutable List
    it is a ordered collection in which we can access elements or items by index (indices)

    we cannot perform add or remove operation in the immutable list
 */

fun main(){
    val listNumber = listOf(1,2,3,4,5,6,7,8)
    listNumber.forEach { item -> println(item) }
}
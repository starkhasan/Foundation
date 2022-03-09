package com.traversal.aboutme.practiceKotlin
/*
    it is a collection of unordered collection also it does not support  duplicate elements
 */
fun main(){
    val immutableSet = setOf(1,2,4,"Ali Hasan",4,6,"Wali Ganj",6)
    immutableSet.forEach { item -> println(item) }
}
package com.traversal.aboutme.practiceKotlin


//Example of extension function
fun String.spaceToCamelCase() : String {
    return this.toString().uppercase()
}

fun main() {
    val str = "ali hasan"
    print(str.spaceToCamelCase())
}
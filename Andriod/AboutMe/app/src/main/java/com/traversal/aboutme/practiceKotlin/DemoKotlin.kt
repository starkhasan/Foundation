package com.traversal.aboutme.practiceKotlin

class Person(firstName: String, lastName: String){
    private var nameFirst: String? = null
    private var nameSecond: String? = null

    init {
        nameFirst = firstName
        nameSecond = lastName
    }

    fun printuserInformation(){
        print("")
    }
}


fun main(){
    var person = Person(firstName = "Ali", lastName = "Hasan")

}
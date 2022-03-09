package com.traversal.aboutme.practiceKotlin

fun main(){
    //it is a ordered collection of list which store duplicate item also
    var arrayList = ArrayList<Int>()
    arrayList.add(1)
    arrayList.add(1)
    arrayList.add(2)
    arrayList.add(3)
    arrayList.add(4)
    arrayList.add(5)
    arrayList.add(6)
    arrayList.add(7)
    arrayList.add(8)
    arrayList.add(9)
    arrayList.add(10)

    val containItem = arrayOf(2,1,4,6)

    arrayList.forEach { item -> println(item) }
    println("Which Item Present in the List\n")
    for(item in containItem){
        if(arrayList.contains(item)){
            println("$item is present in arrayList Collection")
        }else{
            println("Item is not present")
        }
    }
}
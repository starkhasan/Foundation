package com.traversal.aboutme.practiceKotlin

import java.lang.ArithmeticException

fun main(){
    val number = arrayOf(1,2,3,4)
    try {
        for(index in number.indices){
            try{
                val num = (0..4).random()
                println(number[index+1]/num)
            }catch (e: ArithmeticException){

            }
        }
    }catch (e: ArrayIndexOutOfBoundsException){
        println(e)
    }
}
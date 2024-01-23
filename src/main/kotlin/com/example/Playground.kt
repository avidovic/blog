package com.example

import com.example.blog.Article
import com.example.blog.User

/*
Extensions are resolved statically
Extensions do not actually modify the classes they extend. By defining an extension,
you are not inserting new members into a class, only making new functions callable with the dot-notation on variables of this type.

Extension functions are dispatched statically.
So which extension function is called is already known at compile time based on the receiver type.
 */

open class Shape
class Rectangle: Shape()

fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle"

fun printClassName(s: Shape) {
    println(s.getName())  //will print Shape
}

class Example {
    fun printFunctionType() { println("Class method") }
}

/*
If a class has a member function,
and an extension function is defined which has the same receiver type,
 the same name, and is applicable to given arguments, the member always wins.
 */
fun Example.printFunctionType() { println("Extension function") } //will never be called in favor for class method

fun Example.printFunctionType(i: Int) { println("Extension function #$i") } //has different signature

//nullable receiver
fun Any?.toString(): String {
    if (this == null) return "null"
    // After the null check, 'this' is autocast to a non-nullable type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}

fun main() {

    printClassName(Rectangle())

    Example().printFunctionType()

    Example().printFunctionType(1)

    println(null.toString())

    println("sth".toString())

    val author = User("loginn", "jana", "blah")
    println(author.toString())

    println(Article("naslov", "bomba", "najbolji clanak na svijetu", author).toString())

}
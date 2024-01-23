package com.example

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

//printClassName(Rectangle())

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

//Example().printFunctionType()
//Example().printFunctionType(1)


fun main() {

    printClassName(Rectangle())

    Example().printFunctionType()

    Example().printFunctionType(1)

}
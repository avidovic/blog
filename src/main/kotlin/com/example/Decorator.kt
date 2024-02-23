package com.example

interface Component {
    // example methods of decorated interface
    fun methodA()
    fun methodB()
}
// a single concrete implementation but there can be many
class ConcreteComponent : Component {
    override fun methodA() {
        println("concrete component methodA")
    }
    override fun methodB() {
        println("concrete component methodB")
    }
}
// Decorator `is-a` Component and `has-a` Component
// field `component` is `protected` which makes it available to inheriting classes
abstract class Decorator(protected val component: Component) : Component

// concrete `Decorator` implementation with forced constructor requiring the `Component` instance
class ConcreteDecorator1(component: Component) : Decorator(component) {
    // methods has to be overridden
    // in this case, `Decorator` is calling wrapped instance methods without any changes
    // so it's basically a Proxy
    override fun methodA() = component.methodA()
    override fun methodB() = component.methodB()
}
// another implementation of `Decorator`
class ConcreteDecorator2(component: Component) : Decorator(component) {
    override fun methodA(){
        // in this implementation you can't use methodA()
        // it may be related to checking `Component` parameters for example
        throw Exception("you can't do this")
    }
    override fun methodB(){
        println("running decorator2 methodB")
        //component.methodB()
    }
}

fun main(){
    // "naked" `Component``
    val component: Component = ConcreteComponent()
    // first Decorator wrapping a component
    val dec1: Component = ConcreteDecorator1(component)
    // second Decorator, wrapping already wrapped component
    val dec2: Component = ConcreteDecorator2(dec1)

    component.methodA()
    component.methodB()

    dec1.methodA()
    dec1.methodB()

    //dec2.methodA()
    dec2.methodB()
}
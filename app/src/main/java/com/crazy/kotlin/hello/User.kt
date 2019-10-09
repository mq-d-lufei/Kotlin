package com.crazy.kotlin.hello

class User(var name: String, var age: Int) {

    var firstProperty = "First property name = $name -- age = $age"

    fun logProperty() {
        print("property name = $name -- age = $age")
    }

    init {
        name = "Crazy"
        age = 18
    }

    fun logInfo() {
        println("name = $name -- age = $age")
    }

    constructor(name: String, age: Int, sex: Boolean) : this(name, age) {
        logInfo()
    }

    constructor(sex: Boolean) : this("aaa", 18) {
        logInfo()
    }

    init {
        name = "Crazy3"
        age = 180
    }

    var firstProperty2 = "First property name = $name -- age = $age".also(::println)


    fun hello() {
        println("User class fun hello")
    }


}


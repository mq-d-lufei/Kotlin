package com.crazy.kotlin.hello

/**
 * Created by feaoes on 2019/1/11.
 */
class Person(val name: String) {

    fun printName() {
        println(name)
    }

    fun hello() {
        println("Person class fun hello")
    }

    fun User.getHello() {
        this.hello()

        hello()

        this@Person.hello()

        hello()
    }

    fun executeUser(user: User) {
        user.getHello()

        walk().log
    }

    private fun walk() = object {
        val log: String = "public x"

        fun getLo(): String {
            return log
        }
    }
}
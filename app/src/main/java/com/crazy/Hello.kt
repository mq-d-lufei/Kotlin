package com.crazy.kotlin.hello

/**
 * Created by feaoes on 2019/1/11.
 */
fun main(args: Array<String>) {

    println("Hello Kotlin ...${if (true) " true " else "a"}")

    println("Hello Kotlin ...${if (1 in 10..100) " true " else "false"}")

    Person("Crazy").printName()

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)

    for (index in list.indices) {
        println("pos => $index  item = ${list[index]} ")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")

    fruits.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }

    val map = mapOf(
        "a" to 1,
        "b" to 2,
        "c" to 3,
        "key" to "value",
        4 to 4,
        5 to 5.5,
        6 to 1,
        7 to 1,
        "b" to 3
    )

    println(map["key"])
    println(map["b"])
    println(map[1])
    println(map[2])
    println(map[3])
    println(map[4])
    println(map[5])
    println(map[6])
    println(map[7])
    println(map["b"])
    println(map["b"])

    println("for map ....")

    for ((key, value) in map) {
        println("key = $key , value = $value")
    }

    map.mapValues { entry -> "${entry.key} " }

    map.mapKeys { x -> x.value }

    map.mapKeys { (key, value) -> println("key = $key, value = $value") }

//    var value : String? = "123456789"
    val availableNUll: String? = null

    availableNUll?.let {
        println("***********")
        println("value = $availableNUll")
    }

    val value: String? = "123456789"

    value.let {
        println("***********")
        println("value = $value")
    }


    val asc = Array(5) { i -> (i * i).toString() }
    asc.forEach { println(it) }

    var user = User("110", 3)
    user.logInfo()


    var javaObject = JavaObject()
    javaObject.java.also { println(it) }
    javaObject.printJavaInfo()

    var person = Person("Crazy666")

    println("test -> ${person.executeUser(user)}")

    val data = Data(1)

    data.setId2(2)

    data.getId2()

    data.setcontennt2("new conent")
    data.getcontennt2()

    /*var xx = person.walk()
    println(xx)*/

    for (i in 0..10) {

    }

    while (true) {

    }
    do {

    } while (true)

    when (person) {

    }
}
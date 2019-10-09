package com.crazy.learn

/**
 *  面向对象 上
 */

fun main(args: Array<String>) {

    val zeroClass1 = ZeroClass1("第一构造函数")
    println("name=${zeroClass1.name} age = ${zeroClass1.age}")

    val zeroClass12 = ZeroClass1()
    println("name=${zeroClass12.name} age = ${zeroClass12.age}")


    val zeroClass13 = ZeroClass1(66)
    println("name=${zeroClass13.name} age = ${zeroClass13.age}")

    //TODO 类方法作为函数
    val method: (ZeroClass1, String) -> Unit = ZeroClass1::method
    method(zeroClass1, "通过函数变量调用类方法")
    val print = ZeroClass1::print
    print(zeroClass1)
    //TODO 类成员作为外部变量引用
    var age = ZeroClass1::age
    age.set(zeroClass1, 99)
    val newAge = age.get(zeroClass1)
    print(zeroClass1)
    //TODO 中缀表示法与不同方法表示法对比
    println(zeroClass1 add (33))
    println(zeroClass1.add(33))

}


/**
 * 1、定义类
 *
 * 【修饰符】 class{
 *
 * 2、构造器
 *  0-1个主构造器，主构造器是类头的一部分跟在类名（和泛型后面），主构造器没有执行体，可以定义多个形参
 *      没有任何注解或修饰符，可以省略柱构造器关键字
 *  0-N个次构造器
 *
 * 3、访问成员和方法
 *  var zeroClass = ZeroClass)_
 *  zeroClass.age
 *  zeroClass.
 *
 *  4、中缀方法，方法就可以通过中缀表示法调用,
 *     infix修饰方法，方法只能有一个参数
 *
 *
 */
//没有成员变量与成员方法，省略花括号
public class ZeroClass constructor(zeroName: String)

public class ZeroClass1 constructor(zeroName: String) {

    val name = zeroName
    var age: Int = 18

    constructor(age: Int) : this("第二构造器") {
        this.age = age
    }

    constructor() : this("第三构造器") {
        this("")
        age = 16
    }

    private operator fun invoke(s: String) {

    }

    public fun method(value: String) {
        println("value->$value")
    }

    fun print() {
        println("age->$age name->$name")
    }

    //TODO 中缀表示法
    infix fun add(age: Int): String {
        return "${this.age} + $age"
    }

    operator fun component1(): String {
        return name
    }

    operator fun component2(): Int {
        return age
    }
}

/**
 *  1、componentN方法与解构
 *     允许将一个对象的N个属性解构给多个变量
 *     var (name, age) = zeroClass1
 *     使用_忽略返回值
 *
 *  2、Lambda表达式中解构
 *      {a -> ...} 一个参数
 *      {a，b -> ...} 两个参数
 *      {(a，b) -> ...} 一个解构对
 *      {(a，b),c -> ...} 一个解构对与第三个参数
 *
 *
 */
class FirstClass constructor(firstName: String) {

    var id: Int = 0
    val firstName = firstName
    var lastName = ""
    var age = 0

    fun eat(food: String) {
        println("food = $food")
    }

    operator fun component1(): Int {
        return this.id
    }

    operator fun component2(): String {
        return firstName
    }

    operator fun component3(): String {
        return this.lastName
    }

    operator fun component4(): Int {
        return this.age
    }

    fun operFun(firstClass: FirstClass) {
        val (id, firstName, lastName, age) = firstClass
    }

    fun operFun1(firstClass: FirstClass) {
        val (id, _, lastName, age) = firstClass
    }

    fun operFun2(firstClass: FirstClass) {
        val (id, _, lastName) = firstClass
    }

    //解构的遍历
    fun mapFun() {
        var map = mapOf(0 to 1, 1 to 2, 2 to 3, 3 to 4, 4 to 5)
        for ((key, value) in map) {
            println("key=$key + value=$value")
        }
    }

    var sex: Boolean
        get() {
            return true
        }
        set(value: Boolean) {
            sex = value
        }

}

fun firstFun() {

    var f: FirstClass

    f = FirstClass("first class")

    var p: FirstClass = FirstClass("second class")

}

var dog: (FirstClass, String) -> Unit = FirstClass::eat

fun secondFun() {

    println(dog(FirstClass("111"), "meet"))

    var (data1, data2) = DataClass("key", "value")
    data1.length
    data2.length
}

var book = "book"

/***
 * 数据类
 *
 * 数据类除使用 data 修饰之外，还要满足如下要求
 * 主构造器至少需要有一个参数。
 * 主构造器的所有参数需要用 val var 声明为属性
 * 数据类不能用 abstract open sealed 修饰，也不能定义成内部类
 * 在 Kotlin 1.1 之前，数据类只能实现接口：现在数据类也可继承其他类定义数据类之后，系统自动为数据类生成如下内容
 * 生成 quals()/hashCode（） 方法。
 * 自动重写toString（）方法，返回形如 User(name=John, age=42）”的 符串
 * 为每个属性自动生成 operator 修饰的 omponentN（）方法
 * 生成 copy（）方法 用于完成对象复制。
 *
 *
 * 自定义getter和setter，无需使用fun关键字
 *
 * 幕后字段field
 *      保存属性值，系统自动生成getter或setter方法，
 *
 *
 * 幕后属性
 *      private修饰的属性 重写getter、setter方法
 *
 * 延迟初始化属性
 *      lateinit修饰的可变属性，不能有自定义的getter、setter方法，必须是非空类型，不能是原生类型
 *
 * 内联属性
 *      inline可以修饰没有幕后字段field的属性的getter、setter方法，或直接修饰属性（相当于同时修饰了getter、setter）
 *
 *
 *
 */
data class DataClass(var data1: String, var data2: String) {

    var value = ""
    var data: String
        get() {
            println("执行data的getter方法")
            return data
        }
        set(value) {
            data = value
        }
}


fun main(args: Array<String>, fn: (Int) -> Unit) {

}


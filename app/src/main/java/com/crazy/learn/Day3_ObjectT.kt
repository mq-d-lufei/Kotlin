package com.crazy.learn

/**
 *
 *  声明处形变
 *      协变（out） （父类 = 子类）（子类可以赋值给该父类）  类似：T extends Entry
 *          只在方法的返回值处
 *      逆变(in)    （子类 = 父类）（父类可以赋值为该子类）  类似：T super Entry
 *          只在方法的形参列表中
 *
 *  使用处形变
 *      在使用时添加out或in改变形变，
 *
 *  星号投影（*）
 *      一个支持声明时形变的Foo<out T>类，支持声明时协变，T是具有上线的协变类型参数，
 *          Foo<*>等价于Foo<out Any?>,意味着T未知时，可以安全地从Foo<*>读取Any?类型
 *      Foo<int T>类，逆变，
 *          Foo<*>等价于Foo<in Nothing>,
 *
 *  泛型函数
 *      定义 fun <T，S>funName()
 *      调用 funName<T>()
 *      泛型扩展函数
 *          fun <T> T.add():String{}
 *
 *  具体化类型参数
 *      内联函数中使用reified修饰泛型形参，使得该形参变为具体化的形参类型
 *
 *  泛型上限
 *
 *
 */

fun main() {

    var numArr: Array<Number> = arrayOf(1, 2, 3, 4, 5, 6)
    var outNumArr: Array<out Number> = arrayOf(1, 2, 3, 4, 5, 6)
    //outNumArr.set(0,3.4)

    var intArr: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    //error
    //numArr = intArr
    outNumArr = intArr
}

open class TClass<T : Number> {
    fun doNothing(t: T) {

    }
}

open class AbsClass {}

interface interT<T : AbsClass> {}

class TClass1<T> where  T : Number, T : Comparable<T>, T : Cloneable {

}

fun <T> someFun(x: T): T {
    return x
}

fun <T> T.doPrint(t: T) {
    println(t.toString())
}


fun <T> T.doPrint1(t: T) {
    println(t.toString())
}

fun <T : Number> TClass<T>.foo(t: T): T {
    val x = t
    return x
}
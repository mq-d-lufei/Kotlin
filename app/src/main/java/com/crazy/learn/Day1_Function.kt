package com.crazy.learn

//TODO 一、函数总结

fun main(args: Array<String>) {

    //6、
    outsideFun("")

    var function = Function()

    function.test()

}


/**
 *  1、函数
 */
//TODo 定义函数 方法名、形參列表、返回值（如果沒有返回值，可省略，或使用Unit代表沒有返回值,Unit相当于void）
fun methodName(args: Int, args2: String) {
    //do something
}

fun methodName2(): String {
    return "return value"
}

fun methodName3(): String = "单表达式返回指"

//單表達式函數
fun noReturnFun() = Unit

fun noReturnFun1() {}

fun noReturnFun2(): Unit {
    //return nothing
}

fun noReturnFun3(): Unit {
    return Unit
}

var ooo: Int = 0

//递归函数
fun fnb(num: Int) {
    ooo = num
    if (ooo < 100)
        return;
    else
        fnb(ooo++)
}

/**
 *  2、单表达式函数(函數只返回单个表达式情况，可省略花括号，在=后指定函数体)
 */
fun area(x: Double, y: Double) = x * y

/**
 * 3、函数的形参（调用函数时可通过形参名字传入参数值）
 */
fun girth(width: Double, height: Double): Double {
    return width * height
}

//位置参数（传统的传参）与命名参数（传参时写参数名=参数）
fun useGirth() {
    girth(2.1, 3.2) //传统方式调用
    girth(2.1, height = 3.2)    //混合使用、根据命名参数调用
    girth(width = 2.1, height = 3.2)    //根据命名参数调用
    girth(height = 2.1, width = 3.2)    //形参可以调换位置
    //girth(width = 2.1, 3.2)    //错误，命名参数之后必须是命名参数
}

//形参的默认值 形参名：类型 = 默认值 （设置默认值后，传参数是可以省略该形参）
fun sayHi(name: String = "Crazy", message: String = "你好") {
    println("${name} say $message")
}

/**
 * 4、可变形参 vararg （指定书目不确定的形参）（可处于形参列表任意位置）（一个函数最多只能有一个可变形参）
 *    (数组传入可变形参，使用*运算符  如*array)
 */
fun varargFun(a: Int, vararg books: String, num: Int) {
    for (book in books)
        println("pos = ${books.indexOf(book)}, book = ${books.indexOf(book)}")
}

fun useVarargFun() {
    //最后一个参数必须使用命名参数
    varargFun(1, "abc", "def", "ghi", num = 2)

    val arrays = arrayOf("123", "456", "789")
    //传入数组参数前添加 * 运算符
    varargFun(1, *arrays, num = 2)
}

/**
 * 5、函数重载，函數名相同，形参列表不同的函数（形参个数不同、类型不同）=> 重载
 */
fun function() {

}

//错误
//fun function(): String{}

fun function(name: String) {

}

//可變形參重載，kotlin 會尽量执行最精确的匹配
fun function(vararg name: String) {

}
/**
 * 全局函数：全局范围内定义
 */

/**
 * 6、局部函数 => 放在封闭函数内（函数体内）的函数，局部函数对外部是隐藏的，拒不函数只能在器封闭函数内有效
 *     （局部函数对外部是隐藏的）（局部函数可作为函数返回值被外部变量引用以扩大可见范围（作用域被扩大），变为全局函数）
 */
fun outsideFun(type: String): Int {

    fun insideFunFirst(num: Int): Int {
        return num * num
    }

    fun insideFunSenond(x: Int) = x * x * x

    fun insideFunThird(third: Int): Int {
        return third
    }

    return when (type) {
        "first" -> insideFunFirst(1)
        "second" -> insideFunSenond(2)
        "third" -> insideFunThird(3)
        else -> 0
    }
}


/**
 * 7、高阶函数 => Kotlin的函数也是一等公民，函数本身也具有自己的类型
 *               函数类型可用于：定义变量、函数形参类型、函数返回值类型
 */

var funMost: (Int) -> String = { x: Int -> "x=$x" }
var funMost2: (Int) -> String = { "x=$x" }
var funMost3: (Int) -> String = { it -> "x=${it * it}" }
var funMost4: (Int, Int) -> Unit = { x: Int, y: Int -> x * y }
val funMost5 = ::funMost
var funMost6 = ::funMost4
val funMost7 = ::funMost6

/**
 * 8、使用函数类型
 *       每个函数都有特定的类型，函数类型组成：函数形参列表 -> 返回值类型
 *       访问函数的引用，在函数名前添加:: 如：var f = ::foo
 */

//函数类型：（Int, String）-> String
fun foo(x: Int, name: String): String {
    return ""
}

//函数类型：（Double,Double） 或者 （Double, Double）-> Unit
fun bar(width: Double, hegith: Double) {}

//函数类型： () 或者 () -> Unit
fun empty() {
    // 定义函数类型变量
    var funFirst: (Int, Int) -> String
}


class Function {

    var a: Int = 0

    var funFirst: (Int) -> String = { "init funFirst" }

    var funSecond: () -> Unit = {}

    var x: (Int) -> String = { "" }

    fun first(age: Int): String {
        return "fun first => Crazy = $age"
    }

    fun second(num: Int): String {
        return "fun second"
    }

    fun third(): () -> String {
        return fun(): String {
            return ""
        }
    }

    fun test() {

        var funFirst: (Int) -> String

        funFirst = ::first
        println(funFirst)

        funFirst = ::second
        println(funFirst)

        this.funFirst = ::first
        println(funFirst)

        var funThird = ::third

    }
}

/***
 *  9 、使用函数类型作为形参类型，可动态改变代码,类似命令模式
 */
fun map(data: Array<Int>, fn: (Int) -> Int): Array<Int> {
    var result = Array<Int>(data.size) { 0 }
    for (i in data.indices) {
        result[i] = fn(data[i])
    }
    return result
}

/***
 * 10、使用函数类型作为返回值类型
 */
fun getMathfunc(type: String): (Int) -> Int {
    fun square(x: Int): Int = x
    return ::square
}

//TODO Lambda表达式 可作为（表达式、函数形参、函数返回值）

/***
 * 11、 局部函数与Lambdaf表达式
 *      如果说函数是命名的、方便复用的代码块，
 *      那么Lambda表达式则是功能更灵活的代码块，它可以在程序中被传递和调用
 *      局部函数是Lambda函数的基础
 *
 */

var innerFun = { key: Int, value: String ->
    var x = 0
    var y = 1

    val str = "key = ${key + x} value = ${value + y}"

    str
}
var innerFun1: String = { key: Int, value: String ->
    var x = 0
    var y = 1

    val str = "key = ${key + x} value = ${value + y}"

    str
}.toString()


/***
 *
 * 12、定义Lambda表达式与局部函数存在如下区别：
 *      1、Lambda表达式总是被大括号扩着
 *      2、定义Lambda表达式不需要fun关键字，无需指定函数名
 *      3、形参列表（如果有的话）在-、形参列表（如果有的话）在->之前声明，参数类型可以省略
 *      4、函数体（Lambda表达式执行体放在）->之后
 *      5、函数的最后一个表达式自动被称为Lambda表达式的返回值，无需使用return关键字
 */

/***
 *  13、Lambda表达式
 *     //TODO {(形参列表) -> //零条或多条可执行语句}(特殊情况下，可省略形参类型和形参名)
 *      直接将Lambda表达式赋值给变量，或直接调用Lambda表达式
 *      完整的Lambda表达式需要定义形参类型，但是kotlin可以根据Lambda表达式上下文判断出形参类型
 *      那么Lambda表达式就可以省略形参
 *      //TODO 如果函数的最后一个参数为函数参数，并且打算传入的参数为Lambda表达式，则允许函数在圆括号之外指定Lambda表达式
 *      可变参数与函数参数同时存在，函数参数放最后
 */
fun lambdaFun(key: Int, fu: (Int, String) -> Map<Int, String>) {

}


fun job() {

    val la = { key: Int, value: String -> mapOf(Pair(key, value)) }
    val la2 = { key: Int, value: String -> mutableMapOf(Pair(key, value)) }
    val la3 = { key: Int, value: String -> hashMapOf(Pair(key, value)) }
    lambdaFun(6, la)
    lambdaFun(6) { key: Int, value: String -> mapOf(Pair(key, value)) }

}

/***
 *
 * 14、匿名函数
 *     普通函数去掉函数名变为匿名函数，如果系统可以推断出匿名函数的形参类型，则允许省略形参类型
 *      return
 *       匿名函数返回自身
 *       Lambda表达式返回所在的函数
 */

/**
 * 15、局部函数、匿名函数、Lambda表达式、对象表达式可以访问或修改其所在上下文（闭包）中的变量和常量，该过程被称为捕获
 *
 */
/**
 * 16、内联函数（inline内联函数）（noinline部分禁止内联参数）
 *      将被调用的Lambda表达式或函数的代码复制粘贴到原来的执行函数中
 *      ：如果被调用的 Lambda 表达式或函数包含大量的执行代码，那么就不应该使用内联函数：
 *      如果被调用的 Lambda 表达式或函数只包含非常简单的执行代码（尤其是单表达式），那么就应该使用内联函数
 *
 *      内联的Lambda表达式的return可以返回（退出）自身
 */

fun outSideFun(fn: (Int) -> Int, fn1: () -> Int) {

}

var x = fun(num: Int) = num * num

var y = { num: Int -> num }

inline fun inSideFun(num: Int, f1: (Int) -> String): String {

    var content = ""

    for (i in 1..100) {
        content += f1(i)
    }

    return content
}
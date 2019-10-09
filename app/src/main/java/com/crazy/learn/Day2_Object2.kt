package com.crazy.learn


/**
 * 面向对象2
 */

fun main(args: Array<String>) {

    //TODO 测试扩展方法结果
    println("----------测试扩展方法结果-----开始--------\n")
    toMainFirst()
    println("----------测试扩展方法结果-----结束--------\n")

    todoCompanion()
    println("----------------------------------------\n")

    testMapItem()

    val user = User("132", "456")
    println("age=${user.age}")
    user.age = 18
    println("age=${user.age}")
}

/**
 *  1、Kotlin扩展的实现机制
 *      弥补Java作为静态语言灵活性不足的问题
 *
 *      1.1 扩展
 *          Kotlin支持扩展方法和扩展属性
 *
 *      1.1.0 扩展的形式
 *          fun 扩展类（或接口）名.方法名(形参列表)： 返回值{}
 *
 *      1.1.1 扩展方法
 *          可为Kotlin系统类增加方法
 *
 *      1.1.2 扩展的实现机制
 *          Kotlin的扩展本质就是定义了一个函数，当对象调用扩展方法时，Kotlin在编译时会执行静态解析
 *          ----就是根据调用对象、方法名找到扩展函数，转换为函数调用
 *
 *          Kotlin编译时，扩展函数执行步骤：如 father.extendFunction()
 *          a）检查father类型，发现其类型是Father
 *          b) 检查Father类本身是否定义了extendFunction()方法，如果包含，则无需处理，直接编译即可
 *          c) 如果Father类型本身不包含extendFunction()方法，则Kotlin会查找程序是否为Father类扩展了extendFunction()方法，
 *              也就是查找系统中是否包含了名为Father.extendFunction()的函数定义，如果找到，则Kotlin会执行静态解析，
 *              它会将上面的代码替换为Father.extendFunction()函数
 *          d)如果Father类不包含extendFunction()方法，也找不到名为Father.extendFunction()的函数定义,编译器将报错
 *
 *          因此：Kotlin扩展并没有正在改变被扩展的类，而是调用扩展方法时，Kotlin编译器会将代码静态解析为调用函数
 *          意味着：调用扩展方法是由其所在表达式的编译时类型决定，而不是有它所在表达式的运行时类型决定
 *
 *          总结：成员方法执行动态解析（由运行时类型决定），扩展方法执行静态解析（有编译时类型决定）
 *
 *          优先级：成员方法 > 扩展方法
 *
 *      1.1.3 Java调用kotlin扩展方法
 *          相当于Java类的静态方法调用
 *          Raw_infoKt.info(x)
 *
 *
 */
//open修饰符：可用于派生子类，
//如果只是对类进行扩展，不需要使用open修饰该类
open class Father {
    fun doSomething() {
        println("Father do something ...")
    }

    /* fun extendPrint() {
         println("Father extend print fun ...")
     }*/
}

class Son : Father() {
    fun doOtherThings() {
        println("Son do other things ...")
    }
}

//扩展方法：函数名为：被扩展类.方法名
//被扩展类的实例以及其子类的实例都可以调用该扩展方法
fun Father.extendFunction() {
    println("Father extend function")

    //扩展方法中的this与成员方法中的this一样，代表调用该方法的对象
    this.doSomething()
}

//如果extendPrint()为成员方法，扩展方法中子类不需要使用override申明重写
fun Father.extendPrint() = println("Father extend print")

fun Son.extendPrint() = println("Father extend print")

fun invokePrint(father: Father) {
    //执行结果取决如编译时类型
    father.extendPrint()
}

fun toMainFirst() {

    val father = Father()
    father.doSomething()
    //调用Father类扩展的方法
    father.extendFunction()

    val son = Son()
    son.doSomething()
    son.doOtherThings()
    //子类调用给父类扩展的方法
    son.extendFunction()

    //传入子类对象
    invokePrint(son)
}

/**
 *    1.1.3 为可空类型扩展方法
 *          允許為可空类型（带"?."后缀的类型）扩展方法
 */
fun Any?.hello(message: String) {
    if (null == this)
        println(message)
    else
        println("this is not null")
}


/**
 *  1.1.4 扩展属性
 *      扩展属性：通过添加getter、setter方法实现，没有幕后字段，扩展的属性只等是计算属性
 *      限制：
 *          a) 扩展属性不能有初始值（没有存储属性指的幕后字段）
 *          b) 不能用filed关键字显示访问幕后字段
 *          c) 扩展只读属性必须提供getter方法，扩展读写属性必须提供getter、setter方法
 *
 **/
class User(firstName: String, lastName: String) {
    var firstName = firstName
    var lastName = lastName
}

var User.age: Int?
    get() {
        //java.lang.StackOverflowError
        //return age
        return 18
    }
    set(value) {
        firstName = "$value"
    }

var User.fullName: String
    get() = "${firstName}.${lastName}"
    set(value) {
        //此处有问题，会递归调用set方法，应为扩展属性没有幕后字段，无法保存值
        fullName = value
    }
//List类提供制度属性
val <T> List<T>.lastIndex: Int
    get() = size - 1

/***
 *  1.1.5 以成员方法定义扩展
 *      this支持使用“@类名”形式，代表某个类的对象
 *
 **/
class Car {

    fun User.printFirstName() {
        println("firstName = $ { firstName }")
        //printFirstName()
        //this.printFirstName()
        //this@printFirstName.printFirstName()
        this@Car.printFirstName()
    }

    fun printFirstName(): String {
        return "Car first name"
    }

    fun test(user: User) {
        user.printFirstName()
    }
}

/***
 *  1.1.6 带接收者的匿名函数
 *      形式： 类名.(){}
 *      具备自身类型： 如： Int.() -> Int
 *      Kotlin支持为类扩展匿名函数，该扩展匿名函数所属的类，是该匿名函数的接收者
 *      允许在函数体内访问接收者对象的成员
 **/
//接受者是Int对象，this代表该对象
val func = fun Int.(): Int {
    return this.and(3)
}

fun testFunc() {
    6.func()

    //Lambda表达式代替扩展匿名函数
    html {
        head()
        body()
    }
}

class Html {
    fun body() {

    }

    fun head() {

    }
}

fun html(init: Html.() -> Unit) {

}

/***
 *  1.1.7  何时使用扩展
 *      a)扩展可动态地为已有的类添加方法或属性
 *      b) 扩展能以更好的形式组织一些工具方法
 *
 *      如：Collections.sort(list 扩展为 list.sort())
 */

/***
 *
 *  open、final
 *  抽象类 abstract class
 *      可以有初始化块、构造器
 *      单继承
 *      可以有成员变量、方法、
 *      子类访问控制权限大于等于父类的
 *  密封抽象类
 *      在同一文件中派生子类
 *
 *  接口 interface
 *      没有初始化块、构造器
 *      可多继承
 *      可以有成员变量（没有幕后字段，需要自己提供getter、setter）、成员方法（可以有执行体）、
 *      可以通过public、private修饰
 *      默认有abstract public修饰
 *
 */

/**
 *
 *  1.5.4 内部类 相当于Java非静态内部类   加修饰符inner
 *
 *  1.5.5 嵌套类 相当于Java静态内部类
 *          唯一可访问的是外部类的其他嵌套类
 *
 *  1.5.6 匿名内部类
 *          Kotlin 废弃 ，并提供对象表达式
 *
 *  1.6.1  对象表达式和对象声明
 *          形式：object[: 0-N个父类型]{          }
 *          规则：
 *          a)  对象表达式不能是抽象类，系统会在创建对象表达式时立即创建对象，因此不允许将对象表达式定义为抽象类
 *          b） 對象表達式不能定义构造器，但可以定义初始化块，
 *          c)  对象表达式可以包含内部类（inner修饰的内部类），不能包含嵌套类
 *
 *  1.6.2 对象声明和单例模式
 *
 *          对象声明专门用于实现单例模式
 *              (对相声名所定义的对象是该类唯一的实例)
 *
 *          对象表达式与对象声名区别
 *          a)  对象表达式是一个表达式，可以赋值给变量，而对象声明不是表达式，不能用于赋值
 *          b)  对象声明可包含嵌套类，不能包含内部类，而对象表达式可以包含内部类，不能包含嵌套类
 *          c)  对象声明不能包含在函数或方法内，但对象表达式可以嵌套在其他对象声明或非内部类中
 *
 *  1.6.3 伴生对象和静态成员
 *
 *          class MyObject{
 *           companion object : absClass{}
 *           companion object className : absClass{}
 *
 *          }
 *          var value = MyObject.companion.value
 *          var fun1 = MyObject.className.getValue(){
 *              println(value)
 *          }
 *
 *
 *          伴生對象 -> 类似静态成员
 *
 *          在类中定义对象声明，可使用从companion修饰，这样该对象就变为伴生对象
 *          每个类最多只能定义一个伴生对象，伴生对象相当于外部类的对象，可通过外部类直接调用伴生对象的成员
 *          伴生对象可以有扩展属性和扩展方法
 *
 *  1.7.1 枚举类
 *          形式： enum class ...
 *          可以有自己的属性、方法，可以实现一个或多个方法，也可以定义自己的构造器
 *          与普通类的区别：
 *          a） 枚举类可以实现一个或多个接口，使用enum定义的枚举类默认继承kotlin.Enum类，而不是Any类
 *              因此不能继承其他父类，Enum类实现了kotlin.Comparable接口
 *          b)  使用enum定义的非抽象的枚举类不嫩使用open修饰，因此枚举类不能派生子类
 *          c)  枚举类的构造器只能使用private访问控制符，如果省略了构造器的访问控制符，则默认使用private修饰
 *          d） 枚举类的所有实例必须在枚举类的第一行显式列出，否则该枚举类永远都不能产生实例
 *              列出枚举实例后最好用分号结尾
 *          e)  EnumClass.valueOf(value: String):EnumClass,类似Java枚举类的valueOf()方法,用于根据美剧的字符串
 *              名获取枚举值，如果传入的名称参数与定义的均不匹配，valueOf则抛出illegalArgumentException异常
 *          f)  EnumClass.values():Array<EnumClass>,用于获取该枚举类的所有枚举值组成的数组，类似Java枚举类的values()方法
 *
 *  1.8 类委托和属性委托
 *      类委托
 *      属性委托
 *
 *      延迟属性
 *      属性委托
 *      使用Map存储属性值（属性委托到Map中）
 *
 **/
class OutSideClass() {

    private var name = "outside name"

    //内部类
    inner class InsideClass {

        private var name = "inside name"
        var value = "inside value"

        fun _getName(): String {
            return name
        }

        fun getOutSideField() {
            println("out side name = $this@outSideClass.name")
        }
    }

    fun printName() {
        println("name = $name")
        println("name = ${InsideClass()._getName()}")
        println("name = ${InsideClass().value}")
        println("name = ${InsideClass().getOutSideField()}")

        //嵌套类
        println("nestFiled = ${NestClass().nestFiled}")
        println("nestFiled = ${NestClass().nestFun}")
        println("nestFiled = ${NestClass().getValue()}")
    }

    //嵌套类
    class NestClass {
        var nestFiled = 999;

        var nestFun = { n: String -> n }

        fun getValue(): Int {
            return nestFiled * nestFiled
        }

        fun printName() {
            println("nest class ${NestClass2().nest2Filed}")
        }
    }

    class NestClass2 {
        var nest2Filed = 666;
    }
}

fun innernestClass() {
    var innerC = OutSideClass().InsideClass()
    var nestC = OutSideClass.NestClass()

    var runnable = Runnable { println("Thread name = ${Thread.currentThread().name}") }
}


//对象表达式
var o = object {
    val x = 0
}

var someClass = Some.halloSome()

open class SomeFather {

    open var some = 123

    fun hallo() = println("hello ...")
}

//对象声明
object Some : SomeFather() {

    override var some = 456

    fun halloSome() = println("hello some...")

}

object SomeOne {
    val some = Some.halloSome()
    val someVlaue = Some.some
}

//伴生对象
class HasCompanionClass {

    object NoCompanionClass {

        val com = 123

        fun output() = println("NoCompanionClass class ...")
    }


    companion object CompanionClass {

        val com = 456

        fun output() = println("companion class ...")
    }

    fun todu() {
        NoCompanionClass.com
        CompanionClass.com
    }
}

//为伴生类CompanionClass提供扩展方法
fun HasCompanionClass.CompanionClass.dosomething() {
    println("CompanionClass.dosomething() ...")
}

//为对象声明CompanionClass提供扩展方法
fun HasCompanionClass.NoCompanionClass.dosomething() {
    println("NoCompanionClass.dosomething() ...")

}

fun todoCompanion() {
    HasCompanionClass.NoCompanionClass.output()
    //
    HasCompanionClass.CompanionClass.com
    HasCompanionClass.com

    HasCompanionClass.NoCompanionClass.dosomething()
    HasCompanionClass.CompanionClass.dosomething()
}

//类委托
interface All {
    val type: String
    fun all()
}

class DefaultAll(override val type: String) : All {

    override fun all() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

//方式一：通过构造器参数指定委托对象
class FirstAll(d: DefaultAll) : All by d

//方式二： 直接在类定义的by后新建对象
class DoubleAll(name: String) : All by DefaultAll(name)

//只读属性
class MapItem(val map: Map<String, Any?>) {
    val id: String by map
    val name: String by map
    val address: String by map
}

class MuTableMapItem(map: MutableMap<String, Any?>) {
    val id: String by map
    val name: String by map
    val address: String by map
}

fun testMapItem() {
    val mapItem = MapItem(mapOf("name" to "Crazy", "id" to "0101001", "address" to "wujiakegui"))
    println(mapItem.id)
    println(mapItem.name)
    println(mapItem.address)

    val mutable: MutableMap<String, Any?> = mutableMapOf(
        "name" to "Crazy",
        "id" to "0101001",
        "address" to "wujiakegui"
    )

    val mutableMapItem = MuTableMapItem(mutable)
    println(mutableMapItem.id)
    println(mutableMapItem.name)
    println(mutableMapItem.address)

    mutable["age"] = "18"
    mutable["name"] = "Who am i"

    println(mutableMapItem.id)
    println(mutableMapItem.name)
    println(mutableMapItem.address)

}
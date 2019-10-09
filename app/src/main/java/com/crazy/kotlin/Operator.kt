package com.crazy.kotlin

fun main() {

    var a = 20
    var b = -a
    val c = +a

    val d = true
    val e = !d

    println("a =  $a");
    println("b =  $b");
    println("c =  $c");
    println("d =  $d");
    println("e =  $e");

    /**
     * 区间
     *
     * a..b                 闭区间[]
     * a until b            半闭区间[)
     * a downTo b           反向区间，大到小
     * a dokwnTo b step 2   step步长
     *
     */


    for (i in 3..9) {
        println(" i = $i")
    }

    for (j in a until 100) {
        print(" i = $j")
    }
    println()

    for(x in 56 downTo 0 step 6){
        print(" x = $x")
    }

}
@file:Suppress("NAME_SHADOWING")

package com.dk.kotlindemo

import android.text.TextUtils

fun main() {
//    println("a+b=" + sum(3, 4))
//    println("a*b=" + multi(3, 4))
//    string()
    collections()

}

// fun 函数名(形参名1：形参类型，形参名2：形参类型): 返回值类型{
// }
fun sum(a: Int, b: Int): Int {
    return a + b
}

//表达式直接作为方法体
fun multi(a: Int, b: Int) = a * b

//返回值类型Unit相当于Java中的void，不指定为特定类型，无意义的值
fun sub(a: Int, b: Int): Unit {
    return
}

//kotlin中方法名和参数列表相同，返回值类型不同也不算重载，
//可以不指定返回值类型,默认是Unit，void空返回值类型
fun sub1(a: Int, b: Int) {
    return;
}

//变量val只能赋值一次，var可以可以赋值多次
val PI = 3.14//顶层变量
var x = 1000//var的顶层变量
fun variable() {
    val a: Int = 1;//立即赋值
    val b = 2;//自动推断出是Int
    val c: Int//先定义不赋值
    c = 3;

    var d = 4;//var赋值后可更改
    d = 5

    x += 1
}

//注释
fun comment() {
    //单行注释
    /**多行注释*/
}

//字符串模板
fun string() {
    var a = 1;
    val s1 = "a is $a"
    val s2 = "${s1.replace("is", "was ")}, but now is $a"
    println(s1)
}

//条件表达式
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//条件表达式直接返回
fun maxOf2(a: Int, b: Int) = if (a > b) a else b

//null检查
fun nullCheck(a: String): Int? {
    if (TextUtils.isEmpty(a))
        return null
    else
        return Integer.parseInt(a)
}

fun parseInt(a: String): Int? {
    if (TextUtils.isEmpty(a)) {
        return null
    }
    return Integer.parseInt(a)
}

fun printProduct(a: String, b: String) {
    val x = parseInt(a)
    val y = parseInt(b)
    if (x != null && y != null) {
        println(x * y);
    } else {
        println("$a or $ $b is null param")
    }
}

//类型转换
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    // `obj` 在 `&&` 右边自动转换成 `String` 类型
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

val items = listOf<String>("Apple", "Orange", "Berry")

//for循环
fun forCircle() {
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("索引：$index,元素：${items[index]}")
    }
}

//while循环
fun whileCircle() {
    var index = 0
    while (index < items.size) {
        println(items[index])
        index++
    }
}

//when表达式
fun whenExp(obj: Any) {
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "not a String"
        else -> "unknown"
    }
}

//使用区间
fun rangeExp() {
    val x = 9
    val y = 5
    if (y in 1..(x + 1)) {
        print("fit in range")
    }

    if (-1 !in 0..items.size) {
        println("-1 is out of range")
    }
    if (items.size !in items.indices) {
        println("list size is out of valid list indices range, too")
    }
    //区间迭代
    for (x in 0..5) {
        println("当前索引：$x")
    }
    //数列迭代
    for (x in 0..20 step 2) {
        println(x)
    }

    //从高到低
    for (x in 20 downTo 0 step 3) {
        println(x)
    }
}

//集合
fun collections() {
    for (item in items) {
        println(item)
    }
    //使用in来判断集合内是否包含实例
    when {
        "orange" in items -> print("orange juicy")
        "apple" in items -> print("an apple pie")
    }

    //使用 lambda 表达式来过滤（filter）与映射（map）集合：
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { print(it) }
}

//创建基本类及其实例
fun createClass() {

}

//抽象类
abstract class Shape(val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double//抽象方法需要子类实现
}

//接口
interface RectangleProperties {
    val isSquare: Boolean
}

//接口实现类
class Rectangle(var height: Double, var width: Double) :
    Shape(listOf(height, width, height, width)), RectangleProperties {
    //实现抽象方法
    override fun calculateArea(): Double {
        return height * width
    }

    //实现接口方法
    override val isSquare: Boolean get() = (height == width)

}





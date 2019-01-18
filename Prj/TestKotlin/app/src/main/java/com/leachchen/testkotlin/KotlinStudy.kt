package com.leachchen.testkotlin

import android.util.Log

/**
 * ClassName:   KotlinStudy.java
 * Description:
 * Author :     leach.chen
 * Date:        2019/1/18 14:46
 **/
class KotlinStudy {
    /**
     * 定义静态部分
     */
    companion object {
        val TAG: String = "mytest";
        fun printLog(str: String) {
            Log.e(TAG, str)
        }
    }

    /************************函数写法**************************/
    /**
     * var <标识符> : <类型> = <初始化值>
     * 不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量) val <标识符> : <类型> = <初始化值>
     */
    fun testFun1(a: Int, b: Int): Int {
        return a + b
    }

    fun testFun2(a: Int, b: Int) = a + b

    fun testFun3(a: Int, b: Int): Int = a + b

    fun testFun4(a: Int, b: Int) {
        KotlinStudy.printLog("" + a + b);
    }

    /**
     * 可变参数 vararg
     */
    fun testFun5(vararg v: Int) {
        for (vt in v) {
            printLog("" + vt)
        }
    }

    /**
     *lambda表达式
     * // 1. 不需要参数,返回值为 5
    () -> 5

    // 2. 接收一个参数(数字类型),返回其2倍的值
    x -> 2 * x

    // 3. 接受2个参数(数字),并返回他们的差值
    (x, y) -> x – y

    // 4. 接收2个int型整数,返回他们的和
    (int x, int y) -> x + y

    // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
    (String s) -> System.out.print(s)
     */
    val testFun6: (Int, Int) -> Int = { x, y -> x + y }

    /**
     * 字符串模板
     * $ 表示一个变量名或者变量值
     * $varName 表示变量值
     * ${varName.fun()} 表示变量的方法返回值:
     */
    fun testFun7() {
        var a = "this data a $"
        var b = "$a" + " and this is data b " + "${a.replace("$", " $ relplace to " + testFun6(1, 2))}"
        printLog(b)
    }

    fun testFun8() {
        try {
            var a = 1
            var b = 0
            var c = a / b
        } catch (e: Exception) {
            printLog(e.toString())
        }
    }

    /**
     * NULL检查机制
     * Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出空异常，另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
     */
    fun testFun9() {
        //类型后面加?表示可为空
        var age: String? = "23"
        //var age: String? = null
        //抛出空指针异常
        val ages = age!!.toInt()
        //不做处理返回 null
        val ages1 = age?.toInt()
        //age为空返回-1
        val ages2 = age?.toInt() ?: -1
        printLog(" " + ages + " " + ages1 + " " + ages2)
    }

    /**
     * 类型检测及自动类型转换
     * 我们可以使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。
     */
    fun testFun10(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    /**
     * 区间
     */
    fun testFun11(value: Int) {
        for (a in 1..6) {
            printLog("a:" + a);
        }

        for (a in 1 until 6) {
            printLog("b:" + a);
        }

        if (value in 1..10) { // 等同于 1 <= i && i <= 10
            printLog("c" + value)
        }

        for (a in 1..6 step 2) {
            printLog("d:" + a);
        }

        for (a in 6 downTo 1) {
            printLog("e:" + a);
        }
    }

    /**
     * 比较两个数字
     * Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。
     * 数字类型也一样，所有在比较两个数字的时候，就有比较数据大小和比较两个对象是否相同的区别了。
     * 在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。
     */
    fun testFun12() {
        val a: Int = 10000
        printLog("" + (a === a)) // true，值相等，对象地址相等

        //经过了装箱，创建了两个不同的对象
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        //虽然经过了装箱，但是值是相等的，都是10000
        printLog("" + (boxedA === anotherBoxedA)) //  false，值相等，对象地址不一样
        printLog("" + (boxedA == anotherBoxedA)) // true，值相等
    }

    /**
     * 类型转换
     * 由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
     */
    fun testFun13() {
        //大的可以赋给小的，小的不能赋给大的
        val b: Byte = 1 // OK, 字面值是静态检测的
        //val i: Int = b // 错误
        val i: Int = b.toInt() // OK
    }

    /**
     * 数组
     * 数组用类 Array 实现，并且还有一个 size 属性及 get 和 set 方法，由于使用 [] 重载了 get 和 set 方法，所以我们可以通过下标很方便的获取或者设置数组对应位置的值。
     * 数组的创建两种方式：一种是使用函数arrayOf()；另外一种是使用工厂函数。如下所示，我们分别是两种方式创建了两个数组：
     *
     * 如上所述，[] 运算符代表调用成员函数 get() 和 set()。
     * 注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）。
     * 除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样：
     */
    fun testFun14() {
        //[1,2,3]
        val a = arrayOf("aa", 2, 3)
        //[0,2,4]
        val b = Array(3, { i -> (i * 2) })

        //读取数组内容
        printLog("" + a[1])    // 输出结果：1
        printLog("" + b[0])    // 输出结果：2

        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]
    }

    /**
     * IF 表达式
     */
    fun testFun15() {
        var x = 0
        if (x > 0) {
            printLog("x 大于 0")
        } else if (x == 0) {
            printLog("x 等于 0")
        } else {
            printLog("x 小于 0")
        }

        var a = 1
        var b = 2
        val c = if (a >= b) a else b
        printLog("c 的值为 $c")
    }

    /**
     * When 表达式
     * when 将它的参数和所有的分支条件顺序比较，直到某个分支满足条件。
     * when 既可以被当做表达式使用也可以被当做语句使用。如果它被当做表达式，符合条件的分支的值就是整个表达式的值，如果当做语句使用， 则忽略个别分支的值。
     * when 类似其他语言的 switch 操作符。其最简单的形式如下：
     *
     * 在 when 中，else 同 switch 的 default。如果其他分支都不满足条件将会求值 else 分支。
     * 如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
     *
     * 我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
     */
    fun testFun16(x : Int) {
        when (x) {
            1 -> printLog("x == 1")
            2 -> printLog("x == 2")
            else -> { // 注意这个块
                printLog("x 不是 1 ，也不是 2")
            }
        }

        when (x) {
            0, 1 -> printLog("x == 0 or x == 1")
            else -> printLog("otherwise")
        }

        when (x) {
            in 1..10 -> printLog("x is in the range")
            !in 10..20 -> printLog("x is outside the range")
            else -> printLog("none of the above")
        }
    }
}
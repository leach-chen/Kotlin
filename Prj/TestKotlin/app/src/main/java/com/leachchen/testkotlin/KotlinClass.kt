package com.leachchen.testkotlin

/**
 * ClassName:   KotionClass.java
 * Description:
 * Author :     leach.chen
 * Date:        2019/1/21 11:19
 **/

/**
 * 主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
 *
 * 如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。构造函数是 public 。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
 */
class KotlinClass constructor(value:String)
{
    var newValue = value
    init {
        KotlinStudy.printLog(value)
    }

    /**
     * 先执行主构造函数，再执行次构造函数
     * 如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。在同一个类中代理另一个构造函数使用 this 关键字：
     */
    constructor (value: String, age:Int) : this(value) {
        // 初始化...
        KotlinStudy.printLog("age:"+age)
    }
}
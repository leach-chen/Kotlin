package com.leachchen.testkotlin

/**
 * ClassName:   TestClassA.java
 * Description:
 * Author :     leach.chen
 * Date:        2019/1/21 11:36
 **/

/**
 * open open 注解与java 中的 final相反:它允许别的类继承这个类。默认情形下，kotlin 中所有的类都是 final ,用来表示他可以被集成
 */
open class TestClassA {

    /**
     * 子类继承父类时，不能有跟父类同名的变量，除非父类中该变量为 private，或者父类中该变量为 open 并且子类用 override 关键字重写:
     */
    open var testValue : String = ""
    init {
        KotlinStudy.printLog("TestClassA")
    }

    /**
     * 在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词
     */
    open fun f() {
        KotlinStudy.printLog("TestClassA f run")
    }
}
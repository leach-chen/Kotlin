package com.leachchen.testkotlin

/**
 * ClassName:   TestClassB.java
 * Description:
 * Author :     leach.chen
 * Date:        2019/1/21 11:35
 **/
abstract class TestClassB : TestClassA() {
    init {
        KotlinStudy.printLog("TestClassB")
    }

   abstract override fun f()
}
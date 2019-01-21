package com.leachchen.testkotlin

/**
 * ClassName:   TestInterFace.java
 * Description:
 * Author :     leach.chen
 * Date:        2019/1/21 13:47
 **/
interface TestInterFace {

    /**
     * 接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性
     */

    var nameInterface:String //name 属性, 抽象的

    /**
     * Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现
     */
    fun f() {
        KotlinStudy.printLog("TestInterFace f run")
    }

    fun kk() {
    }

    fun bar()                  // 未实现，没有方法体，是抽象的
}
package com.leachchen.testkotlin

/**
 * ClassName:   TestClassC.java
 * Description:
 * Author :     leach.chen
 * Date:        2019/1/21 11:41
 **/
open class TestClassC : TestClassB() {

    /**
     * 关于子类不能用 val 重写父类中的 var，我的猜测是：子类重写父类属性，也就相当于必须重写该属性的 getter 和 setter 方法，而子类中的 val 不能有 setter 方法，
     * 所以无法“覆盖”父类中 var 的 setter 方法，相当于缩小了父类中相应属性的使用范围，是不允许的，就像我们不能把父类中一个 public 方法重写成 private 方法一样
     */
    override var testValue : String = ""

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    override fun f() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        KotlinStudy.printLog("TestClassC f run")
    }
}
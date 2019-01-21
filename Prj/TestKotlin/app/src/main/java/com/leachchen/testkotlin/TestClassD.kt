package com.leachchen.testkotlin

/**
 * ClassName:   TestClassD.java
 * Description:
 * Author :     leach.chen
 * Date:        2019/1/21 11:49
 **/

/**
abstract    // 抽象类
final       // 类不可继承，默认属性
enum        // 枚举类
open        // 类可继承，类默认是final的
annotation  // 注解类
 */
class TestClassD :TestClassA() ,TestInterFace{
    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override var nameInterface: String= ""
    /*  get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}*/

    private val bar1 : Int = 1
    val bar2 : Int = 2

    /**
     * 继承的类和接口都有同名函数
     */
    override fun f() {
        super<TestClassA>.f()
        super<TestInterFace>.f()
        KotlinStudy.printLog("TestClassD f run")
    }

    /**
     * Kotlin中的内部类与嵌套类的定义，跟Java并没有什么不同，区别在于在没有任何修
    饰的情况下，定义在另一个类内部的类将被默认为嵌套类，不持有外部类的引用，如果要将
    它声明为一个内部类，则需要加上inner修饰符，代码如下：

    Java中，将一个类定义在另一个类内部，不加任何的修饰符，那它将被默认为一个内部类，而加
    上static修饰，则成为了一个嵌套类。

    嵌套类不能引用包装类的成员；内部类会带有一个对外部包装类的对象的引用，可以访问外部类中的成员属性和成员函数。
     */
    class TestClassE{   //嵌套类
        fun testE()
        {
            var o = TestClassD()
            KotlinStudy.printLog("out:"+o.bar1);
        }
    }

    /**
     * 内部类使用 inner 关键字来表示。
     * 内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
     */
    inner class TestClassF{   //内部类
        fun testF()
        {
            var o = this@TestClassD
            KotlinStudy.printLog("out 1:"+bar1);
            KotlinStudy.printLog("out 2:"+o.bar2);
        }
    }


    /**
     * 匿名内部类
     */
    fun setInterFace(test: TestInterFace) {
        test.f()
    }
}
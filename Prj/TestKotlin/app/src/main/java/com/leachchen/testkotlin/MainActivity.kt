package com.leachchen.testkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.leachchen.testkotlin.R.id.sample_text
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        //var kotlinStudy : KotlinStudy = KotlinStudy()
        var kotlinStudy = KotlinStudy()

        //KotlinStudy.printLog(""+kotlinStudy.testFun16(2))

        //var kotlinClass = KotlinClass("test value",0)
/*      var classO = TestClassD()
        classO.setInterFace(object : TestClassD.TestInterFace{
            override fun test() {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                KotlinStudy.printLog("setInterFace run")
            }
        })*/

  /*      var classO = TestClassC()
        classO.no = 20
        KotlinStudy.printLog(""+classO.no)*/

    /*    var classO = TestClassD.TestClassE()
        classO.testE()*/
        /*var classO = TestClassD().TestClassF()
        classO.testF()*/


    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}

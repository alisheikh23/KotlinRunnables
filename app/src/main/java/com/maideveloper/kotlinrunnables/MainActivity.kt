package com.maideveloper.kotlinrunnables

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number=0
    var runnable:Runnable=Runnable{}
    var handler:Handler=Handler()//handle our operation on runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun start(view: View){
        number=0
        runnable= object : Runnable {
            override fun run() {
                textView.text="Time :"+number
                number++
                textView.text="Time :"+number
                handler.postDelayed(this,1000)//handle delay of 1 sec interval
            }
        }
        handler.post(runnable)//post/show runnable that is time
    }


    fun reset(view: View){
        handler.removeCallbacks(runnable)//kills the runnable or we can say reset time
        number=0
        textView.text="Time :"+number
    }
}


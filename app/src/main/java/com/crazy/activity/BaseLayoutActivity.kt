package com.crazy.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.motion.widget.MotionLayout
import com.crazy.kotlin.R

abstract class BaseLayoutActivity : BaseActivity(), View.OnClickListener {

    override fun onClick(v: View) {
        when (v.id) {
            R.id.bt_start -> motionLayout.transitionToStart()
            R.id.bt_end -> motionLayout.transitionToEnd()
        }
    }

    lateinit var motionLayout: MotionLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        motionLayout = findViewById(R.id.motion_layout)
        (findViewById<Button>(R.id.bt_start)).setOnClickListener(this)
        (findViewById<Button>(R.id.bt_end)).setOnClickListener(this)

        onMotionListener()
    }

    var transitionListener: MotionLayout.TransitionListener =
        object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println("onTransitionTrigger")
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println("onTransitionStarted")
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println("onTransitionChange")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                println("onTransitionCompleted")
            }

        }


    fun onMotionListener() {
        val progress = motionLayout.progress
        println("progress: $progress")

        motionLayout.setTransitionListener(transitionListener)
    }
}

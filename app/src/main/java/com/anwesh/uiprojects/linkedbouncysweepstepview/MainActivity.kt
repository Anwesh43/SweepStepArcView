package com.anwesh.uiprojects.linkedbouncysweepstepview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.bouncysweepstepview.BouncySweepStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BouncySweepStepView.create(this)
    }
}

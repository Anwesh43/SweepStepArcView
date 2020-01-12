package com.anwesh.uiprojects.bouncysweepstepview

/**
 * Created by anweshmishra on 13/01/20.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Paint
import android.graphics.Color
import android.graphics.RectF
import android.graphics.Canvas

val nodes : Int = 5
val steps : Int = 5
val scGap : Float = 0.02f
val strokeFactor : Int = 90
val delay : Long = 20
val foreColor : Int = Color.parseColor("#01579B")
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawSweepStepArc(w : Float, scale : Float, paint : Paint) {
    val sk : Float = 1f / steps
    val sf : Float = scale.sinify()
    val i : Int = (sf / sk).toInt()
    val sfi : Float = sf.divideScale(i, steps)
    val gap : Float = w / steps
    save()
    translate(gap * i + gap / 2, 0f)
    drawArc(RectF(-gap / 2, -gap / 2, gap / 2, gap / 2), 180f, 180f * sfi, false, paint)
    restore()
}

fun Canvas.drawSSANode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(0f, gap * (i + 1))
    drawSweepStepArc(w, scale, paint)
    restore()
}

class BouncySweepStepView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}
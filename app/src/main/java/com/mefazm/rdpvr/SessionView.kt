package com.mefazm.rdpvr

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.view.View

class SessionView(context: Context) : View(context) {
    fun setSessionSize(f: (w: Int, h: Int) -> Unit) {
        setSessionSizeCall = f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.i("width: $width, height: $height")
        val bmp = createBitmap(colors, w, h, Bitmap.Config.ARGB_8888)
        canvas.drawBitmap(bmp, null, dst, null)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.i("width: $w, height: $h")
        setSessionSizeCall?.invoke(w, h)
    }

    private val w = 10
    private val h = 10
    private val dst = Rect(10, 10, 20, 20)
    private val colors = IntArray(w * h) { Color.GREEN }
    private var setSessionSizeCall: ((Int, Int) -> Unit)? = null
}

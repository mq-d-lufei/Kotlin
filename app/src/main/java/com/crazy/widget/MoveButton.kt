package com.crazy.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.MotionEvent.*
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout

class MoveButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {

    val title = "move button"

    init {
        text = title
    }

    var lastX: Float = 0.0f
    var lastY: Float = 0.0f


    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val currentX: Float
        val currentY: Float

        when (event?.action) {
            ACTION_DOWN -> {
                lastX = event.x
                lastY = event.y
            }
            ACTION_MOVE -> {

                currentX = event.x
                currentY = event.y

                if (currentX - lastX > 15 && currentY - lastY > 15)
                    notifyLayout(currentX - lastX, currentY - lastY)
            }
            ACTION_UP -> {

            }
        }
        return true
    }

    fun move(moveX: Float, moveY: Float) {
        translationX = moveX
        translationY = moveY
    }

    fun notifyLayout(moveX: Float, moveY: Float) {
        val p = layoutParams as ConstraintLayout.LayoutParams
        p.leftMargin += moveX.toInt()
        p.rightMargin += moveY.toInt()
        layoutParams = p
        requestLayout()
    }

}

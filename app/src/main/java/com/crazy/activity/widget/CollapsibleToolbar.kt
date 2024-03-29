package com.crazy.activity.widget

import android.content.Context
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout
import android.util.AttributeSet

class CollapsibleToolbar @JvmOverloads constructor(
    context: Context, arrrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, arrrs, defStyleAttr), AppBarLayout.OnOffsetChangedListener {

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }

}
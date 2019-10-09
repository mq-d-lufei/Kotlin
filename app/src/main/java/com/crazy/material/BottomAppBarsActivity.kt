package com.crazy.material

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.crazy.activity.BaseActivity
import com.crazy.kotlin.R
import com.google.android.material.bottomappbar.BottomAppBar.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_bottom_app_bars.*

class BottomAppBarsActivity : BaseActivity() {

    var fabChecked: Boolean = false

    override fun getActivityLayout(): Int {
        return R.layout.activity_bottom_app_bars
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //appbar
        bar.replaceMenu(R.menu.demo_primary)
        bar.setOnMenuItemClickListener { item ->
            showShackbar(item.title)
            true
        }
        //Navigation
        //setSupportActionBar(bar)
        bar.setNavigationOnClickListener { item ->
            when (item.id) {
                android.R.id.home -> showShackbar(item.contentDescription)
                else -> showShackbar(item.contentDescription)
            }
        }
        //fab

        fab.setOnClickListener {
            fabChecked = !fabChecked
            if (fabChecked) {
                bar.fabAnimationMode = FAB_ANIMATION_MODE_SCALE
                bar.fabAlignmentMode = FAB_ALIGNMENT_MODE_END
            } else {
                bar.fabAnimationMode = FAB_ANIMATION_MODE_SLIDE
                bar.fabAlignmentMode = FAB_ALIGNMENT_MODE_CENTER
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.demo_primary, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        showShackbar(item?.title ?: "title is null")
        return super.onOptionsItemSelected(item)
    }

    fun showShackbar(text: CharSequence) {
        Snackbar.make(coordinatorLayout, text, Snackbar.LENGTH_SHORT)
            .setAnchorView(if (fab.visibility == View.VISIBLE) fab else bar)
            .show()
    }
}

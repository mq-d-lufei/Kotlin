package com.crazy.material

import android.os.Bundle
import com.crazy.activity.BaseActivity
import com.crazy.kotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

/**
 *
 * https://android.jlelse.eu/ultimate-guide-to-bottom-navigation-on-android-75e4efb8105f
 * https://medium.com/over-engineering/hands-on-with-material-components-for-android-bottom-navigation-aae2aa9066be
 *  1、显示三到五个目的地，每一个都有一个图标和一个可选文本标签
 *
 */

class BottomNavigationActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home, R.id.navigation_dashboard -> {
                    showSnackBar(item.title)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    showSnackBar("Second: " + item.title)
                    return@OnNavigationItemSelectedListener true
                }
            }
            // return@OnNavigationItemSelectedListener
            false
        }

    private val mOnNavigationItemReselectedListener =
        BottomNavigationView.OnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home, R.id.navigation_dashboard -> {
                    showSnackBar("reselected " + item.title)
                }
                R.id.navigation_notifications -> {
                    showSnackBar("reselected: " + item.title)
                }
            }
        }

    override fun getActivityLayout(): Int {
        return R.layout.activity_bottom_navigation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.setOnNavigationItemReselectedListener(mOnNavigationItemReselectedListener)

        navigation.selectedItemId = R.id.navigation_dashboard

        setBadging()
    }

    /**
     * BottomNavigationView:showBadge/removeBadge
     * BadgeDrawable :getBadge/setNumber/getNumber/hasNumber/clearBadgeNumber:
     *                  setMaxCharacterCount/getMaxCharacterCount
     */
    fun setBadging() {
        navigation.showBadge(R.id.navigation_notifications)
        //bottomNavigation.removeBadge(R.id.item1) // Remove badge
        val badge = navigation.getBadge(R.id.navigation_notifications)
        badge?.maxCharacterCount = 4
        badge?.number = 1000
    }

    fun showSnackBar(text: CharSequence) {
        Snackbar.make(navigation, text, Snackbar.LENGTH_SHORT)
            .setAnchorView(navigation)
            .show()

    }

}

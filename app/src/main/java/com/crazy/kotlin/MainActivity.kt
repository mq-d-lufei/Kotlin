package com.crazy.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.crazy.activity.*
import com.crazy.activity.widget.EmergencyTypeDrawable
import com.crazy.jetpack.db.WordRoomDatabase
import com.crazy.material.main.MaterialActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        startMyActviity(v?.id ?: R.id.bt_activity1)
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    message.setText(R.string.title_home)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    message.setText(R.string.title_dashboard)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    message.setText(R.string.title_notifications)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        message.text = "123"
        message.background = EmergencyTypeDrawable(resources)

        bt_activity1.setOnClickListener(this)
        bt_activity2.setOnClickListener(this)
        bt_activity3.setOnClickListener(this)
        bt_activity4.setOnClickListener(this)
        bt_activity5.setOnClickListener(this)
        bt_activity6.setOnClickListener(this)

        val db = WordRoomDatabase.getDatabase(this.applicationContext)
        val dao = db.wordDao()
    }

    fun startMyActviity(id: Int) {
        val intent = Intent()

        when (id) {
            R.id.bt_activity1 ->
                intent.setClass(this, LayoutActivity::class.java)
            R.id.bt_activity2 ->
                intent.setClass(this, Layout2Activity::class.java)
            R.id.bt_activity3 ->
                intent.setClass(this, Layout3Activity::class.java)
            R.id.bt_activity4 ->
                intent.setClass(this, Layout4Activity::class.java)
            R.id.bt_activity5 ->
                intent.setClass(this, Layout5Activity::class.java)
            R.id.bt_activity6 ->
                intent.setClass(this, MaterialActivity::class.java)

            else ->
                intent.setClass(this, KtActivity::class.java)
        }

        startActivity(intent)
    }
}

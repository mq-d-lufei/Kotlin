package com.crazy.material.main

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crazy.activity.BaseActivity
import com.crazy.jetpack.databinding.DatabindingActivity
import com.crazy.jetpack.databinding.LoginDatabindingActivity
import com.crazy.kotlin.R
import com.crazy.material.BottomAppBarsActivity
import com.crazy.material.BottomNavigationActivity
import com.crazy.material.coordinatorlayout.CoordinatorActivity


class MaterialActivity : BaseActivity() {

    override fun getActivityLayout(): Int {
        return R.layout.activity_material
    }


    private lateinit var mData: ArrayList<MaterialItem>
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    companion object SataicClass {

        val array: ArrayList<MaterialItem> = arrayListOf()

    }

    private fun init() {
        val materialItem =
            MaterialItem(
                "BottomAppBar",
                Intent(this, BottomAppBarsActivity::class.java)
            )
        val materialItem1 =
            MaterialItem(
                "BottomNavigationView",
                Intent(this, BottomNavigationActivity::class.java)
            )
        val materialItem2 =
            MaterialItem(
                "CoordinatorActivity",
                Intent(this, CoordinatorActivity::class.java)
            )
        val materialItem3 =
            MaterialItem(
                "DatabindingActivity",
                Intent(this, DatabindingActivity::class.java)
            )
        val materialItem4 =
            MaterialItem(
                "LoginDatabindingActivity",
                Intent(this, LoginDatabindingActivity::class.java)
            )

        mData =
            arrayListOf(materialItem, materialItem1, materialItem2, materialItem3, materialItem4)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

        viewManager = GridLayoutManager(this, 3)
        viewAdapter = MaterialAdapter(mData)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {

            setHasFixedSize(true)
            adapter = viewAdapter
            layoutManager = viewManager

        }
    }
}

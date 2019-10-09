package com.crazy.material.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crazy.kotlin.R
import com.google.android.material.button.MaterialButton

class MaterialAdapter constructor(private val data: ArrayList<MaterialItem>) :
    RecyclerView.Adapter<MaterialAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val button =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_material_item, parent, false)

        return MyHolder(button as MaterialButton)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val (title, intent) = data[position]

        holder.button.text = title
        holder.button.setOnClickListener { holder.button.context.startActivity(intent) }
    }

    //嵌套类 相当于Java静态内部类
    class MyHolder(val button: MaterialButton) : RecyclerView.ViewHolder(button)


}
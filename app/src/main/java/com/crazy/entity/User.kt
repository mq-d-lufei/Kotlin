package com.crazy.entity

import com.crazy.kotlin.R

data class User(var firstName: String = "Crazy", var lastName: String, var age: Int = 19) {

    constructor(sex: Boolean) : this("Crazy", "Zero", 18) {
        this.sex = sex
    }

    var sex: Boolean = false

    var id: Long = 0

    val headImg: Int = R.mipmap.ic_launcher

}
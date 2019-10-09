package com.crazy.entity

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.databinding.ObservableLong
import com.crazy.kotlin.R

class ObsUser {
    var id = ObservableLong(1)
    val firstName = ObservableField<String>("ObsFirstName")
    val lastName = ObservableField<String>("ObsLastName")
    var age = ObservableInt(12)
    var sex = ObservableBoolean(false)
    val headImg = ObservableInt(R.mipmap.ic_launcher)
}
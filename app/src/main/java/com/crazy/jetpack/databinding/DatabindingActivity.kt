package com.crazy.jetpack.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableArrayMap
import com.crazy.entity.*
import com.crazy.kotlin.R
import com.crazy.kotlin.databinding.ActivityDataBindingBinding

class DatabindingActivity : AppCompatActivity() {

    public lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityDataBindingBinding>(
            this,
            R.layout.activity_data_binding
        )
        //setContentView(R.layout.activity_data_binding)

        //binding = ActivityDataBindingBinding.inflate(layoutInflater)

        //userName.text = "first name"

        initUser()

        obsObj(binding)
        obsUser()
        obsMap()
        obsList()
        initHandler()
    }

    fun initUser() {
        val user = User("Crazy", "Zero", 18).apply {
            this.id = 1
            sex = true
        }
        binding.user = user
    }

    fun obsUser() {
        val obsUser = ObsUser()

        //binding.obsUser = obsUser

        obsUser.firstName.set("FirstName")
        obsUser.lastName.set("LastName")
        obsUser.age.set(10)
    }

    fun obsMap() {
        ObservableArrayMap<String, Any>().apply {
            put("firstName", "Crazy")
            put("lastName", "Zero")
            put("age", 18)
            put("sex", true)
        }

        //binding.mapUser = ObservableArrayMap()
    }

    fun obsList() {
        ObservableArrayList<Any>().apply {
            add("Crazy")
            add("Zero")
            add(18)
        }
        //binding.listUser = ObservableArrayList()
    }

    fun obsObj(binding: com.crazy.kotlin.databinding.ActivityDataBindingBinding) {
        val objUser = ObsObjUser()
        //binding.objUser = objUser

        objUser.firstName = "obj-LastName"
        objUser.lastName = "obj-LastName"
    }

    fun initHandler() {
        binding.handler = OnClickHandler()
    }

    inner class OnClickHandler {
        fun userHandler() {
            val user = User("New_Crazy", "New_Zero", 19).apply {
                this.id = 2
                sex = true
            }
            binding.user = user
        }
    }


}


fun main(args: Array<String>) {

    test()
}

fun test() {
    var loginInfo = LoginInfo("Crazy", "123456")


    var user = User("Crazy", "Zero", 18)

    var car = Car("AE")


    println("loginInfo= ${loginInfo.toString()}")
    print("car= ${car.toString()}")

}

package com.crazy.entity

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.crazy.kotlin.R

/**
 * 数据类
 *   只保存数据的类
 */
data class ObsLoginInfo @JvmOverloads constructor(
    var username: ObservableField<String> = ObservableField("Crazy"),
    var password: ObservableField<String> = ObservableField("123456")
) {
    var id = ObservableInt(1)
    var age = ObservableInt()
    var sex = ObservableBoolean()

    var headImg = ObservableInt(R.mipmap.ic_head_1)

    var imgRes = R.mipmap.ic_head_1

    var userNameTvText = ObservableField("用户名")
    var userNameEtHint = ObservableField("请输入用户名")

    var passwordTvText = ObservableField("密码")
    var passwordEthint = ObservableField("请输入密码")

    var loginText = ObservableField("登录")
}
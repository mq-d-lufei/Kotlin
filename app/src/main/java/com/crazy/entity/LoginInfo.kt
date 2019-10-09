package com.crazy.entity

import com.crazy.kotlin.R

/**
 * 数据类
 *   只保存数据的类
 */
data class LoginInfo @JvmOverloads constructor(
    var username: String = "Crazy",
    var password: String = "123456"
) {
    var id: Int = 0
    var age: Int = 0
    var sex: Boolean = false

    var headImg: Int = R.mipmap.ic_head_1

    var userNameTvText: String = "用户名"
    var userNameEtHint: String = "请输入用户名"

    var passwordTvText: String = "密码"
    var passwordEthint: String = "请输入密码"

    var loginText = "登录"
}
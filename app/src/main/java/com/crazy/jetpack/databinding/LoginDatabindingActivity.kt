package com.crazy.jetpack.databinding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import com.crazy.entity.ObsLoginInfo
import com.crazy.kotlin.R
import com.crazy.kotlin.databinding.ActivityDataBindingLoginBinding

class LoginDatabindingActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var binding: ActivityDataBindingLoginBinding
    //    lateinit var loginInfo: LoginInfo
    lateinit var loginInfo: ObsLoginInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_login)

        //initUserInfo()
        initObsLoginInfo()
    }

    /* private fun initUserInfo() {
         loginInfo = LoginInfo()
         binding.loginInfo = loginInfo
         binding.loginHandler = LoginHandler()
     }*/

    private fun initObsLoginInfo() {
        loginInfo = ObsLoginInfo()
        binding.loginInfo = loginInfo
        binding.loginHandler = LoginHandler()
    }

    inner class LoginHandler {

        fun OnLoginHandler() {
            Toast.makeText(context, "登录", Toast.LENGTH_SHORT).show()
            /*loginInfo.loginText = "登录中..."
            loginInfo.userNameEtHint = "必须输入用户名"*/

//            val info = LoginInfo()
            // val info = ObsLoginInfo()
            loginInfo.loginText.set("登录中...")
            loginInfo.userNameEtHint.set("必须输入用户名")
            loginInfo.imgRes = R.mipmap.ic_head_2
            loginInfo.headImg.set(R.mipmap.ic_head_2)

            //binding.loginInfo = info

            startActivity(Intent(context, LifecycleActivity::class.java))
        }

        fun onLoginLongHandler() {
            Toast.makeText(context, "登录", Toast.LENGTH_SHORT).show()
        }

    }
}

/**
 * 可单项绑定
 */
@BindingAdapter("resId", requireAll = false)
fun notifyImage(imageView: ImageView, resId: ObservableInt) {

    val res = resId.get()
    Log.e("resId", "resId = $resId — res=$res ")

    //imageView.setImageResource(resId.get())
}

/**
 * 在布局文件中通过app:imgRes="@{...}"
 */
@BindingAdapter("imgRes")
fun notifyImage(imageView: ImageView, imgRes: Int) {
    Log.e("imgRes", "imgRes = $imgRes")
    // imageView.setImageResource(imgRes)
}

//@BindingConversion
//fun conversionString(text: String): String = "$text -conversion"

//@BindingConversion
//fun conversionRes(text: String): Int {
//    when (text) {
//        "head1" -> return R.mipmap.ic_head_1
//        "head2" -> return R.mipmap.ic_head_2
//        else -> return R.mipmap.ic_launcher
//    }
//}
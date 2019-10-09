package com.crazy.kotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.crazy.learn.pixelsToValue
import com.crazy.learn.prepareMatrixOffset

class KtActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    lateinit var mbitmap: Bitmap

    var mMatrix: Matrix = Matrix()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt)

        imageView = findViewById(R.id.image)

        mbitmap = BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher)

        // matrixFun()
    }

    fun matrixFun() {
        println(mMatrix.toShortString())

        prepareMatrixOffset(20f, 50f)

        var pixels = FloatArray(2)
        pixels[0] = 30f
        pixels[1] = 60f

        pixelsToValue(pixels)
    }

    fun bitmapFun() {


    }

    var x: Float = 10f
    var y = 20f

    fun OnTrans(view: View) {

        println("mMatrix= ${mMatrix.toShortString()}")

        x += 10
        y += 10

        mMatrix.postTranslate(-x, -y)

        println("mMatrix= ${mMatrix.toShortString()}")

        val tempBitmap =
            Bitmap.createBitmap(
                mbitmap, 0, 0,
                mbitmap.width, mbitmap.height, mMatrix, true
            )

        imageView.setImageBitmap(tempBitmap)
    }

    var degrees = 60f

    fun OnRotate(view: View) {
        println("mMatrix= ${mMatrix.toShortString()}")

        degrees += 10

        mMatrix.postRotate(degrees)

        println("mMatrix= ${mMatrix.toShortString()}")

        val tempBitmap =
            Bitmap.createBitmap(
                mbitmap, 0, 0,
                mbitmap.width, mbitmap.height, mMatrix, true
            )

        imageView.setImageBitmap(tempBitmap)
    }

    var i = 0f
    var j = 0f

    fun OnScale(view: View) {
        println("mMatrix= ${mMatrix.toShortString()}")

        mMatrix.reset()

        i += 1
        j += 1

        mMatrix.postTranslate(-x, -y)
        mMatrix.postScale(i, -j)
        // mMatrix.postScale(i, -j)


        println("mMatrix= ${mMatrix.toShortString()}")

        val tempBitmap =
            Bitmap.createBitmap(
                mbitmap, 0, 0,
                mbitmap.width, mbitmap.height, mMatrix, true
            )

        imageView.setImageBitmap(tempBitmap)
    }

    fun OnSkew(view: View) {

        println("mMatrix= ${mMatrix.toShortString()}")

        mMatrix.reset()

        x += 10
        y += 10

        mMatrix.setSkew(x, y)

        println("mMatrix= ${mMatrix.toShortString()}")

        val tempBitmap =
            Bitmap.createBitmap(
                mbitmap, 0, 0,
                mbitmap.width, mbitmap.height, mMatrix, true
            )

        imageView.setImageBitmap(tempBitmap)

    }

    /**
     *
     * 灵武 - 定边 21.31 - 23.10  69.5  硬卧  有
     * 定边 - 太原 23.10 - 4.03   129   硬卧  有
     *
     * 太原 - 石家庄北 4.09 - 5.57 83.5 硬卧
     * 石家庄北 - 北京西 6.03 - 8.34 89.5
     *
     *  太原 - 北京西 4.09 - 8.34 129
     *
     * 327.5
     *
     */
}

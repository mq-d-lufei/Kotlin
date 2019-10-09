package com.crazy.learn

import android.graphics.Matrix
import android.graphics.PointF
import java.util.*

/***
 *
 *  Matrix
 *
 *  性质：
 *      矩阵不满足交换律
 *      矩阵满足结合律
 *
 *  前乘（pre） 相当于矩阵的右乘（右乘特殊矩阵在右）（前乘：矩阵M在左）
 *      M' = M * S
 *      这表示一个矩阵M与一个特殊矩阵S前乘后构造出结果矩阵M'。
 *
 *      //执行顺序：M * T * R
 *      Matrix matrix = new Matrix();
 *      matrix.preTranslate(pivotX,pivotY);
 *      matrix.preRotate(angle);
 *      Log.e("Matrix", matrix.toShortString());
 *
 *  后塍（post） 相当于左乘
 *      M' = S * M
 *      这表示一个矩阵M与一个特殊矩阵S后乘后构造出结果矩阵M'。
 *
 *      //执行顺序：R * M -> T * (R * M)
 *      Matrix matrix = new Matrix();
 *      matrix.postRotate(angle);
 *      matrix.postTranslate(pivotX,pivotY)
 *      Log.e("Matrix", matrix.toShortString());
 *
 *      //执行顺序：M * R -> T * (M * R)
 *      Matrix matrix = new Matrix();
 *      matrix.preRotate(angle);
 *      matrix.postTranslate(pivotX,pivotY);
 *
 *  实例，假设有M-T-R-S-...-R-S-(-T)的操作，可变换为如下
 *
 *      M' = M * T * R*S*...*R*S * -T = T * R*S*...*R*S * -T = T * (R*S*...*R*S) * -T
 *
 *      Matrix matrix = new Matrix();
 *      matrix.preTranslate(pivotX,pivotY);
 *      matrix.pre(R*S*...*R*S) 操作
 *      matrix.preTranslate(-pivotX, -pivotY);
 *      可转换为
 *      Matrix matrix = new Matrix();
 *      matrix.pre(R*S*...*R*S) 操作
 *      matrix.postTranslate(pivotX,pivotY);
 *      matrix.preTranslate(-pivotX, -pivotY);
 *
 */


fun main(agrs: Array<String>) {

    var mMatrix = android.graphics.Matrix()

    println(mMatrix.toString())
}

var mMatrixOffset = Matrix()

fun prepareMatrixOffset(dx: Float, dy: Float) {

    mMatrixOffset.reset()
    println("mMatrixOffset-> ${mMatrixOffset.toShortString()}")
    println("dx=$dx , dy=$dy")


    mMatrixOffset.setTranslate(dx, dy)
    println("mMatrixOffset-> ${mMatrixOffset.toShortString()}")
    println("dx=$dx , dy=$dy")

    mMatrixOffset.postScale(1.0f, -1.0f)

    println("mMatrixOffset-> ${mMatrixOffset.toShortString()}")

}

var mPixelToValueMatrixBuffer: Matrix = Matrix()

fun pixelsToValue(pixels: FloatArray) {

    var tmp = mPixelToValueMatrixBuffer
    tmp.reset()

    println("pixels-> ${Arrays.toString(pixels)}")
    println("mMatrixOffset-> ${mMatrixOffset.toShortString()}")


    //反转矩阵到原始值
    mMatrixOffset.invert(tmp)
    tmp.mapPoints(pixels)

    println("mMatrixOffset-> ${mMatrixOffset.toShortString()}")
    println("tmp-> ${tmp.toShortString()}")
    println("pixels-> ${Arrays.toString(pixels)}")

}

val translatePoint: PointF = PointF(10f, 20f)
val scalePoint: PointF = PointF(1.5f, 1.5f)
val skewPoint: PointF = PointF(10f, 10f)
val rotatePoint: PointF = PointF(0f, 0f)
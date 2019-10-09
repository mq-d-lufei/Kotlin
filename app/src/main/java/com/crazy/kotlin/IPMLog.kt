package com.crazy.kotlin

import com.crazy.kotlin.utils.DateUtil
import java.util.*

fun main(args: Array<String>) {


    val ipmTimeList = listOf(
        "18:33:06",
        "22:20:58",
        "2:04:26",
        "2:04:42",
        "5:52:42",
        "5:53:07",
        "9:41:25",
        "13:25:06",
        "13:25:07",
        "17:11:53",
        "20:53:21",
        "20:53:23",
        "24:38:06",
        "0:38:06",
        "4:23:54",
        "8:08:40",
        "11:58:22",
        "11:58:31",
        "15:44:08",
        "15:44:15",
        "19:32:12",
        "19:32:44",
        "23:16:59",
        "3:01:29",
        "6:51:29",
        "10:35:06"
    )

    val tiTimeList = listOf(
        "18:32:55",
        "18:33:13",
        "22:21:04",
        "2:04:36",
        "5:52:34",
        "5:52:35",
        "9:41:21",
        "9:41:28",
        "13:25:07",
        "17:11:52",
        "17:11:57",
        "20:53:29",
        "0:38:11",
        "4:23:57",
        "8:08:41",
        "11:58:36",
        "15:44:18",
        "15:44:24",
        "19:32:14",
        "23:16:58",
        "3:01:38",
        "6:51:35",
        "10:35:15"
    )

    logTimeInfo(ipmTimeList)

    println(" ********************************************* ")
    println(" ********************************************* ")
    println(" ********************************************* ")

    logTimeInfo(tiTimeList)


    val a = "1:00:00"
    val b = "2:00:00"

    val time = getLongData(b) - getLongData(a)
    println("time = $time   ${getStrData(time)}")

}

fun logTimeInfo(timeList: List<String>) {

    println("ipmTimeList.size = ${timeList.size}")

    val iterator = timeList.listIterator()
    var lastData = 0L
    var currentData = 0L

    while (iterator.hasNext()) {
        var time = iterator.next()
        println(time)
        lastData = getLongData(time)

        if (iterator.hasNext()) {
            time = iterator.next()
            currentData = getLongData(time)

            if (currentData < lastData) {
                currentData += 24 * 60 * 60 * 1000
            }

            // println("         ${currentData - lastData} millS")
            // println("         ${(currentData - lastData) / 1000 / 3600} h")
            println("         ${getStrData(currentData - lastData - 8 * 60 * 60 * 1000)}")
            println(time)
            iterator.previous()
        }
    }
}

val datePattern = "HH:mm:ss";

fun getLongData(strDate: String): Long {

    val data = DateUtil.parse(strDate, datePattern)

    val longTime = data.time

    //println("longTime = $longTime")

    return longTime
}

fun getStrData(date: Long): String {

    val dateFormat = DateUtil.format(Date(date), datePattern)

    // println("dateFormat = $dateFormat")

    return dateFormat
}
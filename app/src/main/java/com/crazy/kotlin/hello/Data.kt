package com.crazy.kotlin.hello

data class Data(var id: Long) {

    var sum: Long = 0L

    private var content = ""

    var isOpen = true

    var isInt = 1

    fun setId2(id: Long) {
        this.id = id
    }

    fun getId2(): Long {
        return id
    }

    fun setcontennt2(content: String) {
        this.content = content
    }

    fun getcontennt2(): String {
        return content
    }

}
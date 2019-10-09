package com.crazy.jetpack.databinding

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*

class LifecycleActivity : AppCompatActivity(), LifecycleOwner {

    /**
     * 伴生对象（相当于Java的静态成员）
     */
    companion object HolderClass {
        val TAG: String = LifecycleActivity::class.java.simpleName
    }

    init {
        var x: String = "123"
    }

    lateinit var lifecycleRegistry: LifecycleRegistry

    lateinit var locationLifecycleObserver: LifecycleObserver

    lateinit var liveData: LiveData<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationLifecycleObserver = LocationListener()

        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.currentState = Lifecycle.State.CREATED

        lifecycle.addObserver(locationLifecycleObserver)

        initLiveData()
    }

    private fun initLiveData() {
        liveData = MutableLiveData<String>()
        liveData.observe(this, ObsString())

        (liveData as MutableLiveData).value = "New String ..."
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(locationLifecycleObserver)
    }

    override fun getLifecycle(): Lifecycle {
        return super.getLifecycle()
    }


    class LocationListener : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onLocationStart() {
            Log.e(TAG, "onLocationStart")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun onLocationEnd() {
            Log.e(TAG, "onLocationEnd")
        }
    }

    class ObsString : Observer<String> {
        override fun onChanged(t: String?) {
            Log.e(TAG, t ?: "t is null")
        }
    }
}


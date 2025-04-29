package com.example.homework.kotlin.task2

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalTime
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class LaunchTimeDelegate(private val scope: CoroutineScope) : ReadOnlyProperty<Any?, String> {
    private val launchTime = LocalTime.now().toString()

    init {
        scope.launch(Dispatchers.Default) {
            while (true) {
                delay(3000)
                Log.d("LaunchTimeDelegate", "Launch time (cached): $launchTime")
            }
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return launchTime
    }
}
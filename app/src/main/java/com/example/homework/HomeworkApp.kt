package com.example.homework

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

class HomeworkApp : Application() {
    val appScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    override fun onTerminate() {
        super.onTerminate()
        appScope.cancel()
    }
}
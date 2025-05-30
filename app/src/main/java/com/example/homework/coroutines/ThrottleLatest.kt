package com.example.homework.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

fun <T> Flow<T>.throttleLatest(duration: Duration): Flow<T> = channelFlow {
    var lastValue: T?
    var job: Job? = null

    collect { value ->
        lastValue = value
        if (job == null || job?.isCompleted == true) {
            job = launch {
                delay(duration)
                lastValue?.let { send(it) }
                lastValue = null
            }
        }
    }
}

fun main(): Unit = runBlocking {
    flow {
        emit(1)
        delay(100)
        emit(2)
        delay(400)
        emit(3)
        delay(400)
        emit(4)
        emit(5)
        delay(400)
        emit(6)
        emit(7)
        delay(500)
        emit(8)
    }.throttleLatest(300.milliseconds)
        .collect {
            println(it)
        }
}
package com.example.homework.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

fun <T> Flow<T>.throttleFirst(duration: Duration): Flow<T> = flow {
    var lastEmissionTime = 0L

    collect { value ->
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastEmissionTime >= duration.inWholeMilliseconds) {
            lastEmissionTime = currentTime
            emit(value)
        }
    }
}

fun main(): Unit = runBlocking {
    flow {
        emit(1)
        delay(100)
        emit(2)
        delay(100)
        emit(3)
        delay(200)
        emit(4)
        emit(5)
        delay(200)
        emit(6)
        delay(300)
        emit(7)
    }.throttleFirst(300.milliseconds)
        .collect {
            println(it)
        }
}
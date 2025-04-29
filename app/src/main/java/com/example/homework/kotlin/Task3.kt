package com.example.homework.kotlin

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

fun List<Any>.findFirstInt(): Int? {
    return this.firstOrNull { it is Int } as? Int
}

@Composable
fun Task3(innerPadding: PaddingValues) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) { FindIntButton() }
}

@Composable
private fun FindIntButton() {
    val list: List<Any> = listOf(
        "Привет",
        3.14,
        true,
        'A',
        42,
        listOf(1, 2),
        mapOf("key" to "value"),
        100L,
        "ещё строка"
    )
    Button(onClick = {
        val foundInt = list.findFirstInt()
        Log.d("IntFinder", "Найденное Int: $foundInt")
    }) {
        Text("Найти Int в списке")
    }
}
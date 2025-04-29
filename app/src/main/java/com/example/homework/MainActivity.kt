package com.example.homework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import com.example.homework.kotlin.Task3
import com.example.homework.kotlin.task2.LaunchTimeDelegate
import com.example.homework.ui.theme.HomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val launchTime by LaunchTimeDelegate((application as HomeworkApp).appScope)
        enableEdgeToEdge()
        setContent {
            HomeworkTheme {
                Scaffold { innerPadding ->
                    Task3(innerPadding)
                }
            }
        }
    }
}
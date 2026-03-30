package com.example.sparktime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sparktime.ui.theme.SparkTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SparkTimeTheme {
                var timeOfday = arrayOf("Morning","Mid-Morning","Afternoon","Afternoon Snack","Evening","After Dinner")
                var text by remember {mutableStateOf("") }
                var results by remember {mutableStateOf("") }
                Column(){
                    Text("SparkTime")
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = {Text("Enter time of the day")}
                    )

                    Row(){
                        Button(
                            onClick = {
                                results = when(text) {
                                    "Morning" -> "Send a Good Morning text to family members"
                                    "Mid-Morning" -> "Reach out to a colleague with a quick Thak You"
                                    "Afternoon" -> "Share a funny meme or interesting link  with a friend"
                                    "Afternoon-Snack" -> "Send a quick thinking of you  text"
                                    "Evening" -> "Call a friend or a relative for a 5-minute catch-up"
                                    "After-Dinner" -> "Leave a thoughtfulcomment on a friend's post"
                                    else -> "Invaild input"
                                }
                            }
                        ) {
                            Text("Suggest")
                        }
                        Button(
                            onClick = {
                                text = ""
                                results = ""

                            }
                        ){
                            Text("Reset")
                        }
                    }
                    Text (results)
                }
            }
        }
    }
}






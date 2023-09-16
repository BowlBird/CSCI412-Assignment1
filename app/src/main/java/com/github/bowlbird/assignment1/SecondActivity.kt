package com.github.bowlbird.assignment1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.github.bowlbird.assignment1.ui.theme.Assignment1Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(MaterialTheme.colorScheme.primaryContainer)
                        ) {

                            data class Challenge(val title: String, val description: String)
                            val challenges = listOf(
                                Challenge(
                                    "Device Fragmentation",
                                    "There are lots of screen sizes, battery capacities, processing powers, and OS versions to account for."
                                ),
                                Challenge(
                                    "Unstable and Dynamic Environment",
                                    "A user may quickly go between having good or bad connectivity, battery, and sensor data."
                                ),
                                Challenge(
                                    "Rapid Changes",
                                    "There are constant OS, framework, language, and API updates that make some functionality deprecated."
                                ),
                                Challenge(
                                     "Tool support",
                                    "There can be a lack of tools, and some tools like the emulator can be poor in performance."
                                ),
                                Challenge(
                                    "Low Tolerance By Users",
                                    "Anyone using an app is highly likely to uninstall when it becomes slightly inconvenient to use the app."
                                )
                            )

                            challenges.forEach {
                                DisplayChallenge(it.title, it.description)
                            }
                        }

                        val context = LocalContext.current

                        Button(onClick = {
                            context.startActivity(Intent(context, MainActivity::class.java))
                        }) {
                            Text(text = "Go Back")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayChallenge(title: String, description: String) =
    Column(modifier = Modifier
        .padding(10.dp)
        .clip(shape = RoundedCornerShape(20.dp))
        .background(MaterialTheme.colorScheme.inverseOnSurface)
        .padding(10.dp)
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 5.em)
        Text(text = description, fontSize = 4.em)
}
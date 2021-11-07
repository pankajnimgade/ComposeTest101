package com.example.test101.compose106

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.R
import com.example.test101.compose106.ui.theme.Test101Theme

class Compose106Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test101Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    GreetingToListOfUsers(names = listOf<String>("David", "Jack", "Android"))
                }

            }
        }
    }


    @Composable
    fun CheckLayoutGravity() {
        Row(modifier = Modifier
            .wrapContentHeight()
            .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Image(painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Something to be", modifier = Modifier.size(70.dp))
            Text(text = "Hello World")
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewCheckLayoutGravity() {
        CheckLayoutGravity()
    }


    @Composable
    fun ClickCounter(clicks: Int, onClick: () -> Unit) {
        Button(onClick = onClick) {
            Text(text = "I have been clicked $clicks times")
        }
    }

    @Composable
    fun GreetingToListOfUsers(names: List<String>) {
        Column {
            for (name in names) {
                Text(text = "Hello $name!")
            }
            ClickCounter(clicks = 0) {
                Log.d("Compose106Activity","clicked")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewGreetingToListOfUsers() {
        GreetingToListOfUsers(names = listOf<String>("David", "Jack", "Android"))
    }

    @Composable
    fun Greeting5(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview5() {
        Test101Theme {
            Greeting5("Android")
        }
    }
}

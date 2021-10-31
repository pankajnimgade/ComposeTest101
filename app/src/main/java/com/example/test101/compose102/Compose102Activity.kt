package com.example.test101.compose102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.test101.compose102.ui.theme.Test101Theme

class Compose102Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(name = "Android")
        }
    }
}

@Composable
fun MessageCard(name: String){
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewMessageCard(){
    MessageCard(name = "Android")
}

@Composable
fun Compose102ActivityScreen() {
    Test101Theme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Greeting2("Android")
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Test101Theme {
        Greeting2("Android")
    }
}
package com.example.test101.compose115

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.compose115.ui.theme.Test101Theme

class Compose115ExtendingButton : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test101Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ContentBody()
                }
            }
        }
    }


}

@Composable
fun ContentBody() {
    Column {
        Greeting115("Android")
        Spacer(modifier = Modifier.padding(4.dp))
        ExtendedButton()
    }
}

@Composable
fun ExtendedButton() {
    Column {
        MyExtendedButton(onClick = { /**/ }, enabled = true) {
            Text(text = "Some Button")
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Divider()
        MyExtendedButton(onClick = { /**/ }, enabled = false) {
            Text(text = "Some Button, can't click")
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Divider()
        Button(onClick = { /**/ }) {
            Text(text = "Some Button")
        }

    }
   
}

@Composable
fun Greeting115(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    Test101Theme {
        ContentBody()
    }
}
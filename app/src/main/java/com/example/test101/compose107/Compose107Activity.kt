package com.example.test101.compose107

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.compose107.ui.theme.Test101Theme

class Compose107Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose107ActivityScreen()
        }
    }
}

@Composable
fun Compose107ActivityScreen() {
    Test101Theme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            HelloScreen()
        }
    }
}

@Composable
fun HelloScreen() {
    var name by rememberSaveable { mutableStateOf("") }
    HelloContent(name = name, onNameChanged = { name = it })
}

@Composable
fun HelloContent(name: String, onNameChanged: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {

        if (name.isNotEmpty()) {
            Text(
                text = "Hello! $name",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(value = name,
            onValueChange = { onNameChanged(it) },
            label = { Text(text = "$name") }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Compose107")
@Composable
fun PreviewCompose107ActivityScreen() {
    Compose107ActivityScreen()
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
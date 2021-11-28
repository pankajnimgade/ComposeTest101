package com.example.test101.compose111

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.compose111.ui.theme.Test101Theme

/**
 * Animating your list
 */
class Compose111OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test101Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyAppCompose111OnBoardingActivity()
                }
            }
        }
    }
}

@Composable
fun MyAppCompose111OnBoardingActivity() {
    var showOnBoarding by rememberSaveable { mutableStateOf(true) }
    if (showOnBoarding) {
        OnBoardingScreen111(onContinueClicked = { showOnBoarding = false })
    } else {
        Greetings111()
    }
}

@Composable
fun OnBoardingScreen111(onContinueClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to basic codelab 111 !")
        Button(onClick = onContinueClicked, modifier = Modifier.padding(24.dp)) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun Greetings111(names: List<String> = List(1000) { "$it .." }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(names) { name ->
            Greeting111(name = name)
        }
    }
}

@Composable
fun Greeting111(name: String) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
    ) {

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview8() {
    Test101Theme {
        MyAppCompose111OnBoardingActivity()
    }
}
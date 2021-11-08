package com.example.test101.compose109

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.compose109.ui.theme.Test101Theme

class Compose109OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test101Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    OnBoardingScreen()
                }
            }
        }
    }
}

@Composable
fun MyAppCompose109OnBoardingActivity() {
  /*  if (shouldShowOnBoarding){ // Where does this comes from?

    }else{
        Greeting7(name = "Android")
    }*/
}

@Composable
fun OnBoardingScreen() {
    //TODO this state should be hoisted
    var shouldShowOnBoarding by remember {
        mutableStateOf(true)
    }

    Surface() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to the Basics Codelab!")

            Button(modifier = Modifier.padding(vertical = 24.dp),
                onClick = { shouldShowOnBoarding = false }
            ) {
                Text(text = "Continue")
            }
        }
    }

}

@Composable
fun Greeting7(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, showSystemUi = true, name = "Compose109OnBoardingActivity")
@Composable
fun DefaultPreviewCompose109OnBoardingActivity() {
    Test101Theme {
        OnBoardingScreen()
    }
}
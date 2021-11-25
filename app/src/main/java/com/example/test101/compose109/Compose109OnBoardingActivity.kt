package com.example.test101.compose109

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.compose108.Greeting6
import com.example.test101.compose109.ui.theme.Test101Theme

/**
 * In Composable functions, state that is read or modified by multiple functions
 * should live in a common ancestor—this process is called state hoisting.
 * To hoist means to lift or elevate.
 * */
class Compose109OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test101Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyAppCompose109OnBoardingActivity()
                }
            }
        }
    }
}

@Composable
fun MyAppCompose109OnBoardingActivity() {
    var shouldShowOnBoarding by remember { mutableStateOf(true) }

    if (shouldShowOnBoarding) {
        OnBoardingScreen(onContinueClicked = { shouldShowOnBoarding = false })
    } else {
        Greeting7s()
    }
}

@Composable
fun OnBoardingScreen(onContinueClicked: () -> Unit) {

    Surface() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to the Basics Codelab!")

            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text(text = "Continue")
            }
        }
    }

}

@Composable
fun Greeting7s(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting6(name = name)
        }
    }
}

@Composable
fun Greeting7(name: String) {
    //State and MutableState are interfaces that hold some value and
    // trigger UI updates (recompositions) whenever that value changes.
    //To preserve state across recompositions, remember the mutable state using remember.
    //remember is used to guard against recomposition, so the state is not reset.
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
//        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = "$name")
            }
            OutlinedButton(
                onClick = { /*TODO*/
                    Log.d("BasicCodeLab", "Clicked")
                    expanded.value = !expanded.value
                }
            ) {
                Text(text = if (expanded.value) "Show less" else "Show More")
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true, name = "Compose109OnBoardingActivity")
@Composable
fun DefaultPreviewCompose109OnBoardingActivity() {
    Test101Theme {
        MyAppCompose109OnBoardingActivity()
    }
}
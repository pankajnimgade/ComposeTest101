package com.example.test101.compose108

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
import com.example.test101.compose108.ui.theme.Test101Theme

class Compose108BasicCodeLab : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test101Theme {
                MyAppCompose108BasicCodeLab()
            }
        }
    }
}

@Composable
private fun MyAppCompose108BasicCodeLab() {

    // when true onBoarding screen is shown
    // when false Greeting6s List is shown
    var shouldShowOnBoarding by remember {
        mutableStateOf(true)
    }

    if (shouldShowOnBoarding) {
        OnBoardingScreen(onContinueClicked = { shouldShowOnBoarding = false })
    } else {
        Greeting6s()
    }
}

@Composable
fun Greeting6s(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting6(name = name)
        }
    }
}

@Composable
fun Greeting6(name: String) {
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

@Preview(showBackground = true, showSystemUi = true, name = "OnBoarding")
@Composable
fun DefaultPreviewOnBoarding() {
    Test101Theme {
        OnBoardingScreen(onContinueClicked = {}) // Do nothing on click
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Text preview")
@Composable
fun DefaultPreview6() {
    Test101Theme {
        Greeting6s()
    }
}

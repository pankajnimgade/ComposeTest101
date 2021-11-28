package com.example.test101.compose110

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.compose110.ui.theme.Test101Theme

/**
 * Creating a performant lazy list
 */
class Compose110OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test101Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyAppCompose110OnBoardingActivity()
                }
            }
        }
    }


}


@Composable
private fun MyAppCompose110OnBoardingActivity() {
    //State and MutableState are interfaces that hold some value and
    // trigger UI updates (recompositions) whenever that value changes.
    //To preserve state across recompositions, remember the mutable state using remember.
    //remember is used to guard against recomposition, so the state is not reset.
    var showOnBoarding by rememberSaveable{ mutableStateOf(true) }

    if (showOnBoarding) {
        onBoardingScreen110(onContinueClicked = { showOnBoarding = false })
    } else {
        Greetings110()
    }
}

@Composable
fun onBoardingScreen110(onContinueClicked: () -> Unit) {
    Surface {
        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome to the basic Codelab 110!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick =onContinueClicked
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
fun Greetings110(names: List<String> = List(1000) { "$it ::" }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting110(name = name)
        }
    }
}

@Composable
fun Greeting110(name: String) {
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    Test101Theme {
        MyAppCompose110OnBoardingActivity()
    }
}
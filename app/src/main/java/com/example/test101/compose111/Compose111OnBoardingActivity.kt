package com.example.test101.compose111

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
    //State and MutableState are interfaces that hold some value and
    // trigger UI updates (recompositions) whenever that value changes.
    //To preserve state across recompositions, remember the mutable state using remember.
    //remember is used to guard against recomposition, so the state is not reset.
    val expanded = rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        targetValue = if (expanded.value) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
//        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview8() {
    Test101Theme {
        MyAppCompose111OnBoardingActivity()
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "List")
@Composable
fun DefaultPreview111List() {
    Test101Theme {
        Greetings111()
    }
}
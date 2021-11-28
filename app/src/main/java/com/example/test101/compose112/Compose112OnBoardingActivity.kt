package com.example.test101.compose112

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.compose112.ui.theme.Test112Theme

class Compose112OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test112Theme() {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyAppCompose112OnBoardingActivity()
                }
            }
        }
    }

}

@Composable
fun MyAppCompose112OnBoardingActivity(s: String = "Android") {
    var mutableOnBoarding by rememberSaveable { mutableStateOf(true) }
    if (mutableOnBoarding) {
        OnBoardingScreen112(onContinueClicked = { mutableOnBoarding = false })
    } else {
        Greetings112()
    }
}

@Composable
fun OnBoardingScreen112(onContinueClicked: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to basic codelab 112 !")
        Button(onClick = onContinueClicked, modifier = Modifier.padding(24.dp)) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun Greetings112(names: List<String> = List(1000) { "$it .." }) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(names) { name ->
            Greeting112(name = name)
        }
    }
}

@Composable
fun Greeting112(name: String) {
    //State and MutableState are interfaces that hold some value and
    // trigger UI updates (recompositions) whenever that value changes.
    //To preserve state across recompositions, remember the mutable state using remember.
    //remember is used to guard against recomposition, so the state is not reset.
    var expanded by rememberSaveable { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
//        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = "Hello, ")
                Text(
                    text = "$name", style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (expanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        "Show less"
                    } else {
                        "Show More"
                    }
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun DefaultPreview112Light() {
    Test112Theme {
        MyAppCompose112OnBoardingActivity()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview112Dark() {
    Test112Theme {
        MyAppCompose112OnBoardingActivity()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "List - Light",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun DefaultPreview112ListLight() {
    Test112Theme {
        Greetings112()
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "List - Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview112ListDark() {
    Test112Theme {
        Greetings112()
    }
}
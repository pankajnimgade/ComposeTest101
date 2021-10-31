package com.example.test101.test.compose101

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.test.compose101.ui.theme.Test101Theme

class Compose101Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Test101Theme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = List(50) { "Hello android $it" }) {
    var counterState by remember {
        mutableStateOf(0)
    }
    Column(Modifier.fillMaxHeight()) {
        NameList(names = names, modifier = Modifier.weight(1f))
        Greeting(name = "Android")
        Counter()
        Divider()
        Counter101(count = counterState, updateCount = { newCount ->
            counterState = newCount
        })

        if (counterState > 5) {
            Divider()
            Text(text = "I love to Count")
        }
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) {
            Greeting(name = it)
            Divider()
        }
        /* for (name in names) {
             Greeting(name = name)
             Divider()
         }*/
    }
}

@Composable
fun Counter() {
    var counter by remember {
        mutableStateOf(0, policy = neverEqualPolicy())
    }
    Button(onClick = { counter++ }) {
        Text(text = "I have been clicked $counter times.")
    }
}

@Composable
fun Counter101(count: Int, updateCount: (Int) -> Unit) {

    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "I have been clicked $count times.")
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    val targetColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colors.primary else Color.Transparent,
        animationSpec = tween(durationMillis = 1000)
    )
    Surface(color = targetColor) {
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .clickable { isSelected = !isSelected }
                .padding(16.dp)
        )
    }
}

@Composable
fun StartPrinting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name :)")
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    MessageCard(name = "Pankaj")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}
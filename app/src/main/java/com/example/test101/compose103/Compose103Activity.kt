package com.example.test101.compose103

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.R
import com.example.test101.compose103.ui.theme.Test101Theme

class Compose103Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCardWithPicture(message = Message("Android", "Jetpack Compose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCardWithPicture(message: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = message.author)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = message.body)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageWithPicture() {
    MessageCardWithPicture(message = Message("Jean", "Hello :)"))
}

@Composable
fun MessageCardWithBox(message: Message) {
    Box {
        Text(text = message.author)
        Text(text = message.body)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCardWithBox() {
    MessageCardWithBox(message = Message("Android", "Jetpack Compose"))
}

@Composable
fun MessageCardWithRow(message: Message) {
    Row {
        Text(text = message.author)
        Text(text = message.body)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCardWithRow() {
    MessageCardWithRow(message = Message("Android", "Jetpack Compose"))
}

@Composable
fun MessageCardWithColumn(message: Message) {
    Column {
        Text(text = message.author)
        Text(text = message.body)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCardWithColumn() {
    MessageCardWithColumn(message = Message("Android", "Jetpack Compose"))
}


@Composable
fun MessageCard(message: Message) {
    Text(text = message.author)
    Text(text = message.body)
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    MessageCard(message = Message("Android", "Jetpack Compose"))
}


@Composable
fun Compose103ActivityScreen() {
    Test101Theme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Greeting3("Android")
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    Test101Theme {
        Greeting3("Android")
    }
}
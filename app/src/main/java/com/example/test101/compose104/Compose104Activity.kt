package com.example.test101.compose104

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import com.example.test101.compose103.Message
import com.example.test101.compose104.ui.theme.ComposeTutorialTheme104Theme

class Compose104Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme104Theme {
                MessageCardWithPicture(
                    message = Message(
                        author = "Android",
                        body = "Jetpack Compose"
                    )
                )
            }
        }

    }
}

private data class Message(val author: String, val body: String)

@Composable
private fun MessageCardWithPicture(message: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(4.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 4.dp) {
                Text(
                    text = message.body,
                    style = MaterialTheme.typography.body2
                )
            }

        }
    }
}


@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun PreviewMessageCardWithPicture() {
    ComposeTutorialTheme104Theme {
        MessageCardWithPicture(message = Message(author = "Android", body = "Jetpack Compose"))
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewNightMessageCardWithPicture() {
    ComposeTutorialTheme104Theme {
        MessageCardWithPicture(message = Message(author = "Android", body = "Jetpack Compose"))
    }
}
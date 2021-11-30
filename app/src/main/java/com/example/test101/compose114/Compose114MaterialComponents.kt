package com.example.test101.compose114

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Duo
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalPostOffice
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test101.compose114.ui.theme.Test114Theme

class Compose114MaterialComponents : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test114Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LayoutCodeLab("Android")
                }
            }
        }
    }
}

@Composable
fun LayoutCodeLab(name: String) {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { /**/ }) {
                    Icon(imageVector = Icons.Filled.LocalPostOffice, contentDescription = null)
                }
            },
            title = {
                Text(text = "LayoutCodeLabs")
            },
            actions = {
                IconButton(onClick = { /**/ }) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                }
            })
    }) { innerPadding ->
        BodyContent(
            Modifier
                .padding(innerPadding)
                .padding(8.dp)
        )
    }
}

@Composable
fun BodyContent(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the layouts codelab")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview114() {
    Test114Theme {
        LayoutCodeLab(name = "Hi")
    }
}
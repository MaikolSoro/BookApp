package com.example.bookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookapp.components.ItemBookList
import com.example.bookapp.components.TextInputField
import com.example.bookapp.components.TopBar
import com.example.bookapp.ui.theme.BookAppTheme


@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val input = remember {
                        mutableStateOf("")
                    }
                    LazyColumn() {
                        item {
                            TopBar(title = "Book Description")
                        }
                        item {
                            TextInputField(
                                label = "Search for books...",
                                value = input.value,
                                onValueChanged = {
                                    input.value = it
                                })
                        }
                        item {
                            ItemBookList()
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BookAppTheme {
        Greeting("Android")
    }
}
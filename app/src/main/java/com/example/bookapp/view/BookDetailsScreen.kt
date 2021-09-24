package com.example.bookapp.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bookapp.R
import com.example.bookapp.components.BookDetailsCard
import com.example.bookapp.components.TopBar
import com.example.bookapp.navigation.MainActions
import com.example.bookapp.utils.DetailViewState
import com.example.bookapp.viewmodel.MainViewModel


@Composable

fun BookDetailsScreen(viewModel: MainViewModel, actions: MainActions) {


    Scaffold(topBar = {
        TopBar(title = stringResource(id = R.string.text_bookDetails), action = actions)
    }) {

        BookDetails(viewModel = viewModel)
    }
}

@Composable
fun BookDetails(viewModel: MainViewModel) {
    when (val result = viewModel.bookDetails.value) {
        DetailViewState.Loading -> Text(text = "Loading")
        is DetailViewState.Error -> Text(text = "Error found: ${result.exception}")
        is DetailViewState.Success -> {
            val book = result.data

            LazyColumn {
                // Book Details Card
                item {
                    BookDetailsCard(book.title, book.authors, book.thumbnailUrl, book.categories)
                }

                // Description
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = stringResource(id = R.string.text_bookDetails),
                        style = typography.subtitle1,
                        color = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = book.longDescription,
                        style = typography.body1,
                        textAlign = TextAlign.Justify,
                        color = MaterialTheme.colors.primaryVariant.copy(0.7F),
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                    )
                }
            }

        }
        DetailViewState.Empty -> Text("No results found!")
    }
}
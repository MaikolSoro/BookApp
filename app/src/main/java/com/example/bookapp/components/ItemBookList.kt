package com.example.bookapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.bookapp.ui.theme.primary
import com.example.bookapp.ui.theme.text
import com.example.bookapp.ui.theme.typography

@Composable
fun ItemBookList() {
    Card(
        modifier = Modifier
            .background(MaterialTheme.colors.onSurface)
            .padding(16.dp)
    ) {

        // Row - Image + Content
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image
            Image(
                painter = rememberImagePainter(
                    data = "https://s3.amazonaws.com/AKIAJC5RLADLUMVRPFDQ.book-thumb-images/ableson.jpg",
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(98.dp, 145.dp)
                    .padding(12.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            // Content
            Column {
                Text(text = "by Michael Soro ", style = typography.caption, color = text.copy(0.7F))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "The more of Less ", style = typography.subtitle1, color = text)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Minimalism ", style = typography.caption, color = primary)
                Spacer(modifier = Modifier.height(12.dp))
                ChipView()
            }
        }

    }
}

@Composable
fun ChipView() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(primary.copy(.10f))
            .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Minimalism", style = typography.caption, color = primary)
    }
}

@Preview
@Composable
fun ItemBookListPreview() {
    ItemBookList()
}
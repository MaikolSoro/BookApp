package com.example.bookapp.navigation

import androidx.annotation.StringRes
import com.example.bookapp.R

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object BookList : Screen("book_list", R.string.text_bookList)
    object Details : Screen("book_details", R.string.text_bookDetails)
}

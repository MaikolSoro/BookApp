package com.example.bookapp.utils

import com.example.bookapp.model.BookItem

sealed class ViewState {
    object Empty : ViewState()
    object Loading : ViewState()
    data class Success(val data: List<BookItem>) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}

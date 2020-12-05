package com.dvdb.creditscore.presentation.util.model

sealed class UIModelDataState<out R> {
    data class Success<out T>(val data: T) : UIModelDataState<T>()
    data class Error(val exception: Exception) : UIModelDataState<Nothing>()
    object Loading : UIModelDataState<Nothing>()
}
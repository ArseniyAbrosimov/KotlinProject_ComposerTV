package com.example.composertv.ui.screens

import com.example.composertv.model.FilmCollectionResponse

sealed interface ComposerUiState {
    data class Success(val recommended: FilmCollectionResponse,
        ) : ComposerUiState
    object Error : ComposerUiState
    object Loading : ComposerUiState
}
package com.example.composertv.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModelProvider

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

import com.example.composertv.ComposerApplication
import com.example.composertv.data.ComposerRepository
import com.example.composertv.model.FilmCollectionResponse
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface ComposerUiState {
    data class Success(val newest: FilmCollectionResponse,
        ) : ComposerUiState
    object Error : ComposerUiState
    object Loading : ComposerUiState
}

class ComposerViewModel(private val composerRepository: ComposerRepository) : ViewModel() {

    var composerUiState: ComposerUiState by mutableStateOf(ComposerUiState.Loading)
        private set

    init {
        updateMain()
    }

    fun updateMain() {
        viewModelScope.launch {
            composerUiState = ComposerUiState.Loading
            composerUiState = try {
                ComposerUiState.Success(composerRepository.getNewest())
            } catch (e: IOException) {
                ComposerUiState.Error
            } catch (e: HttpException) {
                ComposerUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as ComposerApplication)
                val composerRepository = application.container.composerRepository
                ComposerViewModel(composerRepository = composerRepository)
            }
        }
    }
}

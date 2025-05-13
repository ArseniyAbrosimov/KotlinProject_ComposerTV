package com.example.compositortv.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.compositortv.CompositorApplication
import com.example.compositortv.data.CompositorRepository
import com.example.compositortv.model.FilmCollectionResponse
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface CompositorUiState {
    data class Success(
        val newest: FilmCollectionResponse,
    ) : CompositorUiState

    object Error : CompositorUiState

    object Loading : CompositorUiState
}

class CompositorViewModel(
    private val compositorRepository: CompositorRepository,
) : ViewModel() {
    var compositorUiState: CompositorUiState by mutableStateOf(CompositorUiState.Loading)
        private set

    init {
        updateMain()
    }

    fun updateMain() {
        viewModelScope.launch {
            compositorUiState = CompositorUiState.Loading
            compositorUiState =
                try {
                    CompositorUiState.Success(compositorRepository.getNewest())
                } catch (e: IOException) {
                    CompositorUiState.Error
                } catch (e: HttpException) {
                    CompositorUiState.Error
                }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    val application = (
                        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                            as CompositorApplication
                    )
                    val compositorRepository = application.container.compositorRepository
                    CompositorViewModel(compositorRepository = compositorRepository)
                }
            }
    }
}

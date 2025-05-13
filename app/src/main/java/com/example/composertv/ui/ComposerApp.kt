package com.example.composertv.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.composertv.ui.screens.ComposerViewModel
import com.example.composertv.ui.screens.HomeScreen

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ComposerApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val composerViewModel: ComposerViewModel =
            viewModel(factory = ComposerViewModel.Factory)
        HomeScreen(
            composerUiState = composerViewModel.composerUiState,
            retryAction = composerViewModel::updateMain,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

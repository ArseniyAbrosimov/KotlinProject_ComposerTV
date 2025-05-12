package com.example.composertv.ui


import com.example.composertv.ui.screens.

import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.tv.material3.MaterialTheme


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ComposerApp() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val amphibiansViewModel: AmphibiansViewModel =
            viewModel(factory = AmphibiansViewModel.Factory)
        HomeScreen(
            amphibiansUiState = amphibiansViewModel.amphibiansUiState,
            retryAction = amphibiansViewModel::getAmphibians,
            modifier = Modifier.fillMaxSize(),
            contentPadding = it
        )
    }
}
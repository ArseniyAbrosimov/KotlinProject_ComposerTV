package com.example.compositortv.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.compositortv.ui.screens.CompositorViewModel
import com.example.compositortv.ui.screens.HomeScreen

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun CompositorApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        val compositorViewModel: CompositorViewModel =
            viewModel(factory = CompositorViewModel.Factory)
        HomeScreen(
            compositorUiState = compositorViewModel.compositorUiState,
            retryAction = compositorViewModel::updateMain,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

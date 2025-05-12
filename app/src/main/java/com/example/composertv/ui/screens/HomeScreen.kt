package com.example.composertv.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import com.example.composertv.ui.theme.ComposerTVTheme



@Composable
fun HomeScreen(
    composerUiState: composerUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier.size(200.dp))
        is AmphibiansUiState.Success ->
            AmphibiansListScreen(
                amphibians = amphibiansUiState.amphibians,
                modifier = modifier
                    .padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    ),
                contentPadding = contentPadding
            )
        else -> ErrorScreen(retryAction, modifier)
    }
}


@OptIn(ExperimentalTvMaterial3Api::class)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreviewN() {
    ComposerTVTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RectangleShape
        ) {
            Greeting("Android")
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun GreetingPreviewL() {
    ComposerTVTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RectangleShape
        ) {
            Greeting("Android")
        }
    }
}
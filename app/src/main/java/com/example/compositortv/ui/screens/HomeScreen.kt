package com.example.compositortv.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compositortv.R
import com.example.compositortv.model.FilmCollectionResponse

@Suppress("ktlint:standard:function-naming")
@Composable
fun HomeScreen(
    compositorUiState: CompositorUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (compositorUiState) {
        is CompositorUiState.Loading -> LoadingScreen(modifier.size(200.dp))
        is CompositorUiState.Success ->
            ListScreen(
                newest = compositorUiState.newest,
                modifier = modifier,
                contentPadding = contentPadding,
            )
        else -> ErrorScreen(retryAction, modifier)
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
private fun ListScreen(
    newest: FilmCollectionResponse,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        items(
            items = newest.items,
            key = { film -> film.kinopoiskId },
        ) { film ->
            FilmCard(film = film, modifier = Modifier.fillMaxSize())
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun FilmCard(
    film: FilmCollectionResponse.FilmCollectionResponseItems,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        onClick = {},
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = film.nameRu,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_medium)),
                //                style = MaterialTheme.typography.titleLarge,
//                fontWeight = FontWeight.Bold,
//                textAlign = TextAlign.Start
            )
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model =
                    ImageRequest
                        .Builder(context = LocalContext.current)
                        .data(film.posterUrlPreview)
                        .crossfade(true)
                        .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
            )
        }
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
}

// @OptIn(ExperimentalTvMaterial3Api::class)
// @Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
// @Composable
// fun GreetingPreviewN() {
//    CompositorTVTheme {
//
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            shape = RectangleShape
//        ) {
//            Greeting("Android")
//        }
//    }
// }
//
// @OptIn(ExperimentalTvMaterial3Api::class)
// @Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
// @Composable
// fun GreetingPreviewL() {
//    CompositorTVTheme {
//
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            shape = RectangleShape
//        ) {
//            Greeting("Android")
//        }
//    }
// }

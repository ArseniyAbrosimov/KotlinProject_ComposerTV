package com.example.composertv.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme
import androidx.tv.material3.lightColorScheme

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun ComposerTVTheme(
    isInDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        if (isInDarkTheme) {
        darkColorScheme(
//            primary = Pink80,
//            secondary = Pink80,
//            tertiary = Pink80,
            surface = RoseSurface,
            onSurface = RoseText
        )
    } else {
        lightColorScheme(
//            primary = Purple40,
//            secondary = PurpleGrey40,
//            tertiary = Pink40,
            surface = Pink80,
            onSurface = PurpleGrey40
//            background = Pink80
        )
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
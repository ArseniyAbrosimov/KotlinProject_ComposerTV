package com.example.composertv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.composertv.ui.ComposerApp
import com.example.composertv.ui.theme.ComposerTVTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposerTVTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape,
                ) {
                    ComposerApp()
                }
            }
        }
    }
}

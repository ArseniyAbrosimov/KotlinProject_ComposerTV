package com.example.compositortv.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Typography
import com.example.compositortv.R

// Set of Material typography styles to start with
@OptIn(ExperimentalTvMaterial3Api::class)
val Typography =
    Typography(
        bodyLarge =
            TextStyle(
                fontFamily =
                    FontFamily(
                        Font(
                            R.font.jetbrainsmed,
                            FontWeight.W900,
                        ),
                    ),
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.5.sp,
            ),
        titleLarge =
            TextStyle(
                fontFamily =
                    FontFamily(
                        Font(
                            R.font.jetbrainsmed,
                            FontWeight.W900,
                        ),
                    ),
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                letterSpacing = 0.sp,
            ),
        labelSmall =
            TextStyle(
                fontFamily =
                    FontFamily(
                        Font(
                            R.font.jetbrainsmed,
                            FontWeight.W900,
                        ),
                    ),
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.5.sp,
            ),
    )

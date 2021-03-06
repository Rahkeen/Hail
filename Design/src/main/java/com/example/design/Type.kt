package com.example.design

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val recMonoFontFamily = FontFamily(
    Font(R.font.recmono_linear_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = recMonoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 56.sp
    ),
    h2 = TextStyle(
        fontFamily = recMonoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    body1 = TextStyle(
        fontFamily = recMonoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    caption = TextStyle(
        fontFamily = recMonoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),

    */
)

package com.sushkpavel.whmngr.presentation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

@Composable
fun ClickableText(text: String, onClick: () -> Unit) {
    val annotatedString = AnnotatedString.Builder().apply {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.secondary,
                fontStyle = FontStyle.Normal,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(text)
        }
        addStringAnnotation(
            tag = "URL",
            annotation = "clickable",
            start = 0,
            end = text.length
        )
    }.toAnnotatedString()

    BasicText(
        text = annotatedString,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.clickable {
            onClick()
        }
    )
}
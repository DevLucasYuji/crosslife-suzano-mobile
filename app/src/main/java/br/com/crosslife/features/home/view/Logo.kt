package br.com.crosslife.features.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import br.com.crosslife.ui.theme.Green
import br.com.crosslife.ui.theme.Space
import br.com.crosslife.ui.theme.White

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Space.BORDER),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(Green,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)) {
                    append("CROSS")
                }
                withStyle(style = SpanStyle(White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)) {
                    append("LIFE")
                }
            },
            modifier = modifier
        )
    }
}
package com.codelab.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ModifierPractice {

    @Preview
    @Composable
    private fun PhotographedCard() {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.surface)
                .clickable {}
                .padding(20.dp),
        ) {
            Surface(
                modifier = Modifier.size(45.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(0.4f)
            ) {

            }
            Column(
                modifier = Modifier
                    .padding(start = 5.dp)
            ) {
                Text("Alfred Sysley", fontWeight = FontWeight.Bold)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        "3 minutes ago", style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}

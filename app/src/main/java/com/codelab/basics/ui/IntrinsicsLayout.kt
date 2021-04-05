package com.codelab.basics.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class IntrinsicsLayout {

    @Composable
    fun TwoTexts() {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            Text(
                text = "Text",
                modifier = Modifier
                    .wrapContentWidth(Alignment.Start)
                    .weight(1f)
            )
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
            )
            Text(
                text = "hello",
                modifier = Modifier
                    .wrapContentWidth(Alignment.End)
                    .weight(1f)
            )
        }
    }

}

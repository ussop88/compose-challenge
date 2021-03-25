package com.codelab.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SlotApi {

    @Composable
    @Preview
    private fun CustomAppBar() {
        TopAppBar {
            CustomButton()
        }
    }

    @Preview
    @Composable
    private fun CustomButton() {
        Button({

        }) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(start = 5.dp))
            Text(text = "Button")
        }
    }
}

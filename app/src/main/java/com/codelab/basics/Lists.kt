package com.codelab.basics

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

class Lists {

    @Composable
    @Preview
    fun ImageList() {
        // We save the scrolling position with this state
        val scrollState = rememberLazyListState()

        LazyColumn(state = scrollState) {
            items(100) { index ->
                ImageListItem(index = index)
            }
        }

        val coroutineScope = rememberCoroutineScope()

        Row {
            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text(text = "Scroll to Top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    scrollState.animateScrollToItem(99)
                }
            }) {
                Text(text = "Scroll to Bottom")
            }
        }

    }

    @Composable
    fun ImageListItem(index: Int) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CoilImage(
                data = "https://previews.123rf.com/images/maximleshkovich/maximleshkovich1708/maximleshkovich170800421/84574019-disposition-ronde-cr%C3%A9ative-avec-un-espace-de-copie-compos%C3%A9-de-confettis-color%C3%A9s-sur-fond-blanc-fond-de-con.jpg",
                contentDescription = "Android Logo",
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.width(10.dp))
            Text("Item #$index", style = MaterialTheme.typography.subtitle1)
        }
    }
}

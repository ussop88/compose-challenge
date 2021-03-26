package com.codelab.basics

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class CustomLayout {
    @Preview
    @Composable
    fun TextWithPaddingToBaselinePreview() {
        MyColumn {
            Text("Hi there!", modifier = Modifier.baseLinePadding(20.dp))
            Text("Hi there Again!", modifier = Modifier.baseLinePadding(20.dp))
            Text("Hi there Again Again!", modifier = Modifier.baseLinePadding(20.dp))
            Text("Hi there Again Again Again!", modifier = Modifier.baseLinePadding(20.dp))
        }
    }


    @Composable
    fun MyColumn(content: @Composable () -> Unit) {
        Layout(
            content = content
        ) { measurables, constraints ->
            // Don't constrain child views further, measure them with given constraints
            // List of measured children
            val placeables = measurables.map { measurable ->
                // Measure each child
                measurable.measure(constraints)
            }
            var yPosition = 0
            layout(constraints.maxWidth, constraints.maxHeight) {
                placeables.forEach { placeable ->
                    placeable.placeRelative(0, yPosition)
                    yPosition += placeable.height
                }

            }
        }

    }

    @Composable
    fun MyOwnColumn(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Layout(
            modifier = modifier,
            content = content
        ) { measurables, constraints ->
            // Don't constrain child views further, measure them with given constraints
            // List of measured children
            val placeables = measurables.map { measurable ->
                // Measure each child
                measurable.measure(constraints)
            }

            // Track the y co-ord we have placed children up to
            var yPosition = 0

            // Set the size of the layout as big as it can
            layout(constraints.maxWidth, constraints.maxHeight) {
                // Place children in the parent layout
                placeables.forEach { placeable ->
                    // Position item on the screen
                    placeable.placeRelative(x = 0, y = yPosition)

                    // Record the y co-ord placed up to
                    yPosition += placeable.height
                }
            }
        }
    }
}

private fun Modifier.baseLinePadding(padding: Dp): Modifier = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
    val placeableY = padding.roundToPx() - placeable[FirstBaseline]
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        placeable.placeRelative(0, placeableY)
    }

}
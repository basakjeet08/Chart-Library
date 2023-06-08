package com.dev.anirban.chartlibrary.screens.utils

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.ui.theme.ChartLibraryTheme
import com.dev.anirban.chartlibrary.ui.theme.InterFontFamily

// Preview Function
@Preview("Light")
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        TabOptionListUI(
            tabList = listOf(
                "DAY",
                "WEEK",
                "MONTH",
                "ALL"
            ),
            selectedItem = 0
        ) { }
    }
}

/**
 * This function draws Tab Options in the screen when called.
 *
 * @param modifier This is the modifications passed down by the parent Function
 * @param tabList This contains the List of the String which should be displayed at the Screen
 * @param selectedItem This is the current Selected Item
 * @param innerPadding This is the Left and Right Padding against the whole Row
 * @param brush This is the Linear Gradient Brush
 * @param strokeWidth This is the width of the stroke which will be displayed under selected Item
 * @param onNewTabClicked This changes the Tab
 */
@Composable
fun TabOptionListUI(
    modifier: Modifier = Modifier,
    tabList: List<String>,
    selectedItem: Int,
    innerPadding: Dp = 8.dp,
    brush: Brush = Brush.horizontalGradient(listOf(Color.Blue, Color.Blue)),
    strokeWidth: Float = 6f,
    onNewTabClicked: (Int) -> Unit
) {

    // Parent Layout with a padding given by the parent function
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.Transparent
        ),
        shape = RectangleShape

    ) {
        Box(
            modifier = modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        start = innerPadding,
                        end = innerPadding,
                        top = 16.dp
                    )
                    .fillMaxWidth()
            ) {

                // Taking Each Item of the Tab List Items and making the Tab layout
                tabList.forEachIndexed { index: Int, option: String ->

                    // Text of the Option to be showed
                    Text(
                        text = option,
                        modifier = Modifier
                            .weight(1f)
                            .size(34.dp)
                            .clickable {

                                // Changing the selected Item to the Item Index Clicked to move the State
                                onNewTabClicked(index)
                            }
                            // This draws the Line Under the Option
                            .drawBehind {

                                // Checking if the Option is selected
                                if (index == selectedItem)
                                    drawLine(
                                        brush = brush,
                                        start = Offset(0f, size.height),
                                        end = Offset(size.width, size.height),
                                        strokeWidth = strokeWidth
                                    )
                            },

                        // Text and Font Properties
                        textAlign = TextAlign.Center,
                        color = if (selectedItem == index) Color.Blue else Color.Gray,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.W800,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
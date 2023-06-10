package com.dev.anirban.screens.water

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dev.anirban.screens.LibraryUIExample
import com.dev.anirban.screens.components.TabOptionListUI
import com.dev.anirban.ui.theme.ChartLibraryTheme

// Preview Composable Function
@Preview("Light")
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        WaterStatsScreen()
    }
}

@Composable
fun WaterStatsScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {

        // This is the Item which is selected in the Tab Option Layout
        val selectedItem = remember { mutableStateOf(0) }

        // This Function makes the Tab Layout UI
        TabOptionListUI(
            tabList = listOf(
                "DAY",
                "WEEK",
                "MONTH",
                "ALL"
            ),
            selectedItem = selectedItem.value
        ) {

            // Changing the Current Selected Item according to the User Interactions
            selectedItem.value = it
        }

        when (selectedItem.value) {
            0 -> WaterDayStats()
            1 -> WaterWeekStats()
            2 -> WaterDayStats()
            3 -> LibraryUIExample()
        }
    }
}
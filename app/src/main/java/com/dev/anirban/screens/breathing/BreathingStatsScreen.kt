package com.dev.anirban.screens.breathing

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dev.anirban.screens.components.TabOptionListUI
import com.dev.anirban.ui.theme.ChartLibraryTheme

// Preview Composable Function
@Preview(
    "Light",
    heightDp = 2000
)
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    heightDp = 2000
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        BreathingStatsScreen()
    }
}

@Composable
fun BreathingStatsScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface.copy(alpha = .9f))
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
            0 -> BreathingDayStats()
            1 -> BreathingWeeklyStats()
            2 -> BreathingMonthlyStats()
            3 -> BreathingYearlyStats()
        }
    }
}
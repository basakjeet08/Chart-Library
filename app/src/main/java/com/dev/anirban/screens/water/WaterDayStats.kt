package com.dev.anirban.screens.water

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.R
import com.dev.anirban.chartlibrary.circular.charts.CircularDonutChartRow
import com.dev.anirban.chartlibrary.circular.data.CircularDonutListData
import com.dev.anirban.chartlibrary.circular.data.CircularTargetDataBuilder
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.linear.LinearChart
import com.dev.anirban.chartlibrary.linear.colorconvention.LinearGridColorConvention
import com.dev.anirban.chartlibrary.linear.data.LinearData
import com.dev.anirban.chartlibrary.linear.util.LinearPoint
import com.dev.anirban.screens.components.CustomCard
import com.dev.anirban.screens.components.WaterOverHydrationNote
import com.dev.anirban.screens.components.WaterSunnyCardBody
import com.dev.anirban.screens.components.WaterWeatherCardBody
import com.dev.anirban.ui.theme.ChartLibraryTheme
import com.dev.anirban.ui.theme.InterFontFamily

// Preview Composable Function
@Preview(
    "Light",
    heightDp = 1585,
    showBackground = true
)
@Preview(
    name = "Dark",
    heightDp = 1585,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        WaterDayStats()
    }
}

@Composable
fun WaterDayStats() {

    // This Column contains the body of the screen
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        // This function draws an elevated Card View
        CustomCard(
            title = "Daily Progress"
        ) {

            Column {
                CircularDonutChartRow.DonutChartTarget(
                    circularData = CircularTargetDataBuilder(
                        target = 4000f,
                        achieved = 5000f,
                        siUnit = "L",
                        cgsUnit = "mL",
                        conversionRate = { it / 1000f }
                    )
                )

                // Draw Over Hydration Text in the UI
                WaterOverHydrationNote(labelIcon = R.drawable.image_note)
            }
        }

        // Sunny Water Intake Increase Prompt Card
        CustomCard {
            WaterSunnyCardBody(
                startLabelIcon = R.drawable.image_sunny,
                endLabelIcon = R.drawable.image_upward_arrow
            )
        }

        // Weather Water Intake Increase Prompt Card
        CustomCard {
            WaterWeatherCardBody(
                startLabelIcon = R.drawable.image_night_shift,
                endLabelIcon = R.drawable.image_upward_arrow
            )
        }

        CustomCard(
            title = "Daily Progress"
        ) {
            LinearChart.BarChart(
                linearData = LinearData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(5f, 10f, 6f, 4.2f, 8f, 10f, 6f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
                    )
                )
            )
        }

        CustomCard(
            title = "Ratio"
        ) {
            CircularDonutChartRow.DonutChartRow(
                circularData = CircularDonutListData(
                    itemsList = listOf(
                        Pair("Water", 1500f),
                        Pair("Juice", 300f),
                        Pair("Soft Drink", 500f)
                    ),
                    siUnit = "L",
                    cgsUnit = "mL",
                    conversionRate = { it / 1000f }
                ),
                circularDecoration = CircularDecoration(
                    textColor = MaterialTheme.colorScheme.onSurface,
                    colorList = listOf(
                        Color.Blue,
                        Color.Green,
                        Color.Red
                    )
                )
            )
        }

        CustomCard(
            title = "Beverages"
        ) {
            Column {
                LinearChart.LineChart(
                    linearData = LinearData(
                        yAxisReadings = listOf(
                            LinearPoint.pointDataBuilder(3f, 2.5f, 2.8f, 3.5f, 5.7f, 2.6f, 3.4f),
                            LinearPoint.pointDataBuilder(3.6f, 3f, 2.4f, 6f, 4.5f, 2.9f, 3.8f)
                        ),
                        xAxisReadings = LinearPoint.pointDataBuilder(
                            "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
                        )
                    ),
                    colorConvention = LinearGridColorConvention(
                        textList = listOf("Water", "Juice")
                    )
                )

                Text(
                    text = "Over hydration",

                    // Modifications
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 12.dp),

                    // Text and Font Properties
                    textAlign = TextAlign.Start,
                    color = Color.Red,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
            }
        }
    }
}
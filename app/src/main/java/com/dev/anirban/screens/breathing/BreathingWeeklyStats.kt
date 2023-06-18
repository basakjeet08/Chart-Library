package com.dev.anirban.screens.breathing

import android.content.res.Configuration
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.dev.anirban.chartlibrary.R
import com.dev.anirban.chartlibrary.circular.center.CircularRingTextCenter
import com.dev.anirban.chartlibrary.circular.charts.CircularRingChart.Companion.RingChartMultiple
import com.dev.anirban.chartlibrary.circular.data.CircularTargetDataBuilder
import com.dev.anirban.chartlibrary.linear.LinearChart
import com.dev.anirban.chartlibrary.linear.LinearChart.Companion.BarChart
import com.dev.anirban.chartlibrary.linear.LinearChart.Companion.LineChart
import com.dev.anirban.chartlibrary.linear.colorconvention.LinearGridColorConvention
import com.dev.anirban.chartlibrary.linear.data.LinearEmojiData
import com.dev.anirban.chartlibrary.linear.data.LinearStringData
import com.dev.anirban.chartlibrary.linear.util.LinearPoint
import com.dev.anirban.screens.components.CustomCard
import com.dev.anirban.screens.components.DetailsCard
import com.dev.anirban.screens.components.WaterWeeklyProgressBody
import com.dev.anirban.ui.theme.ChartLibraryTheme

// Preview Composable Function
@Preview(
    "Light",
    heightDp = 2000,
    showBackground = true
)
@Preview(
    name = "Dark",
    heightDp = 2000,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        BreathingWeeklyStats()
    }
}


@Composable
fun BreathingWeeklyStats() {

    // This Column contains the body of the screen
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        // Weekly Progress Chart Row is created here
        CustomCard(title = "Weekly Progress") {
            WaterWeeklyProgressBody()
        }

        // Weekly Progress bar Chart
        CustomCard(title = "Weekly Progress") {
            BarChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(13f, 40f, 20f, 10f, 30f, 40f, 20f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
                    )
                )
            )
        }

        // Vitamin D Details card showing 3 Vitamin Details
        CustomCard(
            title = "Vitamin D Details",
            heightBetweenTitleAndBody = 16.dp
        ) {
            DetailsCard(
                imageList = listOf(
                    R.drawable.image_sun,
                    R.drawable.image_duration,
                    R.drawable.image_sun_exposure
                ),
                headerTextList = listOf(
                    "Avg Vitamin D",
                    "Avg Duration",
                    "Avg Exposure"
                ),
                valueList = listOf(
                    "300 IU",
                    "15 Min",
                    "30 %"
                )
            )
        }

        // Heart Health Double Ring Chart
        CustomCard(title = "Heart Health") {
            RingChartMultiple(
                circularData = listOf(
                    CircularTargetDataBuilder(
                        target = 120f,
                        achieved = 75f,
                        siUnit = "bpm",
                        cgsUnit = "bpm",
                        conversionRate = { it }
                    ),
                    CircularTargetDataBuilder(
                        target = 150f,
                        achieved = 120f,
                        siUnit = "mmhg",
                        cgsUnit = "mmhg",
                        conversionRate = { it }
                    )
                ),
                circularCenter = listOf(
                    CircularRingTextCenter(
                        title = "Heart Rate",
                        centerValue = "75 bpm",
                        status = "Normal"
                    ),
                    CircularRingTextCenter(
                        title = "BP",
                        centerValue = "120/80 mmhg",
                        status = "Normal"
                    )
                )
            )
        }

        // Breathing Details Card Showing 3 details
        CustomCard(
            title = "Breathing Details",
            heightBetweenTitleAndBody = 16.dp
        ) {
            DetailsCard(
                imageList = listOf(
                    R.drawable.image_inhaled_quantity,
                    R.drawable.image_total_breathes,
                    R.drawable.image_calories
                ),
                headerTextList = listOf(
                    "Inhaled Quantity",
                    "Avg Total Breathes",
                    "Avg Calories"
                ),
                valueList = listOf(
                    "11,000 litres",
                    "6620",
                    "258 kcal"
                )
            )
        }

        // Air purity Graph
        CustomCard(
            title = "Air purity"
        ) {
            LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(
                            4f, 3f, 0f, 2f, 3f, 4f, 2f
                        )
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
                    ),
                    yMarkerList = LinearPoint.pointDataBuilder(
                        "Hazardous",
                        "Very Unhealthy",
                        "Unhealthy",
                        "Moderate",
                        "Good"
                    ).toMutableList()
                )
            )
        }

        // Mood Graph
        CustomCard(
            title = "Mood Graph"
        ) {
            LinearChart.EmojiLineChart(
                linearData = LinearEmojiData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(
                            6f, 4f, 2f, 0f, 3f, 5f, 6f
                        )
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
                    ),
                    yMarkerList = LinearPoint.pointDataBuilder(
                        ContextCompat.getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_furious
                        ) as BitmapDrawable,
                        ContextCompat.getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_angry
                        ) as BitmapDrawable,
                        ContextCompat.getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_sad
                        ) as BitmapDrawable,
                        ContextCompat.getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_depressed
                        ) as BitmapDrawable,
                        ContextCompat.getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_confused
                        ) as BitmapDrawable,
                        ContextCompat.getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_calm
                        ) as BitmapDrawable,
                        ContextCompat.getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_happy
                        ) as BitmapDrawable
                    ).toMutableList()
                )
            )
        }

        // Heart Rate Single Line Chart
        CustomCard(title = "Heart Rate") {
            LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(78f, 68f, 59f, 78f, 88f, 83f, 78f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
                    )
                )
            )
        }

        // Blood Pressure Double Line Chart
        CustomCard(title = "Blood Pressure") {
            LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(40f, 80f, 85f, 76f, 86f, 94f, 108f),
                        LinearPoint.pointDataBuilder(80f, 84f, 70f, 42f, 100f, 100f, 112f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
                    )
                ),
                colorConvention = LinearGridColorConvention(
                    textList = listOf("Systolic", "Diastolic")
                )
            )
        }
    }
}
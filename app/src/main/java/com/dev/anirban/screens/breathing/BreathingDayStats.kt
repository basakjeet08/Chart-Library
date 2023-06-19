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
import com.dev.anirban.chartlibrary.circular.charts.CircularDonutChartRow.Companion.TargetDonutChart
import com.dev.anirban.chartlibrary.circular.charts.CircularRingChart.Companion.MultipleRingChart
import com.dev.anirban.chartlibrary.circular.charts.CircularRingChart.Companion.SingleRingChart
import com.dev.anirban.chartlibrary.circular.data.CircularTargetDataBuilder
import com.dev.anirban.chartlibrary.linear.LinearChart
import com.dev.anirban.chartlibrary.linear.LinearChart.Companion.LineChart
import com.dev.anirban.chartlibrary.linear.colorconvention.LinearGridColorConvention
import com.dev.anirban.chartlibrary.linear.data.LinearEmojiData
import com.dev.anirban.chartlibrary.linear.data.LinearStringData
import com.dev.anirban.chartlibrary.linear.util.LinearPoint
import com.dev.anirban.screens.components.CustomCard
import com.dev.anirban.screens.components.DetailsCard
import com.dev.anirban.screens.components.MoodCard
import com.dev.anirban.screens.components.SunnyCard
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
        BreathingDayStats()
    }
}


@Composable
fun BreathingDayStats() {

    // This Column contains the body of the screen
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        // Daily Progress Donut Chart
        CustomCard(title = "Daily Progress") {
            TargetDonutChart(
                circularData = CircularTargetDataBuilder(
                    target = 40f,
                    achieved = 28f,
                    siUnit = "Hrs",
                    cgsUnit = "min",
                    conversionRate = { it / 60 }
                )
            )
        }

        // Sunny Card
        CustomCard {
            SunnyCard(
                temperature = "22°C",
                location = "Bengaluru",
                image = R.drawable.image_sun
            )
        }

        // Air Purity Ring Chart
        CustomCard(title = "Air Purity") {
            SingleRingChart(
                circularData = CircularTargetDataBuilder(
                    target = 500f,
                    achieved = 193f,
                    siUnit = "",
                    cgsUnit = "",
                    conversionRate = { it }
                ),
                circularCenter = CircularRingTextCenter(
                    title = "AQI",
                    centerValue = "193",
                    status = "Moderate"
                )
            )
        }

        // Heart Health Double Ring Chart
        CustomCard(title = "Heart Health") {
            MultipleRingChart(
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

        // Breathing Details Card containing 3 Details
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
                    "Total Breathes",
                    "Calories"
                ),
                valueList = listOf(
                    "11,000 litres",
                    "6620",
                    "258 kcal"
                )
            )
        }

        // Shows today's Mood
        CustomCard {
            MoodCard(
                moodImage = R.drawable.image_happy_face,
                moodText = "I feel Happy Today"
            )
        }

        // Drawing the Emoji Marker Line Chart
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
                        "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
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

        // Heart Rate Line Chart
        CustomCard(title = "Heart Rate") {
            LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(78f, 68f, 59f, 78f, 88f, 83f, 78f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
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
                        "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
                    )
                ),
                colorConvention = LinearGridColorConvention(
                    textList = listOf("Systolic", "Diastolic")
                )
            )
        }
    }
}
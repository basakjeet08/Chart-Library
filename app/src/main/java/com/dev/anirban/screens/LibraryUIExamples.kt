package com.dev.anirban.screens

import android.content.res.Configuration
import android.graphics.drawable.BitmapDrawable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getDrawable
import com.dev.anirban.chartlibrary.R
import com.dev.anirban.chartlibrary.circular.CircularChart
import com.dev.anirban.chartlibrary.circular.center.CircularCustomCenter
import com.dev.anirban.chartlibrary.circular.center.CircularImageCenter
import com.dev.anirban.chartlibrary.circular.center.CircularRingTextCenter
import com.dev.anirban.chartlibrary.circular.center.CircularTargetTextCenter
import com.dev.anirban.chartlibrary.circular.charts.CircularDonutChartColumn
import com.dev.anirban.chartlibrary.circular.charts.CircularDonutChartRow
import com.dev.anirban.chartlibrary.circular.charts.CircularRingChart
import com.dev.anirban.chartlibrary.circular.data.CircularDonutListData
import com.dev.anirban.chartlibrary.circular.data.CircularTargetDataBuilder
import com.dev.anirban.chartlibrary.circular.foreground.CircularDonutForeground
import com.dev.anirban.chartlibrary.circular.foreground.CircularDonutTargetForeground
import com.dev.anirban.chartlibrary.linear.LinearChart
import com.dev.anirban.chartlibrary.linear.data.LinearEmojiData
import com.dev.anirban.chartlibrary.linear.data.LinearStringData
import com.dev.anirban.chartlibrary.linear.plots.LinearBarPlot
import com.dev.anirban.chartlibrary.linear.plots.LinearGradientLinePlot
import com.dev.anirban.chartlibrary.linear.plots.LinearLinePlot
import com.dev.anirban.chartlibrary.linear.util.LinearPoint
import com.dev.anirban.screens.components.CustomCard
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
        LibraryUIExample()
    }
}

@Composable
fun LibraryUIExample() {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        // Design Pattern Single Line Chart
        CustomCard(
            title = "Single Line Chart"
        ) {

            LinearChart.LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                ),
                plot = LinearLinePlot(
                    lineStroke = 5f,
                    circleRadius = 8f
                )
            )
        }

        // Design Pattern Double Line Chart
        CustomCard(
            title = "Double Line Chart"
        ) {

            LinearChart.LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f),
                        LinearPoint.pointDataBuilder(3f, 6f, 8f, 2f, 3.5f, 3f, 4f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                ),
                plot = LinearLinePlot(
                    lineStroke = 8f,
                    circleRadius = 8f
                )
            )
        }

        // Design Pattern Triple Line Chart
        CustomCard(
            title = "Multiple Line Chart"
        ) {

            LinearChart.LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f),
                        LinearPoint.pointDataBuilder(3f, 6f, 8f, 2f, 3.5f, 3f, 4f),
                        LinearPoint.pointDataBuilder(1f, 8f, 4f, 3f, 5.9f, 2.9f, 4.7f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                )
            )
        }

        // Design Pattern String Marker Line Chart
        CustomCard(
            title = "String Marker Chart"
        ) {
            LinearChart.LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(
                            4f, 3f, 0f, 2f, 3f, 4f, 2f
                        )
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
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

        // Design Pattern String Marker Line Chart
        CustomCard(
            title = "Emoji Marker Chart"
        ) {
            LinearChart.EmojiLineChart(
                linearData = LinearEmojiData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(
                            6f, 4f, 2f, 0f, 3f, 5f, 6f
                        )
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    ),
                    yMarkerList = LinearPoint.pointDataBuilder(
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_furious
                        ) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_angry) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_sad) as BitmapDrawable,
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_depressed
                        ) as BitmapDrawable,
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_confused
                        ) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_calm) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_happy) as BitmapDrawable
                    ).toMutableList()
                )
            )
        }

        // Design Pattern String Marker Gradient Line Chart using plot object
        CustomCard(
            title = "Gradient List using Plot Object"
        ) {

            LinearChart.GradientChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(4f, 0f, 1.7f, 1.9f, 2f, 4f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
                    ),
                    yMarkerList = LinearPoint.pointDataBuilder(
                        "Awake",
                        "Deep Sleep",
                        "Sleep",
                        "Asleep After",
                        "Bed Time"
                    ).toMutableList()
                ),
                plot = LinearGradientLinePlot(
                    colorList = listOf(
                        Color(0xFFE5E787).copy(alpha = .6f),
                        Color(0xFF85DE50).copy(alpha = .6f),
                        Color(0xFF57D6BF).copy(alpha = .6f),
                        Color(0xFF43B4E4).copy(alpha = .6f),
                        Color(0xFF3A60E6).copy(alpha = .6f),
                        Color(0xFF57D6BF).copy(alpha = .6f),
                        Color(0xFFD02596).copy(alpha = .6f)
                    )
                )
            )
        }

        // Design Pattern Custom Chart
        CustomCard(
            title = "Custom Chart"
        ) {

            LinearChart.CustomLinearChart(
                linearData = LinearEmojiData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(
                            6f, 4f, 2f, 0f, 3f, 5f, 6f
                        )
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    ),
                    yMarkerList = LinearPoint.pointDataBuilder(
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_furious
                        ) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_angry) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_sad) as BitmapDrawable,
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_depressed
                        ) as BitmapDrawable,
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_confused
                        ) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_calm) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_happy) as BitmapDrawable
                    ).toMutableList()
                ),
                plot = LinearGradientLinePlot(
                    colorList = listOf(
                        Color(0xFFE5E787).copy(alpha = .6f),
                        Color(0xFF85DE50).copy(alpha = .6f),
                        Color(0xFF57D6BF).copy(alpha = .6f),
                        Color(0xFF43B4E4).copy(alpha = .6f),
                        Color(0xFF3A60E6).copy(alpha = .6f),
                        Color(0xFF57D6BF).copy(alpha = .6f),
                        Color(0xFFD02596).copy(alpha = .6f)
                    )
                )
            )
        }

        // Design Pattern Bar Chart
        CustomCard(
            title = "Bar Chart"
        ) {

            LinearChart.BarChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                ),
                plot = LinearBarPlot(
                    barWidth = 40f,
                    cornerRadius = 16f
                )
            )
        }

        // Design Pattern Emoji Bar Chart
        CustomCard(
            title = "Emoji Bar Chart"
        ) {

            LinearChart.EmojiBarChart(
                linearData = LinearEmojiData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(
                            6f, 4f, 2f, 0f, 3f, 5f, 6f
                        )
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    ),
                    yMarkerList = LinearPoint.pointDataBuilder(
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_furious
                        ) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_angry) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_sad) as BitmapDrawable,
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_depressed
                        ) as BitmapDrawable,
                        getDrawable(
                            LocalContext.current,
                            R.drawable.emoji_confused
                        ) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_calm) as BitmapDrawable,
                        getDrawable(LocalContext.current, R.drawable.emoji_happy) as BitmapDrawable
                    ).toMutableList()
                )
            )
        }

        // Design Pattern Same row Donut Chart
        CustomCard(
            title = " Row Donut Chart"
        ) {

            CircularDonutChartRow.DonutChartRow(
                circularData = CircularDonutListData(
                    itemsList = listOf(
                        Pair("Water", 1500.0f),
                        Pair("Juice", 300.0f),
                        Pair("Soft Drink", 500.0f)
                    ),
                    siUnit = "L",
                    cgsUnit = "mL",
                    conversionRate = { it / 1000f }
                ),
                circularForeground = CircularDonutForeground(
                    radiusMultiplier = 1.7f,
                    strokeWidth = 10f,
                    startAngle = 30f
                ),
                circularCenter = CircularTargetTextCenter(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W800
                )
            )
        }

        // Design Pattern Different row Donut Chart
        CustomCard(
            title = "Column Donut Chart"
        ) {

            CircularDonutChartColumn.DonutChartColumn(
                circularData = CircularDonutListData(
                    itemsList = listOf(
                        Pair("Normal", 450f),
                        Pair("Deep", 180f),
                        Pair("Delay", 30f),
                        Pair("Distributed", 60f)
                    ),
                    siUnit = "Hrs",
                    cgsUnit = "Min",
                    conversionRate = { it / 60f }
                )
            )
        }

        // Design Pattern Target Achieved Donut Chart
        CustomCard(
            title = "Target Donut Chart"
        ) {

            CircularDonutChartRow.TargetDonutChart(
                circularData = CircularTargetDataBuilder(
                    target = 4340f,
                    achieved = 2823f,
                    siUnit = "Km",
                    cgsUnit = "m",
                    conversionRate = { it / 1000f }
                ),
                circularCenter = CircularTargetTextCenter(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700
                )
            )
        }

        // Design Pattern Single Ring Chart
        CustomCard(
            title = "Single Ring Chart"
        ) {
            CircularRingChart.SingleRingChart(
                circularData = CircularTargetDataBuilder(
                    target = 500f,
                    achieved = 489f,
                    siUnit = "",
                    cgsUnit = "",
                    conversionRate = { it }
                ),
                circularCenter = CircularRingTextCenter(
                    title = "AQI",
                    centerValue = "489",
                    status = "Moderate"
                )
            )
        }

        // Design Pattern Single Ring Chart using Custom Center
        CustomCard(
            title = "Single Ring Chart"
        ) {
            CircularRingChart.SingleRingChart(
                circularData = CircularTargetDataBuilder(
                    target = 500f,
                    achieved = 329f,
                    siUnit = "",
                    cgsUnit = "",
                    conversionRate = { it }
                ),
                circularCenter = CircularCustomCenter(
                    body = {
                        // Holds all the texts composable
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            // Title
                            Text(
                                text = "AQI",

                                modifier = Modifier
                                    .padding(vertical = 2.dp),

                                // Text Features
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            // Item and Value
                            Text(
                                text = "329",

                                modifier = Modifier
                                    .padding(vertical = 2.dp),

                                // Text Features
                                textAlign = TextAlign.Center,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W800,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            // Item and Value
                            Text(
                                text = "Moderate",

                                modifier = Modifier
                                    .padding(vertical = 2.dp),

                                // Text Features
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                )
            )
        }

        // Design Pattern Double Ring Chart
        CustomCard(
            title = "Double Ring Chart"
        ) {
            CircularRingChart.MultipleRingChart(
                circularData = listOf(
                    CircularTargetDataBuilder(
                        target = 100f,
                        achieved = 81f,
                        siUnit = "bpm",
                        cgsUnit = "bpm",
                        conversionRate = { it }
                    ),
                    CircularTargetDataBuilder(
                        target = 160f,
                        achieved = 112f,
                        siUnit = "mmhg",
                        cgsUnit = "mmhg",
                        conversionRate = { it }
                    )
                ),
                circularCenter = listOf(
                    CircularRingTextCenter(
                        title = "Heart Rate",
                        centerValue = "81 bpm",
                        status = "Normal"
                    ),
                    CircularRingTextCenter(
                        title = "Blood Pressure",
                        centerValue = "112/80 mmhg",
                        status = "Normal"
                    )
                )
            )
        }

        CustomCard(
            title = "Weekly Progress"
        ) {
            Row {

                listOf("M", "T", "W", "T", "F", "S", "S").forEach {

                    Column(
                        modifier = Modifier
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        CircularChart.DonutChartImage(
                            modifier = Modifier
                                .size(55.dp),
                            circularData = CircularTargetDataBuilder(
                                target = 100f,
                                achieved = 81f,
                                siUnit = "",
                                cgsUnit = "",
                                conversionRate = { it }
                            ),
                            circularCenter = CircularImageCenter(
                                image = Icons.Default.Check,
                                contentDescription = "Achieved"
                            ),
                            circularForeground = CircularDonutTargetForeground(strokeWidth = 10f)
                        )

                        Text(
                            text = it,

                            // Text Features
                            textAlign = TextAlign.Start,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}
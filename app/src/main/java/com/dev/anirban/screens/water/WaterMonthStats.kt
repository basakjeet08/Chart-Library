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
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.linear.LinearChart
import com.dev.anirban.chartlibrary.linear.colorconvention.LinearGridColorConvention
import com.dev.anirban.chartlibrary.linear.data.LinearStringData
import com.dev.anirban.chartlibrary.linear.util.LinearPoint
import com.dev.anirban.screens.components.CustomCard
import com.dev.anirban.screens.components.DetailsCard
import com.dev.anirban.ui.theme.ChartLibraryTheme
import com.dev.anirban.ui.theme.InterFontFamily

// Preview Composable Function
@Preview(
    "Light",
    heightDp = 1060,
    showBackground = true
)
@Preview(
    name = "Dark",
    heightDp = 1060,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        WaterMonthStats()
    }
}

@Composable
fun WaterMonthStats() {

    // This Column contains the body of the screen
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        // Amount Consumed Card
        CustomCard(
            title = "Amount Consumed",
            heightBetweenTitleAndBody = 24.dp
        ) {
            DetailsCard(
                imageList = listOf(
                    R.drawable.image_water_daily_average,
                    R.drawable.image_water_total
                ),
                headerTextList = listOf("Daily Avg", "Total"),
                valueList = listOf("2875 mL", "2025 mL")
            )
        }

        // Weekly Progress Line Chart
        CustomCard(title = "Monthly Progress") {

            LinearChart.LineChart(
                linearData = LinearStringData(
                    yAxisReadings = listOf(
                        LinearPoint.pointDataBuilder(6f, 5f, 4f, 6.2f, 7.4f, 7f, 5.9f)
                    ),
                    xAxisReadings = LinearPoint.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                )
            )
        }

        // Ratio Chart
        CustomCard(title = "Ratio") {
            CircularDonutChartRow.DonutChartRow(
                circularData = CircularDonutListData(
                    itemsList = listOf(
                        Pair("Water", 1500f),
                        Pair("Juice", 300f),
                        Pair("Soft Drinks", 500f)
                    ),
                    siUnit = "L",
                    cgsUnit = "mL",
                    conversionRate = { it / 1000f }
                ),
                circularDecoration = CircularDecoration.donutChartDecorations(
                    colorList = listOf(Color.Blue, Color.Green, Color.Red)
                )
            )
        }

        // Double Line Chart for the Beverages
        CustomCard(title = "Beverages") {
            Column {
                LinearChart.LineChart(
                    linearData = LinearStringData(
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
                    text = "Beverages",

                    // Modifications
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 12.dp),

                    // Text and Font Properties
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
            }
        }
    }
}
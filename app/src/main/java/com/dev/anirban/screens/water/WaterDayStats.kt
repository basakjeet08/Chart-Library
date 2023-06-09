package com.dev.anirban.screens.water

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dev.anirban.chartlibrary.circular.charts.DonutChartWithDataAtSide
import com.dev.anirban.chartlibrary.circular.data.DonutListData
import com.dev.anirban.chartlibrary.circular.data.TargetData
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.linear.LinearChart
import com.dev.anirban.chartlibrary.linear.colorconvention.GridColorConvention
import com.dev.anirban.chartlibrary.linear.data.LinearData
import com.dev.anirban.chartlibrary.linear.util.Point
import com.dev.anirban.screens.utils.CustomCard
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
        CustomCard {
            DonutChartWithDataAtSide.TargetDonutChart(
                chartTitle = "Daily Progress",
                circularData = TargetData(
                    target = 4000f,
                    achieved = 5000f,
                    siUnit = "L",
                    cgsUnit = "mL",
                    conversionRate = { it / 1000f }
                )
            )
        }

        CustomCard {
            LinearChart.BarChart(
                chartTitle = "Daily Progress",
                linearData = LinearData(
                    yAxisReadings = listOf(
                        Point.pointDataBuilder(5f, 10f, 6f, 4.2f, 8f, 10f, 6f)
                    ),
                    xAxisReadings = Point.pointDataBuilder(
                        "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
                    )
                )
            )
        }

        CustomCard {
            DonutChartWithDataAtSide.RowDonutChart(
                chartTitle = "Ratio",
                circularData = DonutListData(
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

        CustomCard {
            LinearChart.LineChart(
                chartTitle = "Beverages",
                linearData = LinearData(
                    yAxisReadings = listOf(
                        Point.pointDataBuilder(3f, 2.5f, 2.8f, 3.5f, 5.7f, 2.6f, 3.4f),
                        Point.pointDataBuilder(3.6f, 3f, 2.4f, 6f, 4.5f, 2.9f, 3.8f)
                    ),
                    xAxisReadings = Point.pointDataBuilder(
                        "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
                    )
                ),
                colorConvention = GridColorConvention(
                    textList = listOf("Water", "Juice")
                )
            )
        }
    }
}
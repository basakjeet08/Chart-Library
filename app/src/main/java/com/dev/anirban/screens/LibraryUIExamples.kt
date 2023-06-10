package com.dev.anirban.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.circular.center.DonutTargetTextCenter
import com.dev.anirban.chartlibrary.circular.center.RingChartTextCenter
import com.dev.anirban.chartlibrary.circular.charts.DonutChartWithDataAtBottom
import com.dev.anirban.chartlibrary.circular.charts.DonutChartWithDataAtSide
import com.dev.anirban.chartlibrary.circular.charts.RingChart
import com.dev.anirban.chartlibrary.circular.data.DonutListData
import com.dev.anirban.chartlibrary.circular.data.TargetData
import com.dev.anirban.chartlibrary.circular.foreground.DonutChartForeground
import com.dev.anirban.chartlibrary.linear.LinearChart
import com.dev.anirban.chartlibrary.linear.data.LinearData
import com.dev.anirban.chartlibrary.linear.plots.BarPlot
import com.dev.anirban.chartlibrary.linear.plots.LinePlot
import com.dev.anirban.chartlibrary.linear.util.Point

@Composable
fun LibraryUIExample() {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {

        // Design Pattern Single Line Chart
        ElevatedCard(
            modifier = Modifier
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {

            LinearChart.LineChart(
                chartTitle = "Single Line Chart",
                linearData = LinearData(
                    yAxisReadings = listOf(
                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)
                    ),
                    xAxisReadings = Point.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                ),
                plotting = LinePlot(
                    lineStroke = 5f,
                    circleRadius = 8f
                )
            )
        }

        // Design Pattern Double Line Chart
        ElevatedCard(
            modifier = Modifier
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {

            LinearChart.LineChart(
                chartTitle = "Double Line Chart",
                linearData = LinearData(
                    yAxisReadings = listOf(
                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f),
                        Point.pointDataBuilder(3f, 6f, 8f, 2f, 3.5f, 3f, 4f)
                    ),
                    xAxisReadings = Point.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                ),
                plotting = LinePlot(
                    lineStroke = 8f,
                    circleRadius = 8f
                )
            )
        }

        // Design Pattern Triple Line Chart
        ElevatedCard(
            modifier = Modifier
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {

            LinearChart.LineChart(
                chartTitle = "Triple Line Chart",
                linearData = LinearData(
                    yAxisReadings = listOf(
                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f),
                        Point.pointDataBuilder(3f, 6f, 8f, 2f, 3.5f, 3f, 4f),
                        Point.pointDataBuilder(1f, 8f, 4f, 3f, 5.9f, 2.9f, 4.7f)
                    ),
                    xAxisReadings = Point.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                )
            )
        }

        // Design Pattern Bar Chart
        ElevatedCard(
            modifier = Modifier
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {

            LinearChart.BarChart(
                chartTitle = "Bar Chart",
                linearData = LinearData(
                    yAxisReadings = listOf(
                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)
                    ),
                    xAxisReadings = Point.pointDataBuilder(
                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                    )
                ),
                plotting = BarPlot(
                    barWidth = 40f,
                    cornerRadius = 16f
                )
            )
        }

        // Design Pattern Same row Donut Chart
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {

            DonutChartWithDataAtSide.RowDonutChart(
                chartTitle = "Row Donut Chart",
                circularData = DonutListData(
                    itemsList = listOf(
                        Pair("Water", 1500.0f),
                        Pair("Juice", 300.0f),
                        Pair("Soft Drink", 500.0f)
                    ),
                    siUnit = "L",
                    cgsUnit = "mL",
                    conversionRate = { it / 1000f }
                ),
                circularForeground = DonutChartForeground(
                    radiusMultiplier = 1.7f,
                    strokeWidth = 10f,
                    startAngle = 30f
                ),
                circularCenter = DonutTargetTextCenter(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W800
                )
            )
        }

        // Design Pattern Different row Donut Chart
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {

            DonutChartWithDataAtBottom.ColumnDonutChart(
                chartTitle = "Column Donut Chart",
                circularData = DonutListData(
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
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {

            DonutChartWithDataAtSide.TargetDonutChart(
                chartTitle = "Target Donut Chart",
                circularData = TargetData(
                    target = 4340f,
                    achieved = 2823f,
                    siUnit = "Km",
                    cgsUnit = "m",
                    conversionRate = { it / 1000f }
                ),
                circularCenter = DonutTargetTextCenter(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700
                )
            )
        }

        // Design Pattern Single Ring Chart
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            RingChart.SingleRingChart(
                chartTitle = "Single Ring Chart",
                circularData = TargetData(
                    target = 500f,
                    achieved = 489f,
                    siUnit = "",
                    cgsUnit = "",
                    conversionRate = { it }
                ),
                circularCenter = RingChartTextCenter(
                    title = "AQI",
                    centerValue = "489",
                    status = "Moderate"
                )
            )
        }

        // Design Pattern Double Ring Chart
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
        ) {
            RingChart.MultipleRingChartRowWise(
                chartTitle = "Multiple Ring Chart",
                circularData = listOf(
                    TargetData(
                        target = 100f,
                        achieved = 81f,
                        siUnit = "bpm",
                        cgsUnit = "bpm",
                        conversionRate = { it }
                    ),
                    TargetData(
                        target = 160f,
                        achieved = 112f,
                        siUnit = "mmhg",
                        cgsUnit = "mmhg",
                        conversionRate = { it }
                    )
                ),
                circularCenter = listOf(
                    RingChartTextCenter(
                        title = "Heart Rate",
                        centerValue = "81 bpm",
                        status = "Normal"
                    ),
                    RingChartTextCenter(
                        title = "Blood Pressure",
                        centerValue = "112/80 mmhg",
                        status = "Normal"
                    )
                )
            )
        }
    }
}
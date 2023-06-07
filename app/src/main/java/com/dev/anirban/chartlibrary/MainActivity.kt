package com.dev.anirban.chartlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.library.circular.center.RingChartTextCenter
import com.dev.anirban.chartlibrary.library.circular.charts.DonutChartWithDataAtBottom.Companion.ColumnDonutChart
import com.dev.anirban.chartlibrary.library.circular.charts.DonutChartWithDataAtSide.Companion.RowDonutChart
import com.dev.anirban.chartlibrary.library.circular.charts.DonutChartWithDataAtSide.Companion.TargetDonutChart
import com.dev.anirban.chartlibrary.library.circular.charts.RingChart.Companion.MultipleRingChartRowWise
import com.dev.anirban.chartlibrary.library.circular.charts.RingChart.Companion.SingleRingChart
import com.dev.anirban.chartlibrary.library.circular.data.DonutListData
import com.dev.anirban.chartlibrary.library.circular.data.TargetData
import com.dev.anirban.chartlibrary.library.linear.LinearChart.Companion.BarChart
import com.dev.anirban.chartlibrary.library.linear.LinearChart.Companion.LineChart
import com.dev.anirban.chartlibrary.library.linear.data.LinearData
import com.dev.anirban.chartlibrary.library.linear.util.Point
import com.dev.anirban.chartlibrary.ui.theme.ChartLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChartLibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

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

                            LineChart(
                                linearData = LinearData(
                                    yAxisReadings = listOf(
                                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)
                                    ),
                                    xAxisReadings = Point.pointDataBuilder(
                                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                                    )
                                )
                            )
                        }

                        // Design Pattern Double Line Chart
                        ElevatedCard(
                            modifier = Modifier
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {

                            LineChart(
                                linearData = LinearData(
                                    yAxisReadings = listOf(
                                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f),
                                        Point.pointDataBuilder(3f, 6f, 8f, 2f, 3.5f, 3f, 4f)
                                    ),
                                    xAxisReadings = Point.pointDataBuilder(
                                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                                    )
                                )
                            )
                        }

                        // Design Pattern Triple Line Chart
                        ElevatedCard(
                            modifier = Modifier
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {

                            LineChart(
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

                            BarChart(
                                linearData = LinearData(
                                    yAxisReadings = listOf(
                                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)
                                    ),
                                    xAxisReadings = Point.pointDataBuilder(
                                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                                    )
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

                            RowDonutChart(
                                circularData = DonutListData(
                                    itemsList = listOf(
                                        Pair("Water", 1500.0f),
                                        Pair("Juice", 300.0f),
                                        Pair("Soft Drink", 500.0f)
                                    ),
                                    siUnit = "L",
                                    cgsUnit = "mL",
                                    conversionRate = { it / 1000f }
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

                            ColumnDonutChart(
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

                            TargetDonutChart(
                                circularData = TargetData(
                                    target = 4340f,
                                    achieved = 2823f,
                                    siUnit = "Km",
                                    cgsUnit = "m",
                                    conversionRate = { it / 1000f }
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
                            SingleRingChart(
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
                            MultipleRingChartRowWise(
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
            }
        }
    }
}
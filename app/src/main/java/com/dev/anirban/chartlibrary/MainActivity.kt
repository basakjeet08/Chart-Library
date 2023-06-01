package com.dev.anirban.chartlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.chartsprototypes.barchart.BarChart
import com.dev.anirban.chartlibrary.chartsprototypes.donutchart.diffrow.DifferentRowDonutChart
import com.dev.anirban.chartlibrary.chartsprototypes.donutchart.samerow.DonutChart
import com.dev.anirban.chartlibrary.chartsprototypes.donutchart.samerow.DonutChartData
import com.dev.anirban.chartlibrary.chartsprototypes.ringchart.RingChart
import com.dev.anirban.chartlibrary.designpattern.linear.LinearChart
import com.dev.anirban.chartlibrary.designpattern.linear.data.LineData
import com.dev.anirban.chartlibrary.designpattern.linear.decoration.LineDecoration
import com.dev.anirban.chartlibrary.designpattern.linear.margins.NumberMargin
import com.dev.anirban.chartlibrary.designpattern.linear.plots.LinePlot
import com.dev.anirban.chartlibrary.designpattern.util.Point
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

                    // This is the Line Chart with a proper design pattern
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {

                        // Line Chart
                        ElevatedCard(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {


                            LinearChart(
                                margin = NumberMargin(),
                                decoration = LineDecoration(
                                    textColor = MaterialTheme.colorScheme.onSurface,
                                    plotColor = listOf(Color.Blue),
                                    pointColor = listOf(Color.Green)
                                ),
                                linearData = LineData(
                                    yAxisReadings = listOf(
                                        listOf(
                                            Point(6f),
                                            Point(5f),
                                            Point(4f),
                                            Point(6f),
                                            Point(7.5f),
                                            Point(7f),
                                            Point(6f)
                                        )
                                    ),
                                    xAxisReadings = listOf(
                                        Point("Jan"),
                                        Point("Mar"),
                                        Point("May"),
                                        Point("Jul"),
                                        Point("Sep"),
                                        Point("Nov"),
                                        Point("Dec")
                                    )
                                ),
                                plotting = LinePlot()
                            ).Build(
                                modifier = Modifier
                                    .padding(24.dp)
                                    .height(200.dp)
                            )
                        }

                        // Same row Donut Chart
                        ElevatedCard(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {
                            DonutChart(
                                donutChartData = DonutChartData(
                                    itemsList = listOf(
                                        Pair("Water", 1500.0f),
                                        Pair("Juice", 300.0f),
                                        Pair("Soft Drink", 500.0f)
                                    )
                                ),
                                colorList = listOf(
                                    Color.Blue,
                                    Color.Green,
                                    Color.Red
                                ),
                                unit = "mL"
                            ).BuildChart()
                        }

                        // Different Row Donut Chart
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {
                            DifferentRowDonutChart()
                        }

                        // Raw Ring Chart
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {
                            RingChart()
                        }


                        // Raw Bar Chart
                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {

                            BarChart(
                                yAxisReadings = listOf(listOf(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)),
                                xAxisReadings = listOf(
                                    "Jan",
                                    "Mar",
                                    "May",
                                    "Jul",
                                    "Sep",
                                    "Nov",
                                    "Dec"
                                ),
                                lineColor = listOf(
                                    Color.Blue,
                                    Color.Green,
                                    Color.Yellow,
                                    Color.Cyan,
                                    Color.Magenta,
                                    Color.DarkGray,
                                    Color.Blue
                                ),
                                numOfXMarkers = 7,
                                numOfYMarkers = 5,
                                height = 200.dp,
                                textColor = MaterialTheme.colorScheme.onSurface.toArgb()
                            )
                        }
                    }
                }
            }
        }
    }
}
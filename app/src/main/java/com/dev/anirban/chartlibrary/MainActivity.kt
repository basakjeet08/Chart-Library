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
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.chartsprototypes.ringchart.RingChart
import com.dev.anirban.chartlibrary.designpattern.circular.charts.ColumnDonutChart
import com.dev.anirban.chartlibrary.designpattern.circular.charts.RowDonutChart
import com.dev.anirban.chartlibrary.designpattern.circular.data.CircularData
import com.dev.anirban.chartlibrary.designpattern.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.designpattern.linear.LinearChart
import com.dev.anirban.chartlibrary.designpattern.linear.data.LinearData
import com.dev.anirban.chartlibrary.designpattern.linear.decoration.LineDecoration
import com.dev.anirban.chartlibrary.designpattern.linear.margins.NumberMargin
import com.dev.anirban.chartlibrary.designpattern.linear.plots.BarPlot
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

                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {

                        // Design Pattern Single Line Chart
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
                                    plotPrimaryColor = listOf(Color.Cyan),
                                    plotSecondaryColor = listOf(Color.Red)
                                ),
                                linearData = LinearData(
                                    yAxisReadings = listOf(
                                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)
                                    ),
                                    xAxisReadings = Point.pointDataBuilder(
                                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                                    )
                                ),
                                plotting = LinePlot()
                            ).Build(
                                modifier = Modifier
                                    .padding(24.dp)
                                    .height(200.dp)
                            )
                        }

                        // Design Pattern Double Line Chart
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
                                    plotPrimaryColor = listOf(Color.Cyan, Color.Green),
                                    plotSecondaryColor = listOf(Color.Red, Color.Magenta)
                                ),
                                linearData = LinearData(
                                    yAxisReadings = listOf(
                                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f),
                                        Point.pointDataBuilder(3f, 6f, 8f, 2f, 3.5f, 3f, 4f)
                                    ),
                                    xAxisReadings = Point.pointDataBuilder(
                                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                                    )
                                ),
                                plotting = LinePlot()
                            ).Build(
                                modifier = Modifier
                                    .padding(24.dp)
                                    .height(200.dp)
                            )
                        }

                        // Design Pattern Triple Line Chart
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
                                    plotPrimaryColor = listOf(
                                        Color.Cyan,
                                        Color.Green,
                                        Color.Yellow
                                    ),
                                    plotSecondaryColor = listOf(
                                        Color.LightGray,
                                        Color.Magenta,
                                        Color.Red
                                    )
                                ),
                                linearData = LinearData(
                                    yAxisReadings = listOf(
                                        Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f),
                                        Point.pointDataBuilder(3f, 6f, 8f, 2f, 3.5f, 3f, 4f),
                                        Point.pointDataBuilder(1f, 8f, 4f, 3f, 5.9f, 2.9f, 4.7f)
                                    ),
                                    xAxisReadings = Point.pointDataBuilder(
                                        "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                                    )
                                ),
                                plotting = LinePlot()
                            ).Build(
                                modifier = Modifier
                                    .padding(24.dp)
                                    .height(200.dp)
                            )
                        }

                        // Design Pattern Bar Chart
                        ElevatedCard(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {

                            val linearData = LinearData(
                                yAxisReadings = listOf(
                                    Point.pointDataBuilder(6f, 5f, 4f, 6f, 7.5f, 7f, 6f)
                                ),
                                xAxisReadings = Point.pointDataBuilder(
                                    "Jan", "Mar", "May", "Jul", "Sep", "Nov", "Dec"
                                )
                            )

                            val colorList = listOf(
                                Color.Blue,
                                Color.Red,
                                Color.Green,
                                Color.Magenta,
                                Color.LightGray,
                                Color.Yellow,
                                Color.Cyan
                            )


                            LinearChart(
                                margin = NumberMargin(),
                                decoration = LineDecoration(
                                    textColor = MaterialTheme.colorScheme.onSurface,
                                    plotPrimaryColor = colorList,
                                    plotSecondaryColor = listOf(Color.Green)
                                ),
                                linearData = linearData,
                                plotting = BarPlot()
                            ).Build(
                                modifier = Modifier
                                    .padding(24.dp)
                                    .height(200.dp)
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
                                circularData = CircularData(
                                    itemsList = listOf(
                                        Pair("Water", 1500.0f),
                                        Pair("Juice", 300.0f),
                                        Pair("Soft Drink", 500.0f)
                                    )
                                ),
                                circularDecoration = CircularDecoration(
                                    colorList = listOf(
                                        Color.Blue,
                                        Color.Green,
                                        Color.Red
                                    )
                                )
                            ).Build(
                                modifier = Modifier
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
                                circularData = CircularData(
                                    itemsList = listOf(
                                        Pair("Normal", 450f),
                                        Pair("Deep", 180f),
                                        Pair("Delay", 30f),
                                        Pair("Distributed", 60f)
                                    )
                                ),
                                circularDecoration = CircularDecoration(
                                    colorList = listOf(
                                        Color.Blue,
                                        Color.Green,
                                        Color.Yellow,
                                        Color.Red
                                    )
                                )
                            ).Build(
                                modifier = Modifier
                            )
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
                    }
                }
            }
        }
    }
}
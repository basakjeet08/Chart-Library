package com.dev.anirban.chartlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.chartsprototypes.donutchart.DonutChart
import com.dev.anirban.chartlibrary.chartsprototypes.donutchart.DonutChartData
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChart
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChartData
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChartDecoration
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


//                    Chart(
//                        chartBuilder = LinearChartBuilderStrategy(),
//                        chartDataModel = LinearChartDataModelStrategy()
//                    ).build()
//
//                    Chart(
//                        chartBuilder = CircularChartBuilderStrategy(),
//                        chartDataModel = CircularChartDataModelStrategy()
//                    ).build()


                    Column {
                        ElevatedCard(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                                .padding(8.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                        ) {

                            val lineChartData = LineChartData(
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
                                numOfXMarkers = 7,
                                numOfYMarkers = 5
                            )

                            val lineChartDecoration = LineChartDecoration(
                                textColor = MaterialTheme.colorScheme.onSurface.toArgb(),
                                lineColor = listOf(Color.Blue),
                                dotColor = listOf(Color.Green)
                            )

                            LineChart(
                                lineChartData,
                                lineChartDecoration
                            ).BuildChart()
                        }

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
                    }
                }
            }
        }
    }
}
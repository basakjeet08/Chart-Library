package com.dev.anirban.chartlibrary.charts.donutchart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class DonutChart(
    private val donutChartData: DonutChartData,
    private val colorList: List<Color>,
    private val unit: String
) {

    private fun DrawScope.drawPieChart(
        componentSize: Size,
        colorList: List<Color>
    ) {

        // This is used to define the sweep angle of each and every Floating Data
        var currentSweepAngle = 270f

        // Drawing all the arcs
        donutChartData.sweepAngles.forEachIndexed { index, fl ->

            //This function draws the Arc
            drawArc(
                color = colorList[index],
                startAngle = currentSweepAngle,
                sweepAngle = fl,
                useCenter = false,
                size = componentSize,
                style = Stroke(
                    width = 45f
                ),
                topLeft = Offset(
                    x = (size.width - componentSize.width) / 2f,
                    y = (size.height - componentSize.height) / 2f
                )
            )

            // Marking the sweep angle for the next Floating Item
            currentSweepAngle += fl + 4f
        }
    }

    @Composable
    fun BuildChart(
        modifier: Modifier = Modifier,
        height: Dp = 190.dp
    ) {

        // It separates the Chart and its reading Items and color coding
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(height)
                .defaultMinSize(minWidth = Dp.Infinity, minHeight = height)
        ) {

            // This contains the Pie Chart Graph
            Box(
                modifier = Modifier
                    .width(height)
                    .height(height)
                    .drawBehind {

                        // Size of the chart (We are taking a bit less than the Canvas to make it look good)
                        val chartSize = size / 2f

                        // This draws the Pie Chart Graph
                        drawPieChart(
                            componentSize = chartSize,
                            colorList = colorList
                        )
                    }
            )

            // This UI contains all the Items given and their values and color codes
            Column(
                modifier = Modifier
                    .weight(1f)
                    .defaultMinSize(minHeight = height, minWidth = Dp.Infinity),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Drawing the Color Code and writing the Text of the UI
                donutChartData.itemsList.forEachIndexed { it, pair ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp, bottom = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Drawing the small circles(color codes)
                        Canvas(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(20.dp)
                        ) {

                            // This function draws the Color codes circles
                            drawCircle(
                                colorList[it],
                                radius = 20f,
                                center = size.center
                            )
                        }

                        // Item Name
                        Text(
                            text = "${pair.first} - ",
                            modifier = Modifier
                                .padding(top = 4.dp, bottom = 4.dp, start = 4.dp),

                            // Text Features
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W300
                        )

                        // Checking if the data should be displayed in SI unit or Cgs
                        val value =
                            if (pair.second >= 1000) pair.second / 1000.0f else pair.second.toInt()
                        val reconsideredUnit = if (pair.second >= 1000) "L" else unit

                        // Item Value
                        Text(
                            text = "$value$reconsideredUnit",

                            // Text Features
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500
                        )
                    }
                }
            }
        }
    }
}
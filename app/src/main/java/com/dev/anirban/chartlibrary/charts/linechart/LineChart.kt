package com.dev.anirban.chartlibrary.charts.linechart

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * This is the Line Chart Class which creates a Line Chart composable graph
 *
 * @param lineChartData This variable is a object of [LineChartData] class and has all the data
 * related to the LineChart
 * @param lineChartDecoration This is a object of [LineChartDecoration] class and has all the data
 * related to the decorations for the graph
 */
class LineChart<T>(
    private val lineChartData: LineChartData<T>,
    private val lineChartDecoration: LineChartDecoration
) {

    /**
     * This function draws the margins in the graph
     */
    private fun DrawScope.drawMargins() {

        for (i in 1..lineChartData.numOfYMarkers) {

            // This is the value of the current Y Axis Marker
            val currentYMarker = lineChartData.yUpperReading - (i - 1) * lineChartData.yDividend

            // This draws the String Marker
            drawContext.canvas.nativeCanvas.drawText(
                currentYMarker.toString(),
                lineChartData.xOrigin - 24f,
                (lineChartData.yScale * i) + 12f,
                Paint().apply {
                    color = lineChartDecoration.textColor
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.LEFT
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
            )

            // This draws the Lines for the readings parallel to X Axis
            drawLine(
                start = Offset(
                    x = lineChartData.xOrigin + 24f,
                    y = lineChartData.yScale * i
                ),
                color = Color.Gray,
                end = Offset(
                    x = lineChartData.xMax,
                    y = lineChartData.yScale * i
                ),
                strokeWidth = 1f
            )
        }

        // This Draws the Y Markers below the Graph
        lineChartData.xAxisReadings.forEachIndexed { index, currentMarker ->

            // This draws the String Marker
            drawContext.canvas.nativeCanvas.drawText(
                currentMarker.toString(),
                lineChartData.xScale * (index + 1),
                lineChartData.yScale * (lineChartData.numOfYMarkers + 1),
                Paint().apply {
                    color = lineChartDecoration.textColor
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.LEFT
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
            )
        }
    }

    /**
     * This graph plots all the points in the graph
     */
    private fun DrawScope.plotPoints() {

        // This variable contains all the Offset of all the graph coordinates
        val graphCoordinatesList: MutableList<MutableList<Offset>> = mutableListOf()

        // Adding the Offsets to the Variable
        lineChartData.yAxisReadings.forEachIndexed { coordinateSetIndex, coordinateSet ->

            // Calculates the coordinate of One Set of the List
            val graphCoordinates: MutableList<Offset> = mutableListOf()

            coordinateSet.forEachIndexed { index, fl ->

                val currentYCoordinate =
                    (lineChartData.yScale + (lineChartData.yUpperReading - fl) * lineChartData.yScale / lineChartData.yDividend)

                // Adding the Coordinates of points in the same Set
                graphCoordinates.add(
                    Offset(
                        x = 24f + (index + 1) * lineChartData.xScale,
                        y = currentYCoordinate
                    )
                )
            }

            // Adding the coordinates of a whole Set in one Index of the Graph
            graphCoordinatesList.add(
                coordinateSetIndex,
                graphCoordinates
            )
        }

        // This loop makes the curved line between two points
        for (i in 0 until graphCoordinatesList.size) {

            // Path Variable
            val path = Path()

            // This is the current coordinate set
            val coordinates = graphCoordinatesList[i]

            // Moving to the start path of the the coordinate set to start making the Curved lines
            path.moveTo(
                coordinates[0].x,
                coordinates[0].y
            )

            // Inner Loop which draws the Lines from point to point of a single coordinate sets
            for (index in 0 until coordinates.size - 1) {

                // Control Points
                val control1X = (coordinates[index].x + coordinates[index + 1].x) / 2f
                val control1Y = coordinates[index].y
                val control2X = (coordinates[index].x + coordinates[index + 1].x) / 2f
                val control2Y = coordinates[index + 1].y

                // Defining the path from the last stayed to the next point
                path.cubicTo(
                    x1 = control1X,
                    y1 = control1Y,
                    x2 = control2X,
                    y2 = control2Y,
                    x3 = coordinates[index + 1].x,
                    y3 = coordinates[index + 1].y
                )
            }

            // Drawing path after defining all the points of a single coordinate set in the path
            drawPath(
                path = path,
                color = lineChartDecoration.lineColor[i],
                style = Stroke(
                    width = 4f
                )
            )
        }

        // This loop draws the circles or the points of the coordinates1
        graphCoordinatesList.forEachIndexed { index, offsets ->
            offsets.forEach {
                // This function draws the Circle points
                drawCircle(
                    color = lineChartDecoration.dotColor[index],
                    radius = 8f,
                    center = it
                )
            }
        }
    }

    /**
     * This is the only function which is public and it starts building the graph when called
     */
    @Composable
    fun BuildGraph(
        modifier: Modifier = Modifier,
        height: Dp = 200.dp
    ) {
        Canvas(
            modifier = modifier
                .fillMaxWidth()
                .height(height)
                .padding(top = 12.dp, bottom = 12.dp)
        ) {

            // Decreasing the Size of Component than the Canvas Size to make the UI look better
            val componentSize = size / 1.20f

            lineChartData.calculateCoordinatesAccordingToGraph(
                size = size,
                componentSize = componentSize
            )

            drawMargins()
            plotPoints()
        }
    }
}
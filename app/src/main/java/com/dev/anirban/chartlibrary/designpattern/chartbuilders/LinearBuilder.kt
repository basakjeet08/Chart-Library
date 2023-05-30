package com.dev.anirban.chartlibrary.designpattern.chartbuilders

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChartDecoration
import com.dev.anirban.chartlibrary.designpattern.chartdatas.LinearData

class LinearBuilder<T>(
    private val lineChartData: LinearData<T>,
    private val lineChartDecoration: LineChartDecoration
) : ChartBuilder {

    override fun DrawScope.drawForeground() {

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

    override fun DrawScope.drawBackground() {}

    override fun DrawScope.drawMargins() {

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

    override fun DrawScope.drawOthers() {}

}
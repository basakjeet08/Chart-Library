package com.dev.anirban.chartlibrary.chartsprototypes.barchart

import android.content.res.Configuration
import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Preview Function
@Preview("Light")
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
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

/**
 * This function draws the Line Graph in the UI
 *
 * @param modifier To be passed by the Parent Layout
 * @param xAxisReadings This is the list of X - coordinates which need to be mapped in the Graph
 * (Always provide the coordinates in ascending order of the Graph from left to right)
 * @param yAxisReadings This is the list of set of Y - coordinates which need to be mapped in the Graph
 * (Always provide the coordinates in ascending order of the Graph from left to right)
 * @param lineColor This is the list of color of the Line of a particular Set of the Graph Reading
 * @param height This is the Minimum height of the Graph
 * @param numOfXMarkers This is the Number of X markers which will be there in the Graph
 * @param numOfYMarkers This is the number of Y markers which will be there in the Graph
 */
@Composable
fun BarChart(
    modifier: Modifier = Modifier,
    yAxisReadings: List<List<Float>>,
    xAxisReadings: List<String>,
    lineColor: List<Color>,
    height: Dp = 200.dp,
    numOfYMarkers: Int,
    numOfXMarkers: Int,
    textColor: Int
) {

    // Y Axis Marker bounds are held by these variables
    var yUpper = yAxisReadings[0][0]
    var yLower = yAxisReadings[0][0]

    // Finding the upper bound and Lower Bound of Y
    yAxisReadings.forEach { readings ->
        readings.forEach {
            if (it > yUpper)
                yUpper = it

            if (it < yLower)
                yLower = it
        }
    }

    // Storing the upper Bound and Lower bound of Y Markers
    val yUpperReadingRange =
        yUpper.toInt() + ((numOfYMarkers - 1) - (yUpper.toInt() % (numOfYMarkers - 1)))

    val yLowerReadingRange = if (yLower < 0)
        if (yLower.toInt() % (numOfYMarkers - 1) == 0)
            yLower.toInt()
        else
            (((yLower.toInt() / (numOfYMarkers - 1)) - 1) * (numOfYMarkers - 1))
    else
        (yLower.toInt() - (yLower.toInt() % (numOfYMarkers - 1)))

    // Difference between each Y Markers
    val yDividend = (yUpperReadingRange - yLowerReadingRange) / (numOfYMarkers - 1)

    // This canvas draws the complex Line Chart UI
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .padding(top = 8.dp, bottom = 8.dp)
    ) {

        // Decreasing the Size of Component than the Canvas Size to make the UI look better
        val componentSize = size / 1.20f

        // X Coordinates of the Graph
        val xOrigin = (size.width - componentSize.width) / 2f
        val xMax = size.width - xOrigin

        // Y Coordinates of the Graph
        val yOrigin = (size.height - componentSize.height) / 2f
        val yMax = size.height - yOrigin

        // Total Size of each of the Coordinates of the Graph
        val xTotalSize = xMax - xOrigin
        val yTotalSize = yMax - yOrigin

        // Scale of both Axis of the Graph
        val yScale = yTotalSize / numOfYMarkers
        val xScale = xTotalSize / numOfXMarkers

        // This function draws the Axis and the Markers
        drawMargins(
            yMarkerCount = numOfYMarkers,
            xOrigin = xOrigin,
            xAxisMarkers = xAxisReadings,
            textColor = textColor,
            yUpperBound = yUpperReadingRange,
            yDividend = yDividend,
            yScale = yScale,
            xScale = xScale,
            xMax = xMax
        )

        // This function plots the Graph and joins the Line
        plotPoints(
            yAxisReadingsSet = yAxisReadings,
            xScale = xScale,
            yUpperBound = yUpperReadingRange,
            lineColor = lineColor,
            yDividend = yDividend,
            yScale = yScale,
            componentSize = componentSize
        )
    }
}

/**
 * This function draws the Margins and the Markers in the Graph
 *
 * @param yUpperBound This is the upper Marker Limit of the Graph
 * @param yDividend This is the difference between each graph Marker
 * @param xAxisMarkers This is the Markers that should be written in the X - Axis
 * @param yMarkerCount This is the Marker Count of the Y - Axis
 * @param xOrigin This is the Origin of X - Axis
 * @param yScale This is the scale of Y - Axis
 * @param textColor This is the text color of the Markers
 * @param xScale This is the scale of X - Axis
 * @param xMax This is the maximum floating coordinate where the graph ends
 */
private fun DrawScope.drawMargins(
    yUpperBound: Int,
    yDividend: Int,
    xAxisMarkers: List<String>,
    yMarkerCount: Int,
    xOrigin: Float,
    yScale: Float,
    textColor: Int,
    xScale: Float,
    xMax: Float
) {

    for (i in 1..yMarkerCount) {

        // This is the value of the current Y Axis Marker
        val currentYMarker = yUpperBound - (i - 1) * yDividend

        // This draws the String Marker
        drawContext.canvas.nativeCanvas.drawText(
            currentYMarker.toString(),
            xOrigin - 24f,
            (yScale * i) + 12f,
            Paint().apply {
                color = textColor
                textSize = 12.sp.toPx()
                textAlign = Paint.Align.LEFT
                typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            }
        )

        // This draws the Lines for the readings parallel to X Axis
        drawLine(
            start = Offset(
                x = xOrigin + 24f,
                y = yScale * i
            ),
            color = Color.Gray,
            end = Offset(
                x = xMax,
                y = yScale * i
            ),
            strokeWidth = 1f
        )
    }

    // This Draws the Y Markers below the Graph
    xAxisMarkers.forEachIndexed { index, currentMarker ->

        // This draws the String Marker
        drawContext.canvas.nativeCanvas.drawText(
            currentMarker,
            xScale * (index + 1),
            yScale * (yMarkerCount + 1),
            Paint().apply {
                color = textColor
                textSize = 12.sp.toPx()
                textAlign = Paint.Align.LEFT
                typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            }
        )
    }
}

/**
 * This is the function which plots the points in the Graph
 *
 * @param yAxisReadingsSet These contains the points of the Graph
 * @param xScale This is the xScale of the Graph
 * @param yUpperBound This is the upper bounds of the current Markers in the Graph
 * @param lineColor This is the color of the Line which will be showed in the curved lines
 * @param yDividend This is the difference between the Markers of Y - Axis
 * @param yScale This is the scale of the Y - Axis
 */
private fun DrawScope.plotPoints(
    yAxisReadingsSet: List<List<Float>>,
    xScale: Float,
    yUpperBound: Int,
    lineColor: List<Color>,
    yDividend: Int,
    yScale: Float,
    componentSize: Size
) {

    // This variable contains all the Offset of all the graph coordinates
    val graphCoordinatesList: MutableList<MutableList<Offset>> = mutableListOf()

    // Adding the Offsets to the Variable
    yAxisReadingsSet.forEachIndexed { coordinateSetIndex, coordinateSet ->

        // Calculates the coordinate of One Set of the List
        val graphCoordinates: MutableList<Offset> = mutableListOf()

        coordinateSet.forEachIndexed { index, fl ->

            val currentYCoordinate = (yScale + (yUpperBound - fl) * yScale / yDividend)

            // Adding the Coordinates of points in the same Set
            graphCoordinates.add(
                Offset(
                    x = 24f + (index + 1) * xScale,
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

    // This loop draws the circles or the points of the coordinates1
    graphCoordinatesList.forEach { offsets ->

        offsets.forEachIndexed { index, offset ->
            
            // This function draws the Bars
            drawRoundRect(
                color = lineColor[index],
                topLeft = offset,
                size = Size(
                    width = 20f,
                    height = componentSize.height - offset.y
                ),
                cornerRadius = CornerRadius(8f)
            )
        }
    }
}
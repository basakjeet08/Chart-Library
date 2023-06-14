package com.dev.anirban.chartlibrary.linear.data

import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Typeface
import androidx.compose.ui.geometry.Size
import com.dev.anirban.chartlibrary.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.linear.util.LinearPoint

/**
 * This is one of the implementation for storing and calculating the data in the chart. It
 * Implements the [LinearDataInterface] Interface
 *
 * @param xAxisReadings These are the readings of the X - Axis
 * @param yAxisReadings These are the readings of the Y - Axis
 * @param yMarkerList List of all the markers in the Y - Axis
 * @param numOfXMarkers These are the markers needed in X Axis
 */
class LinearStringData(
    override val yAxisReadings: List<List<LinearPoint<Float>>>,
    override val xAxisReadings: List<LinearPoint<String>>,
    override var yMarkerList: MutableList<LinearPoint<*>> = mutableListOf(),
    override val numOfXMarkers: Int = xAxisReadings.size,
) : LinearDataInterface {

    /**
     * These are the num of markers in Y-axis
     */
    override val numOfYMarkers: Int = yMarkerList.size

    /**
     * Upper Y - Axis Reading or the Maximum Reading of the Graph
     */
    private var yUpperReading: Int = Int.MIN_VALUE

    /**
     * Lower Y - Axis Reading or the Maximum Reading of the Graph
     */
    private var yLowerReading: Int = Int.MAX_VALUE

    /**
     * It is the difference of the Upper and Lower Markers divided by the Markers count
     */
    private var yDividend: Int

    init {

        if (yMarkerList.isNotEmpty()) {
            // Storing the upper Bound and Lower bound of Y Markers
            yUpperReading = yMarkerList.size
            yLowerReading = 0

            // Difference between each Y Markers
            yDividend = 1
        } else {

            // Maximum and minimum value provided is calculated
            val yMax = yAxisReadings.maxOf {
                it.maxOf { point ->
                    point.value
                }
            }
            val yMin = yAxisReadings.minOf {
                it.minOf { point ->
                    point.value
                }
            }

            // Storing the upper Bound and Lower bound of Y Markers
            yUpperReading = if (yMax % (numOfYMarkers - 1) != 0.0f)
                yMax.toInt() + ((numOfYMarkers - 1) - (yMax.toInt() % (numOfYMarkers - 1)))
            else
                yMax.toInt()

            yLowerReading = if (yMin.toInt() % (numOfYMarkers - 1) == 0) {
                yMin.toInt() - (numOfYMarkers - 1)
            } else {
                yMin.toInt() - (yMin.toInt() % (numOfYMarkers - 1))
            }

            // Difference between each Y Markers
            yDividend = (yUpperReading - yLowerReading) / (numOfYMarkers - 1)
        }
    }

    /**
     * This is the function which is responsible for the calculations of all the graph related stuff
     *
     * @param size This is the size of the whole canvas which also haves the componentSize in it
     */
    override fun doCalculations(size: Size) {

        // Scale of both Axis of the Graph
        val yScale = size.height / numOfYMarkers

        var maxWidth = 0


        // Calculating all the chart Y - Axis markers in the chart along with their coordinates
        yMarkerList.forEachIndexed { index, point ->

            val bounds = Rect()
            val paint = Paint()

            paint.textAlign = Paint.Align.LEFT
            paint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
            paint.getTextBounds(point.value.toString(), 0, point.value.toString().length, bounds)


            val currentYCoordinate = (yScale * index) + 12f

            // Setting the calculated graph coordinates to the object
            point.setXCoordinate(-24f)
            point.setYCoordinate(currentYCoordinate)

            val width = bounds.width()
            maxWidth = if (maxWidth < width) width else maxWidth
        }


        val xScale = (size.width - maxWidth) / (numOfXMarkers + 1)


        // Taking all the points given and calculating where they will stay in the graph
        yAxisReadings.forEach { pointSet ->

            pointSet.forEachIndexed { index, point ->

                val currentYCoordinate = (yUpperReading - point.value) * yScale / yDividend
                val currentXCoordinate = (index + 1) * xScale + maxWidth + 48f

                // Setting the calculated graph coordinates to the object
                point.setXCoordinate(currentXCoordinate)
                point.setYCoordinate(currentYCoordinate)
            }
        }

        // Calculating all the chart X - Axis markers coordinates
        xAxisReadings.forEachIndexed { index, currentMarker ->

            val xCoordinate = xScale * (index + 1) + maxWidth + 48f
            val yCoordinate = size.height

            // Setting the calculated graph coordinates to the object
            currentMarker.setXCoordinate(xCoordinate)
            currentMarker.setYCoordinate(yCoordinate)
        }
    }
}
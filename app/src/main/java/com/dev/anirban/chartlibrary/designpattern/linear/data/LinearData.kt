package com.dev.anirban.chartlibrary.designpattern.linear.data

import androidx.compose.ui.geometry.Size
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.designpattern.util.Point

/**
 * This is one of the implementation for storing and calculating the data in the chart. It
 * Implements the [LinearDataInterface] Interface
 *
 * @param xAxisReadings These are the readings of the X - Axis
 * @param yAxisReadings These are the readings of the Y - Axis
 * @param numOfXMarkers These are the markers needed in X Axis
 * @param numOfYMarkers These are teh num of markers in Y-axis
 */
class LinearData(
    override val yAxisReadings: List<List<Point<Float>>>,
    override val xAxisReadings: List<Point<String>>,
    override val numOfXMarkers: Int = 7,
    override val numOfYMarkers: Int = 5
) : LinearDataInterface {

    /**
     * List of all the markers in the Y - Axis
     */
    override var yMarkerList: MutableList<Point<*>> = mutableListOf()

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
            yMin.toInt()
        } else {
            yMin.toInt() - (yMin.toInt() % (numOfYMarkers - 1))
        }

        // Difference between each Y Markers
        yDividend = (yUpperReading - yLowerReading) / (numOfYMarkers - 1)
    }

    /**
     * This is the function which is responsible for the calculations of all the graph related stuff
     *
     * @param size This is the size of the whole canvas which also haves the componentSize in it
     */
    override fun doCalculations(size: Size) {

        // Scale of both Axis of the Graph
        val yScale = size.height / numOfYMarkers
        val xScale = size.width / numOfXMarkers

        // Taking all the points given and calculating where they will stay in the graph
        yAxisReadings.forEach { pointSet ->

            pointSet.forEachIndexed { index, point ->

                val currentYCoordinate = (yUpperReading - point.value) * yScale / yDividend
                val currentXCoordinate = 48f + (index) * xScale

                // Setting the calculated graph coordinates to the object
                point.setXCoordinate(currentXCoordinate)
                point.setYCoordinate(currentYCoordinate)
            }
        }

        // Calculating all the chart Y - Axis markers in the chart along with their coordinates
        for (index in 0 until numOfYMarkers) {

            // This is the value of the current Y Axis Marker
            val currentYMarker = yUpperReading - (index) * yDividend
            yMarkerList.add(index, Point(currentYMarker))

            val currentYCoordinate = (yScale * index) + 12f

            // Setting the calculated graph coordinates to the object
            yMarkerList[index].setXCoordinate(-24f)
            yMarkerList[index].setYCoordinate(currentYCoordinate)
        }

        // Calculating all the chart X - Axis markers coordinates
        xAxisReadings.forEachIndexed { index, currentMarker ->

            val xCoordinate = xScale * index + 24f
            val yCoordinate = size.height

            // Setting the calculated graph coordinates to the object
            currentMarker.setXCoordinate(xCoordinate)
            currentMarker.setYCoordinate(yCoordinate)
        }
    }
}
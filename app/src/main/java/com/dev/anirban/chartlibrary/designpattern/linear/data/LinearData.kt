package com.dev.anirban.chartlibrary.designpattern.linear.data

import androidx.compose.ui.geometry.Size
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.LinearDataInterface

/**
 * This is one of the implementation for storing and calculating the data in the chart. It
 * Implements the Interface -> [LinearDataInterface]
 *
 * @param xAxisReadings These are the readings of the X - Axis
 * @param yAxisReadings These are the readings of the Y - Axis
 * @param numOfXMarkers These are the markers needed in X Axis
 * @param numOfYMarkers These are teh num of markers in Y-axis
 */
class LineData(
    override val yAxisReadings: List<List<Float>>,
    override val xAxisReadings: List<String>,
    override val numOfXMarkers: Int = 7,
    override val numOfYMarkers: Int = 5
) : LinearDataInterface {

    /**
     * Upper Y - Axis Reading or the Maximum Reading of the Graph
     */
    var yUpperReading: Int = Int.MIN_VALUE

    /**
     * Lower Y - Axis Reading or the Maximum Reading of the Graph
     */
    private var yLowerReading: Int = Int.MAX_VALUE

    /**
     * X - Axis Scale
     */
    var xScale: Float = 0f

    /**
     * Y - Axis Scale
     */
    var yScale: Float = 0f

    /**
     * It is the difference of the Upper and Lower Markers divided by the Markers count
     */
    var yDividend: Int

    /**
     * This is the bottom right part of the Canvas
     */
    var xMax: Float = 0f
    private var yMax: Float = 0f


    init {

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
        yUpperReading =
            yUpper.toInt() + ((numOfYMarkers - 1) - (yUpper.toInt() % (numOfYMarkers - 1)))

        yLowerReading = if (yLower < 0)
            if (yLower.toInt() % (numOfYMarkers - 1) == 0)
                yLower.toInt()
            else
                (((yLower.toInt() / (numOfYMarkers - 1)) - 1) * (numOfYMarkers - 1))
        else
            (yLower.toInt() - (yLower.toInt() % (numOfYMarkers - 1)))

        // Difference between each Y Markers
        yDividend = (yUpperReading - yLowerReading) / (numOfYMarkers - 1)
    }

    /**
     * This is the function which is responsible for the calculations of all the graph related stuff
     *
     * @param size This is the size of the whole canvas which also haves the componentSize in it
     */
    override fun doCalculations(size: Size) {

        // X Coordinates of the Graph
        xMax = size.width

        // Y Coordinates of the Graph
        yMax = size.height

        // Scale of both Axis of the Graph
        yScale = yMax / numOfYMarkers
        xScale = xMax / numOfXMarkers
    }
}
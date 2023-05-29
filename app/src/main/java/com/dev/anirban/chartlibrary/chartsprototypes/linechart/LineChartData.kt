package com.dev.anirban.chartlibrary.chartsprototypes.linechart

import androidx.compose.ui.geometry.Size

/**
 * This class contains all the data related to the Line Chart and does all the calculations
 * necessary for plotting the line chart
 *
 * @param xAxisReadings These are the readings of the X - Axis
 * @param yAxisReadings These are the readings of the Y - Axis
 * @param numOfXMarkers These are the markers needed in X Axis
 * @param numOfYMarkers These are teh num of markers in Y-axis
 */
class LineChartData<T>(
    val yAxisReadings: List<List<Float>>,
    val xAxisReadings: List<T>,
    val numOfXMarkers: Int,
    val numOfYMarkers: Int
) {

    var yUpperReading: Int = Int.MIN_VALUE
    private var yLowerReading: Int = Int.MAX_VALUE

    var xScale: Float = 0f
    var yScale: Float = 0f
    var yDividend: Int

    var xOrigin: Float = 0f
    var xMax: Float = 0f
    private var yOrigin: Float = 0f
    private var yMax: Float = 0f
    private var xTotalSize: Float = 0f
    private var yTotalSize: Float = 0f


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
     * This function calculates the scale of the graph
     */
    fun calculateCoordinatesAccordingToGraph(size: Size, componentSize: Size) {

        // X Coordinates of the Graph
        xOrigin = (size.width - componentSize.width) / 2f
        xMax = size.width - xOrigin

        // Y Coordinates of the Graph
        yOrigin = (size.height - componentSize.height) / 2f
        yMax = size.height - yOrigin

        // Total Size of each of the Coordinates of the Graph
        xTotalSize = xMax - xOrigin
        yTotalSize = yMax - yOrigin

        // Scale of both Axis of the Graph
        yScale = yTotalSize / numOfYMarkers
        xScale = xTotalSize / numOfXMarkers
    }

}
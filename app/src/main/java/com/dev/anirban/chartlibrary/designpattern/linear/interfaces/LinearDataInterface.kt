package com.dev.anirban.chartlibrary.designpattern.linear.interfaces

import androidx.compose.ui.geometry.Size
import com.dev.anirban.chartlibrary.designpattern.util.Point

/**
 * This is the Data Interface which has to be implemented by the class which makes a new
 * Implementation for the handling of data and calculations in the graph
 */
interface LinearDataInterface {

    /**
     * These are the readings of the Y - Axis
     */
    val yAxisReadings: List<List<Point<*>>>

    /**
     * These are the readings of the X - Axis
     */
    val xAxisReadings: List<Point<*>>

    /**
     * These are the markers needed in X Axis
     */
    val numOfXMarkers: Int

    /**
     * These are teh num of markers in Y-axis
     */
    val numOfYMarkers: Int

    /**
     * THis is the function which contains most of the calculation logic of the graph
     */
    fun doCalculations(size: Size)

}
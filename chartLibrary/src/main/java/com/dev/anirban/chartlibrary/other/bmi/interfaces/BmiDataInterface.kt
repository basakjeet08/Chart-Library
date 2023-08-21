package com.dev.anirban.chartlibrary.other.bmi.interfaces

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.util.ChartPoint


/**
 * This is the Data Interface which has to be implemented by the class which makes a new
 * Implementation for the handling of data and calculations in the graph
 */
interface BmiDataInterface {

    /**
     * This is the reading which needs to be marked in the chart
     */
    val readingValue: ChartPoint<Float>

    /**
     * This is the number of X Axis Markers we want to show in the UI
     */
    val numOfXMarker: Int

    /**
     * This is the ideal weight which is given according to the BMI calculations
     */
    val idealWeight: ChartPoint<*>

    /**
     * This is the weight possessed and not the ideal weight that should be there
     */
    val weight: ChartPoint<*>

    /**
     * This function does the Calculations of the data and prepare their point
     * X and Y Axis positions according to the chart and requirements
     */
    fun DrawScope.doCalculations(size: Size)
}
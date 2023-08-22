package com.dev.anirban.chartlibrary.other.bmi.interfaces

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.util.ChartPoint
import com.dev.anirban.chartlibrary.other.bmi.data.BmiData


/**
 * This is the Data Interface which has to be implemented by the class which makes a new
 * Implementation for the handling of data and calculations in the graph
 *
 *  This class is implemented in [BmiData] and you can see this class too for the basic
 *  implementation of the class
 *
 * @see [BmiData]
 */
interface BmiDataInterface {

    /**
     * This is the reading which needs to be marked in the chart
     */
    val readingValue: ChartPoint<Float>

    /**
     * This variable contains the list of X Axis Markers below the graph
     */
    val xAxisPointers: MutableList<ChartPoint<Int>>

    /**
     * This is the number of X Axis Markers we want to show in the UI
     */
    val numOfXMarker: Int

    /**
     * This is the ideal weight which is given according to the BMI calculations
     */
    val idealWeight: String

    /**
     * This is the weight possessed and not the ideal weight that should be there
     */
    val weight: String


    /**
     * This variable contains the unit of the BMI calculation
     */
    val bmiUnit: String


    /**
     * This function does the Calculations of the data and prepare their point
     * X and Y Axis positions according to the chart and requirements
     */
    fun DrawScope.doCalculations(size: Size)
}
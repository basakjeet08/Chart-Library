package com.dev.anirban.chartlibrary.other.bmi.data

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiDataInterface
import com.dev.anirban.chartlibrary.util.ChartPoint


/**
 * This is one of the implementation for storing and calculating the data in the chart. It
 * Implements the [BmiDataInterface] Interface
 *
 * @param readingValue This is the readings
 * @param xAxisPointers These are the readings of the X - Axis
 * @param numOfXMarker These are the num of markers in X-axis
 * @param idealWeight This is the ideal weight for the Chart
 * @param weight This is the weight possessed by the user
 * @param bmiUnit This contains the Bmi Calculation Unit
 */
class BmiData(
    override val readingValue: ChartPoint<Float>,
    override val xAxisPointers: MutableList<ChartPoint<Int>> = mutableListOf(),
    override val numOfXMarker: Int = 5,
    override val idealWeight: String,
    override val weight: String,
    override val bmiUnit: String
) : BmiDataInterface {


    /**
     * This function gets the reading value and generate the X - Axis pointers list
     */
    init {

        // Checking if the values are already provided by the constructor or not
        if (xAxisPointers.isEmpty()) {

            // Finding the dividend factor which would make the middle element
            var dividendFactor = (readingValue.value / 5).toInt()
            if (dividendFactor < 2f) dividendFactor = 2

            // These are the margins of the Graph
            val firstItem = (dividendFactor - 2) * 5
            val secondItem = (dividendFactor - 1) * 5
            val thirdItem = dividendFactor * 5
            val fourthItem = (dividendFactor + 1) * 5
            val fifthItem = (dividendFactor + 2) * 5

            // Adding all the values in the X - Axis pointer variable for further computation
            xAxisPointers.add(ChartPoint(firstItem))
            xAxisPointers.add(ChartPoint(secondItem))
            xAxisPointers.add(ChartPoint(thirdItem))
            xAxisPointers.add(ChartPoint(fourthItem))
            xAxisPointers.add(ChartPoint(fifthItem))
        }
    }


    /**
     * This is the function which is responsible for the calculations of all the graph related stuff
     *
     * @param size This is the size of the whole canvas
     */
    override fun DrawScope.doCalculations(size: Size) {

        // X - Axis Scale
        val xScale = size.width / (numOfXMarker - 1)


        // Setting the coordinates of the reading value given through the constructor
        readingValue.setXCoordinate(xScale * ((readingValue.value - xAxisPointers[0].value) / 5f))
        readingValue.setYCoordinate(30f)


        // Setting the X - Axis pointers coordinates
        xAxisPointers.forEachIndexed { index, chartPoint ->
            chartPoint.setXCoordinate(index * xScale)
            chartPoint.setYCoordinate(150f)
        }
    }
}
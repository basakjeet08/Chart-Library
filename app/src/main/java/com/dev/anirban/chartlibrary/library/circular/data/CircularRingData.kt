package com.dev.anirban.chartlibrary.library.circular.data

import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface


/**
 * This class is the implementation of [CircularDataInterface] class which is responsible for
 * providing the implementation of business login and calculation logic behind the chart
 *
 * @param target This is the target variable
 * @param achieved This variable denotes the amount achieved
 * @property itemsList This is the List of items to be shown in the chart
 * @property sweepAngles This is the list of sweep angles which could be calculated
 */

class CircularRingData(
    override var target: Float,
    override var achieved: Float
) : CircularDataInterface {

    override val itemsList: List<Pair<String, Float>> = emptyList()
    override var sweepAngles: MutableList<Float> = mutableListOf()

    /**
     * This function calculates the sweep Angles
     */
    override fun doCalculations() {

        // Percentage of the target achieved by the user
        var percentage = (achieved / target)

        // Checking if the percentage is above 100 % or not
        if (percentage > 1)
            percentage = 1f

        val angle = percentage * 300f

        // Adding the angle to the sweepAngle list
        sweepAngles = mutableListOf(angle)
    }

}
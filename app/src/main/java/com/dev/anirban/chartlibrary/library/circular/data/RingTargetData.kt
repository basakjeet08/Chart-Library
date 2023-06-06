package com.dev.anirban.chartlibrary.library.circular.data


/**
 * This class is the implementation of [CircularTargetData] class which is responsible for
 * providing the implementation of business login and calculation logic behind the chart
 *
 * @param target This is the target variable
 * @param achieved This variable denotes the amount achieved
 * @property sweepAngles This is the list of sweep angles which could be calculated
 */

class RingTargetData(
    override var target: Float,
    override var achieved: Float
) : CircularTargetData(
    target = target,
    achieved = achieved
) {

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
package com.dev.anirban.chartlibrary.library.circular.data

/**
 * This class is the implementation of [CircularTargetData] class which is responsible for
 * providing the implementation of business login and calculation logic behind the chart
 *
 * @param target This is the target variable
 * @param achieved This variable denotes the amount achieved
 * @param siUnit This is the SI Unit text
 * @param cgsUnit This is the CGS Unit text
 * @param conversionRate This is the conversion rate according to which the CGS values can be
 * transformed into SI Unit
 *
 * @property sweepAngles This is the list of sweep angles which could be calculated
 */
class DonutTargetData(
    override var target: Float,
    override var achieved: Float,
    override val siUnit: String,
    override val cgsUnit: String,
    override val conversionRate: (Float) -> Float
) : CircularTargetData(
    target = target,
    achieved = achieved,
    siUnit = siUnit,
    cgsUnit = cgsUnit,
    conversionRate = conversionRate
) {

    override var sweepAngles: MutableList<Float> = mutableListOf()
    override val itemsList: List<Pair<String, Float>> = emptyList()

    /**
     * This function calculates the sweep Angles
     */
    override fun doCalculations() {

        // Percentage of the target achieved by the user
        var percentage = (achieved / target)

        // Checking if the percentage is above 100 % or not
        if (percentage > 1)
            percentage = 1f

        val angle = percentage * 360f

        // Adding the angle to the sweepAngle list
        sweepAngles = mutableListOf(angle)
    }
}
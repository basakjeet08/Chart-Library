package com.dev.anirban.chartlibrary.circular.data

/**
 * This data class helps building the target and achieved data type by being a wrapper class and
 * letting us formulate data to the respective class after turing the data into List
 *
 * @param target This is the target variable
 * @param achieved This variable denotes the amount achieved
 * @param siUnit This is the SI Unit text
 * @param cgsUnit This is the CGS Unit text
 * @param conversionRate This is the conversion rate according to which the CGS values can be
 * transformed into SI Unit
 */
class CircularTargetDataBuilder(
    var target: Float,
    var achieved: Float,
    val siUnit: String,
    val cgsUnit: String,
    val conversionRate: (Float) -> Float
) {

    /**
     * This function converts the [CircularTargetDataBuilder] class object into [CircularDonutTargetData] object
     */
    fun toCircularDonutTargetData() = CircularDonutTargetData(
        itemsList = listOf(
            Pair("Target", target),
            Pair("Achieved", achieved)
        ),
        siUnit = siUnit,
        cgsUnit = cgsUnit,
        conversionRate = conversionRate
    )

    /**
     * This function converts the [CircularTargetDataBuilder] class object into [CircularRingTargetData] class object
     */
    fun toCircularRingTargetData() = CircularRingTargetData(
        itemsList = listOf(
            Pair("Target", target),
            Pair("Achieved", achieved)
        ),
        siUnit = siUnit,
        cgsUnit = cgsUnit,
        conversionRate = conversionRate
    )
}
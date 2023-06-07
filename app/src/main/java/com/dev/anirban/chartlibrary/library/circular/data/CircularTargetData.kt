package com.dev.anirban.chartlibrary.library.circular.data

import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface


/**
 * This class is the implementation of [CircularDataInterface] class which is responsible for
 * providing the implementation of business login and calculation logic behind the chart
 *
 * @param target This is the target variable
 * @param achieved This variable denotes the amount achieved
 * @param siUnit This is the SI Unit text
 * @param cgsUnit This is the CGS Unit text
 * @param conversionRate This is the conversion rate according to which the CGS values can be
 * transformed into SI Unit
 *
 * @property itemsList This is the List of items to be shown in the chart
 * @property sweepAngles This is the list of sweep angles which could be calculated
 */
abstract class CircularTargetData(
    override var target: Float,
    override var achieved: Float,
    override val siUnit: String,
    override val cgsUnit: String,
    override val conversionRate: (Float) -> Float
) : CircularDataInterface {

    override val itemsList: List<Pair<String, Float>> = emptyList()
    override var sweepAngles: MutableList<Float> = mutableListOf()
}
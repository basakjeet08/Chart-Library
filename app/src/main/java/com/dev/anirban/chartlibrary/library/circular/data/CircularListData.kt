package com.dev.anirban.chartlibrary.library.circular.data

import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface


/**
 * This class is the implementation of [CircularDataInterface] class which is responsible for
 * providing the implementation of business login and calculation logic behind the chart
 *
 * @param itemsList This is the List of items to be shown in the chart
 * @param siUnit This is the SI Unit text
 * @param cgsUnit This is the CGS Unit text
 * @param conversionRate This is the conversion rate according to which the CGS values can be
 * transformed into SI Unit
 *
 * @property sweepAngles This is the list of sweep angles which could be calculated
 * @property target This is the target variable
 * @property achieved This variable denotes the amount achieved
 */
abstract class CircularListData(
    override val itemsList: List<Pair<String, Float>>,
    override val siUnit: String,
    override val cgsUnit: String,
    override val conversionRate: (Float) -> Float
) : CircularDataInterface {

    override var sweepAngles: MutableList<Float> = mutableListOf()
    override var target: Float = 0f
    override var achieved: Float = 0f
}
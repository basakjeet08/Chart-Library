package com.dev.anirban.chartlibrary.library.circular.data

import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface

/**
 * This class is the implementation of [CircularDataInterface] class which is responsible for
 * providing the implementation of business login and calculation logic behind the chart
 *
 * @param itemsList This is the List of items to be shown in the chart
 * @property sweepAngles This is the list of sweep angles which could be calculated
 * @property target This is the target variable
 * @property achieved This variable denotes the amount achieved
 */
class CircularData(
    override val itemsList: List<Pair<String, Float>>
) : CircularDataInterface {

    override var sweepAngles: MutableList<Float> = mutableListOf()
    override var target: Float = Float.NaN
    override var achieved: Float = Float.NaN

    /**
     * This function calculates the sweep Angles
     */
    override fun doCalculations() {

        // Extracting the Floating values from the given list
        val dataList = itemsList.map { it.second }

        // Stores the sum of all the items in the list
        val sum = dataList.sum()

        /**
         * some value is subtracted because according to the UI there shall be some free space
         * between each graph.
         *
         * Free Space = Some Angles shall be subtracted so that
         *
         * We are taking a 4f minus between each and every Floating Data
         */
        sweepAngles = dataList.map { (it / sum) * (360f - (dataList.size * 4f)) }.toMutableList()

    }
}
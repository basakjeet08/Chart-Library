package com.dev.anirban.chartlibrary.library.circular.data

/**
 * This class is the implementation of [CircularListData] class which is responsible for
 * providing the implementation of business login and calculation logic behind the chart
 *
 * @param itemsList This is the List of items to be shown in the chart
 * @property sweepAngles This is the list of sweep angles which could be calculated
 */
class DonutListData(
    override val itemsList: List<Pair<String, Float>>
) : CircularListData(
    itemsList = itemsList
) {

    override var sweepAngles: MutableList<Float> = mutableListOf()

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
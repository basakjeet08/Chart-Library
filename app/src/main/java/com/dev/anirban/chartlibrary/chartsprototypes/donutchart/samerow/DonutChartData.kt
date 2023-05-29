package com.dev.anirban.chartlibrary.chartsprototypes.donutchart.samerow

class DonutChartData(
    val itemsList: List<Pair<String, Float>>
) {
    val sweepAngles : MutableList<Float> = mutableListOf()

    init {
        calculate()
    }

    private fun calculate() {

        // List of all the Floating Numbers which will be used to display Chart
        val valueList: MutableList<Float> = mutableListOf()

        // Initializing the List
        itemsList.forEachIndexed { _, pair ->
            valueList.add(pair.second)
        }

        // Total of the Data
        var total = 0f

        // Calculating Total
        valueList.forEach {
            total += it
        }

        // Calculating the SweepAngles
        valueList.forEach { fl ->

            val percentage = (fl / total)

            /**
             * some value is subtracted because according to the UI there shall be some free space
             * between each graph.
             *
             * Free Space = Some Angles shall be subtracted so that
             *
             * We are taking a 4f minus between each and every Floating Datas
             */
            val angle = percentage * (360f - (valueList.size * 4f))
            sweepAngles.add(angle)
        }
    }
}
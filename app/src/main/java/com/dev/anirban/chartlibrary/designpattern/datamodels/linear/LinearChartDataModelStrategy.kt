package com.dev.anirban.chartlibrary.designpattern.datamodels.linear

import android.util.Log.d
import com.dev.anirban.chartlibrary.designpattern.datamodels.ChartDataModel

class LinearChartDataModelStrategy(
    private val data: String = "Linear Data"
) : ChartDataModel {

    private val tag = "Linear Chart Data Model"

    override fun doCalculations() {
        d(tag, "do Calculation on $data")
    }
}
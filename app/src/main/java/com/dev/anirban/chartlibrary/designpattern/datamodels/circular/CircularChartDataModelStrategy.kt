package com.dev.anirban.chartlibrary.designpattern.datamodels.circular

import android.util.Log.d
import com.dev.anirban.chartlibrary.designpattern.datamodels.ChartDataModel

class CircularChartDataModelStrategy(
    private val data: String = "Circular Data"
) : ChartDataModel {

    private val tag = "Circular Data"

    override fun doCalculations() {
        d(tag, "do Calculation on $data")
    }
}
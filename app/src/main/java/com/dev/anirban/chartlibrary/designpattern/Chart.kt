package com.dev.anirban.chartlibrary.designpattern

import com.dev.anirban.chartlibrary.designpattern.chartbuilder.ChartBuilder
import com.dev.anirban.chartlibrary.designpattern.datamodels.ChartDataModel

class Chart(
    private val chartBuilder: ChartBuilder,
    private val chartDataModel: ChartDataModel
) : ChartBuilder, ChartDataModel {

    override fun drawForeground() {
        chartBuilder.drawForeground()
    }

    override fun drawBackground() {
        chartBuilder.drawBackground()
    }

    override fun drawMargins() {
        chartBuilder.drawMargins()
    }

    override fun drawOthers() {
        chartBuilder.drawOthers()
    }

    override fun doCalculations() {
        chartDataModel.doCalculations()
    }

    fun build() {
        doCalculations()
        drawBackground()
        drawMargins()
        drawForeground()
        drawOthers()
    }
}
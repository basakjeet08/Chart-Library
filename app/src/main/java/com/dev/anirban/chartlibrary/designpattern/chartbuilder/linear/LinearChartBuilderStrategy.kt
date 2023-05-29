package com.dev.anirban.chartlibrary.designpattern.chartbuilder.linear

import android.util.Log.d
import com.dev.anirban.chartlibrary.designpattern.chartbuilder.ChartBuilder

class LinearChartBuilderStrategy : ChartBuilder {

    private val tag = "Linear Builder"

    override fun drawForeground() {
        d(tag, "draw foreground")
    }

    override fun drawBackground() {
        d(tag, "draw Background")
    }

    override fun drawMargins() {
        d(tag, "draw Margins")
    }

    override fun drawOthers() {
        d(tag, "draw Others")
    }
}
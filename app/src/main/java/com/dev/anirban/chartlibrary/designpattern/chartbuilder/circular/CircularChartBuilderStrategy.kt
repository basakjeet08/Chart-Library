package com.dev.anirban.chartlibrary.designpattern.chartbuilder.circular

import android.util.Log.d
import com.dev.anirban.chartlibrary.designpattern.chartbuilder.ChartBuilder

class CircularChartBuilderStrategy : ChartBuilder {

    private val tag = "Circular Builder"

    override fun drawForeground() {
        d(tag, "draw foreground")
    }

    override fun drawBackground() {
        d(tag, "draw background")
    }

    override fun drawMargins() {
        d(tag, "draw margins")
    }

    override fun drawOthers() {
        d(tag, "draw Others")
    }
}
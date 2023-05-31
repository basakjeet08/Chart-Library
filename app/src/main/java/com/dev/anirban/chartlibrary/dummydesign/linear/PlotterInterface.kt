package com.dev.anirban.chartlibrary.dummydesign.linear

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChartDecoration

interface PlotterInterface<T> {
    fun DrawScope.drawPlotting(linearData: LinearData<T>, lineChartDecoration: LineChartDecoration)
}
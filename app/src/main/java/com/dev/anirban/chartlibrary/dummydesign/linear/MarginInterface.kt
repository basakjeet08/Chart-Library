package com.dev.anirban.chartlibrary.dummydesign.linear

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChartDecoration

interface MarginInterface<T> {

    fun DrawScope.drawMargins(linearData: LinearData<T>, lineChartDecoration: LineChartDecoration)
}
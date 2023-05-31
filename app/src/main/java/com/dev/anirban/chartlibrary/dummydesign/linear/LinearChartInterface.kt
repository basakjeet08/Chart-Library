package com.dev.anirban.chartlibrary.dummydesign.linear

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChartDecoration

interface LinearChartInterface<T> {

    val plotterInterface: PlotterInterface<T>
    val linearData: LinearData<T>
    val lineChartDecoration: LineChartDecoration
    val marginInterface: MarginInterface<T>

    fun DrawScope.drawMargins()

    fun DrawScope.drawPlotting()

    @Composable
    fun Build(modifier: Modifier, height: Dp)
}
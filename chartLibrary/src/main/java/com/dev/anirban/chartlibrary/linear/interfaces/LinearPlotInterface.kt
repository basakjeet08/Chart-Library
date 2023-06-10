package com.dev.anirban.chartlibrary.linear.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration
import com.dev.anirban.chartlibrary.linear.plots.*

/**
 * This is the interface which needs to be every graph plot logic to work in the Library
 *
 * Implementations for this interface are :- [LinearBarPlot] , [LinearLinePlot]
 */
interface LinearPlotInterface {

    /**
     * This function plots the graph points
     */
    fun DrawScope.plotChart(
        linearData: LinearDataInterface,
        decoration: LinearDecoration
    )
}
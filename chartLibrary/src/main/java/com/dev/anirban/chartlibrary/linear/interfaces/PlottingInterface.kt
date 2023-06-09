package com.dev.anirban.chartlibrary.linear.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration

/**
 * This is the interface which needs to be every graph plot logic to work in the Library
 */
interface PlottingInterface {

    /**
     * This function plots the graph points
     */
    fun DrawScope.plotChart(
        linearData: LinearDataInterface,
        decoration: LinearDecoration
    )
}
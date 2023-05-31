package com.dev.anirban.chartlibrary.designpattern.linear.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope

/**
 * This is the interface which needs to be every graph plot logic to work in the Library
 */
interface PlottingInterface {

    /**
     * This function plots the graph points
     */
    fun DrawScope.plotChart(
        linearData: LinearDataInterface,
        decoration: LinearDecorationInterface
    )
}
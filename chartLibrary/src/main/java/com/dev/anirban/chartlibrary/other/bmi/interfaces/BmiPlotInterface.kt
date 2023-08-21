package com.dev.anirban.chartlibrary.other.bmi.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.other.bmi.plots.BmiPlot
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations

/**
 * This is the interface which needs to be every bmi graph plot logic to work in the Library
 *
 * Implementations for this interface are :- [BmiPlot]
 */
interface BmiPlotInterface {

    /**
     * This function plots the graph points
     */
    fun DrawScope.plotChart(
        bmiData: BmiDataInterface,
        decoration: BmiDecorations
    )
}
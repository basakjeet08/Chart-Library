package com.dev.anirban.chartlibrary.other.bmi.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations

interface BmiPlotInterface {

    /**
     * This function plots the graph points
     */
    fun DrawScope.plotChart(
        bmiData: BmiDataInterface,
        decoration: BmiDecorations
    )
}
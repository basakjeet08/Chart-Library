package com.dev.anirban.chartlibrary.other.bmi.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations


/**
 * This is the interface which defines that all the Implementation for the Drawing of the margins
 * need to implement this interface.
 */
interface BmiMarginInterface {

    /**
     * This function draws the margins in the graph according to the implementation passed
     *
     * @param bmiData This is the data for the graph
     * @param decoration This is the decoration for the graph
     */
    fun DrawScope.drawMargin(
        bmiData: BmiDataInterface,
        decoration: BmiDecorations
    )
}
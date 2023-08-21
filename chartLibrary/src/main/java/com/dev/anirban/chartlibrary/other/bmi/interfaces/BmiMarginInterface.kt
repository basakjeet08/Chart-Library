package com.dev.anirban.chartlibrary.other.bmi.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations
import com.dev.anirban.chartlibrary.other.bmi.margins.BmiMargin


/**
 * This is the interface which defines that all the Implementation for the Drawing of the margins
 * need to implement this interface.
 *
 * It is also implemented in the [BmiMargin] class and we can further refer to that class for the
 * in - depth knowledge of how it is implemented
 *
 * @see [BmiMargin]
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
package com.dev.anirban.chartlibrary.linear.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration
import com.dev.anirban.chartlibrary.linear.margins.LinearStringMargin

/**
 * This is the interface which defines that all the Implementation for the Drawing of the margins
 * need to implement this interface.
 *
 * Implementations for this interface are :- [LinearStringMargin]
 *
 */
interface LinearMarginInterface {

    /**
     * This function draws the margins in the graph according to the implementation passed
     *
     * @param linearData This is the data for the graph
     * @param decoration This is the decoration for the graph
     */
    fun DrawScope.drawMargin(
        linearData: LinearDataInterface,
        decoration: LinearDecoration
    )
}
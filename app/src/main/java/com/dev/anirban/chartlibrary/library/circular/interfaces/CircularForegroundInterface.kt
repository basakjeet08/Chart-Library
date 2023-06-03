package com.dev.anirban.chartlibrary.library.circular.interfaces

import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.library.circular.decoration.CircularDecoration

/**
 * This interface needs to be implemented by all the classes which wants to make different
 * implementations for drawing the readings in the chart
 *
 * @property drawForeground This function draws the foreground using its own implementation
 */
interface CircularForegroundInterface {

    fun DrawScope.drawForeground(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    )
}
package com.dev.anirban.chartlibrary.circular.interfaces

import androidx.compose.runtime.Composable
import com.dev.anirban.chartlibrary.circular.center.*
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration

/**
 * This interface implements a function to draw the center of the circular chart
 *
 * Different Implementations for the interface are [CircularDefaultCenter],
 * [CircularRingTextCenter],[CircularTargetTextCenter]
 */
interface CircularCenterInterface {

    /**
     * This function draws composable function in the center of the chart
     *
     * @param circularData This is the data related to the Circular Chart
     * @param decoration This is the decorations for the chart
     */
    @Composable
    fun DrawCenter(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    )
}
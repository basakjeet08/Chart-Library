package com.dev.anirban.chartlibrary.library.circular.interfaces

import androidx.compose.runtime.Composable

/**
 * This interface implements a function to draw the center of the circular chart
 */
interface CircularCenterInterface {

    /**
     * This function draws composable function in the center of the chart
     */
    @Composable
    fun DrawCenter(
        circularData: CircularDataInterface
    )
}
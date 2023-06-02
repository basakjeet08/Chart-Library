package com.dev.anirban.chartlibrary.designpattern.circular.center

import androidx.compose.runtime.Composable
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularCenterInterface

/**
 * This class is the implementation of [CircularCenterInterface] which focuses on providing an
 * implementation to draw something on the center of the Circular Chart
 *
 * This Class in particular is the implementation to draw nothing and it is served as a Default
 * implementation
 */
class CircularDefaultCenter : CircularCenterInterface {

    /**
     * This function does nothing which is fine since we want the default Circle Center to be nothing
     */
    @Composable
    override fun DrawCenter() {
        // Does Nothing
    }
}
package com.dev.anirban.chartlibrary.designpattern.circular

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.designpattern.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularChartInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularForegroundInterface

/**
 * This class extends from the [CircularChartInterface] which means its the root level class
 *
 * @property circularCenter Implementation for the center of the chart
 * @property circularData Implementation for the data of the chart
 * @property circularDecoration Implementation for the decoration of the chart
 * @property circularForeground Implementation for the foreground of the chart
 * @property circularColorConvention Implementation for the color convention of the chart
 *
 * @property DrawCenter This function draws the center of the chart
 * @property doCalculations This function does the calculation of the chart
 * @property drawForeground This function draws the foreground of the chart
 * @property DrawColorConventions This function draws the Color Convention of the chart
 * @property Build This function starts building the circular Chart
 */
open class CircularChart(
    override val circularCenter: CircularCenterInterface,
    override val circularData: CircularDataInterface,
    override val circularDecoration: CircularDecoration,
    override val circularForeground: CircularForegroundInterface,
    override val circularColorConvention: CircularColorConventionInterface
) : CircularChartInterface {

    /**
     * Function to draw something on the center
     */
    @Composable
    override fun DrawCenter() {
        circularCenter.DrawCenter(
            circularData = circularData
        )
    }

    /**
     * This function does mostly handle business and calculation related
     */
    override fun doCalculations() {
        circularData.doCalculations()
    }

    /**
     * This function draws the foreground
     */
    override fun DrawScope.drawForeground() {
        circularForeground.apply {
            drawForeground(
                circularData = circularData,
                decoration = circularDecoration
            )
        }
    }

    /**
     * This function draws the Color Convention in the chart
     */
    @Composable
    override fun DrawColorConventions() {
        circularColorConvention.DrawColorConventions(
            circularData = circularData,
            decoration = circularDecoration
        )
    }

    /**
     * This function starts building the canvas chart
     */

    @Composable
    override fun Build(modifier: Modifier) {

        Canvas(
            modifier = modifier
        ) {

            // Calling all the necessary functions
            doCalculations()
            drawForeground()
        }
    }
}
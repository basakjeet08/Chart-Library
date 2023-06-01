package com.dev.anirban.chartlibrary.designpattern.linear

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.LinearChartInterface
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.LinearDecorationInterface
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.MarginInterface
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.PlottingInterface

/**
 * This is the base class which directly implements the [LinearDataInterface] interfaces.
 *
 * @param margin This is the implementation for drawing the Margins
 * @param decoration This is the implementation for drawing the Decorations
 * @param linearData This is the implementation for keeping the Linear Chart data and calculations
 * @param plotting This is the implementation for how shall the plotting be drawn on the graph
 */
class LinearChart(
    override val margin: MarginInterface,
    override val decoration: LinearDecorationInterface,
    override val linearData: LinearDataInterface,
    override val plotting: PlottingInterface
) : LinearChartInterface {

    /**
     * This function draws the margins according to the margin implementation passed to it
     */
    override fun DrawScope.drawMargin() {
        margin.apply {
            drawMargin(
                linearData = linearData,
                decoration = decoration
            )
        }
    }

    /**
     * This function draws the plotting of the chart
     */
    override fun DrawScope.plotChart() {
        plotting.apply {
            plotChart(
                linearData = linearData,
                decoration = decoration
            )
        }
    }

    /**
     * This function basically starts making the composable function and making the canvas graph
     */
    @Composable
    override fun Build(modifier: Modifier) {

        Canvas(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 4.dp)
        ) {

            // Calling all the necessary functions
            linearData.doCalculations(size)
            drawMargin()
            plotChart()
        }
    }
}
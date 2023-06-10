package com.dev.anirban.chartlibrary.linear.interfaces

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration

/**
 * This interface in the interface which every Linear Chart Implementation has to implement for the
 * Library to work
 *
 */
interface LinearChartInterface {

    /**
     * This is the implementation of the [MarginInterface]. The margins will be drawn in the graph
     * according to the implementation
     *
     * @see MarginInterface
     */
    val margin: MarginInterface

    /**
     * This is the implementation of the [LinearDecoration]. The decoration will be drawn
     * in the graph according to the implementation
     *
     * @see LinearDecoration
     */
    val decoration: LinearDecoration

    /**
     * This is the implementation of the [LinearDataInterface]. The data will be calculated according
     * to this business Login
     *
     * @see LinearDataInterface
     */
    val linearData: LinearDataInterface

    /**
     * This is the implementation of the [PlottingInterface]. The plot will be drawn in the graph
     * according to the implementation
     *
     * @see PlottingInterface
     */
    val plotting: PlottingInterface

    /**
     * This is the implementation of [LinearColorConventionInterface]. This provides an implementation for
     * drawing the color conventions in the chart
     */
    val colorConvention: LinearColorConventionInterface

    /**
     * This function draws the margin according to the implementation provided to it
     */
    fun DrawScope.drawMargin()

    /**
     * This function draws the plot according to the plot implementation provided to us
     */
    fun DrawScope.plotChart()

    /**
     * This function calls the color convention implementation and draws the color conventions
     */
    @Composable
    fun DrawColorConvention()

    /**
     * This is the Build Function which starts composing the Charts and composes the Charts
     *
     * @param modifier This is for default modifications to be passed from the parent Class
     */
    @Composable
    fun Build(modifier: Modifier)
}
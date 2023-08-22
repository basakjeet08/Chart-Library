package com.dev.anirban.chartlibrary.other.bmi.interfaces

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations


/**
 * This interface in the interface which every BMI Chart Implementation has to implement for the
 * Library to work
 */
interface BmiChartInterface {


    /**
     * This is the implementation of the [BmiMarginInterface]. The margins will be drawn in the graph
     * according to the implementation
     *
     * @see BmiMarginInterface
     */
    val marginImpl: BmiMarginInterface


    /**
     * This is the implementation of the [BmiDecorations]. The decoration will be drawn
     * in the graph according to the implementation
     *
     * @see BmiDecorations
     */
    val decoration: BmiDecorations


    /**
     * This is the implementation of the [BmiDataInterface]. The data will be calculated according
     * to this business Login
     *
     * @see BmiDataInterface
     */
    val bmiData: BmiDataInterface


    /**
     * This is the implementation of the [BmiPlotInterface]. The plot will be drawn in the graph
     * according to the implementation
     *
     * @see BmiPlotInterface
     */
    val bmiPlot: BmiPlotInterface


    /**
     * This is the implementation of the [BmiBodyInterface].The Body of the BMI Chart would be drawn
     * according to this implementation.
     *
     * @see [BmiBodyInterface]
     */
    val bmiBody: BmiBodyInterface


    /**
     * This function draws the margin according to the implementation provided to it
     */
    fun DrawScope.drawMargin()


    /**
     * This function draws the plot according to the plot implementation provided to us
     */
    fun DrawScope.plotChart()


    /**
     * This is the Build Function which starts composing the Charts and composes the Charts
     *
     * @param modifier This is for default modifications to be passed from the parent Class
     */
    @Composable
    fun Build(modifier: Modifier)
}
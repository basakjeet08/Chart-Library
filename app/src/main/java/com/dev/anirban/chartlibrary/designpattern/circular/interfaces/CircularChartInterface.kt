package com.dev.anirban.chartlibrary.designpattern.circular.interfaces

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.designpattern.circular.decoration.CircularDecoration

/**
 * This is the interface which is implemented by the Circular Chart Class which is the root class
 * of all the circular Chart Classes
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
interface CircularChartInterface {


    val circularCenter: CircularCenterInterface
    val circularData: CircularDataInterface
    val circularDecoration: CircularDecoration
    val circularForeground: CircularForegroundInterface
    val circularColorConvention: CircularColorConventionInterface

    @Composable
    fun DrawCenter()

    fun doCalculations()

    fun DrawScope.drawForeground()

    @Composable
    fun DrawColorConventions()

    @Composable
    fun Build(modifier: Modifier)
}
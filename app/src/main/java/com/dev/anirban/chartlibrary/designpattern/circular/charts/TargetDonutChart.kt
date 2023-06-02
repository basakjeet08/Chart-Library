package com.dev.anirban.chartlibrary.designpattern.circular.charts

import com.dev.anirban.chartlibrary.designpattern.circular.CircularChart
import com.dev.anirban.chartlibrary.designpattern.circular.center.CircularTextCenter
import com.dev.anirban.chartlibrary.designpattern.circular.colorconvention.TargetColorCorrection
import com.dev.anirban.chartlibrary.designpattern.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.designpattern.circular.foreground.DonutChartForeground
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularForegroundInterface

/**
 * This class is the sub - class of [CircularChart] class which is the root parent class of the
 * circular charts.
 *
 * This class in general provides an implementation for a donut chart which has its color conventions
 * in the same row as itself.
 *
 * @param circularCenter This is the implementation which draws the center of the circle
 * @param circularData This is the data class implementation which handles the data
 * @param circularDecoration This is the decorations for the Circular Chart
 * @param circularForeground This is the implementation which draws the foreground of the chart
 * @param circularColorConvention This is the color Convention implementation of the chart
 */
class TargetDonutChart(
    override val circularCenter: CircularCenterInterface = CircularTextCenter(),
    override val circularData: CircularDataInterface,
    override val circularDecoration: CircularDecoration,
    override val circularForeground: CircularForegroundInterface = DonutChartForeground(),
    override val circularColorConvention: CircularColorConventionInterface = TargetColorCorrection()
) : RowDonutChart(
    circularCenter,
    circularData,
    circularDecoration,
    circularForeground,
    circularColorConvention
)